package com.example.readly;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.graphics.shapes.Utils;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

public class AddBookFragment extends Fragment {
    private static final int GALLERY_REQUEST_CODE = 123;
    ImageView img;
    private String imageStr;
    private EditText ettitle,etprice,etauthur,etid,
            etyear,etcategory,etphoto;
    private Button btnAddbook;
    private FirebaseServices fbs;
    private String title;
    private String id;
    private String photo;
    private String category;
    private String authur;
    private Spinner yearOfCarSpinner;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_book, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        init();
    }

    private void init() {


        fbs=FirebaseServices.getInstance();
        etid=getView().findViewById(R.id.rvCarsSearchFragment);
        etauthur=getView().findViewById(R.id.rvCarsSearchFragment);
        etcategory=getView().findViewById(R.id.etPhoneSignupFragment);
        etyear=getView().findViewById(R.id.etPhoneSignupFragment);
        etphoto=getView().findViewById(R.id.rvCarsSearchFragment);
        ettitle=getView().findViewById(R.id.etLastnameSignupFragment);


        yearOfCarSpinner=getView().findViewById(R.id.searchEndYearSpinner);
        ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(getActivity(), R.layout.activity_main,years);
        adapter2.setDropDownViewResource(R.layout.activity_main);
        yearOfCarSpinner.setAdapter(adapter2);

        yearOfCarSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value=parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    private void addToFirestore() {

        String nameCar, horse_power, owners, phone,
                car_num, manufacturer, year, car_type, Car_model,
                test ,kilometre,Engine_capacity,Gear_shifting_model,price ;
        String color;

        title=ettitle.getText().toString();
        id=etid.getText().toString();
        year=etyear.getText().toString();
        photo = etphoto.getText().toString();
        category=etcategory.getText().toString();
        authur=etauthur.getText().toString();
        price=etprice.getText().toString();


        if (price.trim().isEmpty()
                ||
              authur.trim().isEmpty()                               ||
                year.trim().isEmpty()                                       ||
               photo.trim().isEmpty()                                  ||
                title.trim().isEmpty()                                       ||
                id.trim().isEmpty()                                  ||
                category.trim().isEmpty()                            ||
                price.trim().isEmpty())

        {
            Toast.makeText(getActivity(), "sorry some data missing incorrect !", Toast.LENGTH_SHORT).show();
            return;
        }

        Book book = null;

        if (fbs.getSelectedImageURL() == null)
        {
            book= new Book(title,year,photo,authur,id,category,price);

        }


        fbs.getFire().collection("books").add(book)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(), "ADD book is Succesed ", Toast.LENGTH_SHORT).show();
                        Log.e("addToFirestore() - add to collection: ", "Successful!");
                        gotoCarList();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("addToFirestore() - add to collection: ", e.getMessage());
                    }
                });

    }



    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == getActivity().RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            img.setImageURI(selectedImageUri);
        }
    }

    public void gotoBookList() {

        FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,new BookListFragment());
        ft.commit();
    }



}