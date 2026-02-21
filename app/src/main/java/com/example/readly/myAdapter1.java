package com.example.readly;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter1 extends RecyclerView.Adapter {
    private myAdapter1.OnItemClickListener onItemClickListener;

    public myAdapter1(FragmentActivity activity, ArrayList<Book> list) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setOnItemClickListener(myAdapter1.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public myAdapter1.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public static class OnItemClickListener {
        public void onItemClick(int position) {
            // Handle item click here
            /*
            String selectedItem = list.get(position).get();
            Toast.makeText(getActivity(), "Clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
            Bundle args = new Bundle();
            args.putParcelable("car", list.get(position)); // or use Parcelable for better performance
            CarDetailsFragment cd = new CarDetailsFragment();
            cd.setArguments(args);
            FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout,cd);
            ft.commit();*/
        }
    }
}
