package edu.polytech.gotoslim.conseil;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import edu.polytech.gotoslim.R;
import edu.polytech.gotoslim.conseil.listCreation.Ilistener;
import edu.polytech.gotoslim.conseil.listCreation.Meal;
import edu.polytech.gotoslim.conseil.listCreation.MealAdapter;
import edu.polytech.gotoslim.conseil.listCreation.lists.FactoryList;
import edu.polytech.gotoslim.conseil.listCreation.lists.MealList;


public class ListMeal extends Fragment implements Ilistener {

    private Ilistener mCallback;

    public ListMeal() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result= inflater.inflate(R.layout.fragment_list_meal, container, false);

        String type = requireActivity().getIntent().getExtras().getString("typeMeal");
        MealList meals = (new FactoryList()).createList(type);

        MealAdapter adapter = new MealAdapter(requireContext().getApplicationContext(), meals);

        ListView list = result.findViewById(R.id.listViewMeal);
        list.setAdapter(adapter);

        adapter.addListener(this);
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

    @Override
    public void onClick(Meal item) {
        mCallback.onClick(item);
    }
}