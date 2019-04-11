package com.szg_tech.cvdevaluator.fragments.evaluation_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.core.ConfigurableFragment;
import com.szg_tech.cvdevaluator.core.views.ButtonWithChevron;

public class EvaluationListFragment extends ConfigurableFragment implements EvaluationListView {
    EvaluationListPresenter presenter = createPresenter();
    RecyclerView recyclerView;
    ButtonWithChevron bottomButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.evaluation_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        recyclerView = view.findViewById(R.id.recycler_view);
        bottomButton = view.findViewById(R.id.bottom_button);
        bottomButton.setOnClickListener(v -> presenter.onBottomButtonClick());
        presenter.onCreate();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public EvaluationListPresenter createPresenter() {
        return new EvaluationListPresenterImpl(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);

        if (presenter.isAboutScreen()) {
            menu.clear();
        } else {
            if (presenter.isEvaluationScreen()) {
                menu.findItem(R.id.home).setVisible(false);
                menu.findItem(R.id.reset_field).setVisible(false);
            } else {
                menu.findItem(R.id.save_evaluation).setVisible(false);
                menu.findItem(R.id.exit_evaluation).setVisible(false);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return presenter.onOptionsItemSelected(item);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public ButtonWithChevron getBottomButton() {
        return bottomButton;
    }
}
