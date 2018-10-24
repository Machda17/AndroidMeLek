package com.example.dell.modul2_pemrogramanplatformmobile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class BodyPartsFragments extends Fragment {

    private List<Integer>mImageIds;
    private Integer mListIndex;
    //membuat tag
    private static String TAG="BodyPartFragment";
    public static final String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX = "list_index";


    public void onSaveInstanceState(@NonNull Bundle currentState) {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }
    //membuat variabel bebas dan membuat fungsi setter
    public BodyPartsFragments() {
    }

    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(Integer mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //membuat fungsi Pada awal saat melakukan “create fragment” berikan statment jika “saved instance” tidak ‘null’
        //maka variabel array dan index memanggal keadaan sebelumnya
        if (savedInstanceState !=null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        //inisiasi activity tersebut sebagai fragment
        View rootView = inflater.inflate((R.layout.body_part_layout_fragment), container, false);
        //mereferensi id yang ada di layout fragment
        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView_body_part_layout_fragment);
        //ambil gambar untuk ditampilkan
        imageView.setImageResource(mImageIds.get(mListIndex));

        //untung merubah gambar bila di klik sesuai dengan isi image assets
        if(mImageIds != null){
            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListIndex < mImageIds.size()-1){
                        mListIndex++;
                    }else {
                        mListIndex = 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        } else {
            Log.v(TAG, "This fragment has a null list of image id's");
        }
        return rootView;
    }


}
