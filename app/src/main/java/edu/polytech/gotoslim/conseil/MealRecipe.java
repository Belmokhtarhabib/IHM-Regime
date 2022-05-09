package edu.polytech.gotoslim.conseil;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.conseil.listCreation.Ilistener;
import edu.polytech.gotoslim.conseil.listCreation.Meal;
import edu.polytech.gotoslim.conseil.listCreation.basedonne.DataBase;

public class MealRecipe extends Fragment implements Ilistener {

    private Ilistener mCallback;
    View result;
    Meal meal = null;

    public MealRecipe() {
    }

    public MealRecipe(Meal meal) {
        this.meal = meal;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.result = inflater.inflate(R.layout.fragment_meal_recipe, container, false);

        if(meal == null) meal = requireActivity().getIntent().getParcelableExtra("item");
        if(meal!=null) {
            foundBaseRecette(meal.getRecipe());
        }
        return result;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.createCallbackToParentActivity();
    }

    private void createCallbackToParentActivity(){
        try {
            mCallback = (Ilistener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e + " must implement OnButtonClickedListener");
        }
    }

    private void foundBaseRecette(String ingredient){
        DatabaseReference dataBase = DataBase.getInstance().getReference();
        DatabaseReference url = dataBase.child(ingredient);
        url.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String elemUrl = snapshot.getValue(String.class);
                WebView link = ((WebView) result.findViewById(R.id.WebView));
                link.setWebViewClient(new WebViewClient());
                link.loadUrl(elemUrl);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("canceled bdd");
            }
        });
    }

    @Override
    public void onClick(Meal item) {
        mCallback.onClick(item);
    }
}