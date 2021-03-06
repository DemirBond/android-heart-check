package com.szg_tech.heartcheck.fragments.evaluation_list;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.SnackbarContentLayout;
import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.activities.evaluation.EvaluationActivity;
import com.szg_tech.heartcheck.core.AbstractPresenter;
import com.szg_tech.heartcheck.core.ConfigurationParams;
import com.szg_tech.heartcheck.core.EvaluationDataHelper;
import com.szg_tech.heartcheck.core.ListRecyclerViewAdapter;
import com.szg_tech.heartcheck.core.views.modal.AlertModalManager;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.TabEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_items.About;
import com.szg_tech.heartcheck.fragments.output.OutputFragment;
import com.szg_tech.heartcheck.fragments.tab_fragment.TabFragment;
import com.szg_tech.heartcheck.rest.api.RestClient;
import com.szg_tech.heartcheck.rest.requests.EvaluationRequest;
import com.szg_tech.heartcheck.rest.responses.EvaluationResponse;
import com.szg_tech.heartcheck.storage.EvaluationDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.szg_tech.heartcheck.core.ConfigurationParams.NEXT_SECTION_ABOUT;
import static com.szg_tech.heartcheck.core.ConfigurationParams.NEXT_SECTION_HEART_SPECIALIST;
import static com.szg_tech.heartcheck.core.ConfigurationParams.NEXT_SECTION_HOME_SCREEN;

class EvaluationListPresenterImpl extends AbstractPresenter<EvaluationListView> implements EvaluationListPresenter {
    private ArrayList<SectionEvaluationItem> nextSectionEvaluationItemArrayList;
    private String actionBarSubtitle;
    private ListRecyclerViewAdapter listRecyclerViewAdapter;
    private ArrayList<EvaluationItem> evaluationItems;
    private HashMap<String, Object> valuesDump;
    private EvaluationItem evaluationItem;

    EvaluationListPresenterImpl(EvaluationListView view) {
        super(view);
    }

    @Override
    public void onCreate() {
        RecyclerView recyclerView = getView().getRecyclerView();
        Activity activity = getActivity();
        if (activity != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(activity));
            Bundle arguments = getView().getArguments();
            if (arguments != null) {
                onNewEvaluationList(recyclerView, (AppCompatActivity) activity, arguments);
            }
        }
    }

    private void onNewEvaluationList(RecyclerView recyclerView, AppCompatActivity activity, Bundle arguments) {

        actionBarSubtitle = arguments.getString(ConfigurationParams.SUBTITLE);
        boolean shouldShowAlert = arguments.getBoolean(ConfigurationParams.SHOULD_SHOW_ALERT);

        String sectionId = arguments.getString(ConfigurationParams.NEXT_SECTION_ID);
        Log.e("status", sectionId);
        if (NEXT_SECTION_HOME_SCREEN.equals(sectionId)) {
            nextSectionEvaluationItemArrayList = new ArrayList<SectionEvaluationItem>() {{
                add(new SectionEvaluationItem(getActivity(), ConfigurationParams.COMPUTE_EVALUATION, getActivity().getResources().getString(R.string.compute_evaluation), new ArrayList<>()));
            }};
            evaluationItem = EvaluationDataHelper.createHomeScreenData(activity);
        } else if (NEXT_SECTION_ABOUT.equals(sectionId)) {
            evaluationItem = new About(activity);
        } else if (NEXT_SECTION_HEART_SPECIALIST.equals(sectionId)) {
            nextSectionEvaluationItemArrayList = new ArrayList<SectionEvaluationItem>() {{
                add(new SectionEvaluationItem(getActivity(), ConfigurationParams.PAH_COMPUTE_EVALUATION,
                        activity.getResources().getString(R.string.compute_evaluation), new ArrayList<>()));
            }};
            evaluationItem = ((EvaluationActivity) activity).getHeartSpecialistManagement();
            EvaluationDataHelper.recursiveFillSection(evaluationItem, EvaluationDAO.getInstance().loadValues());
        } else if (sectionId != null) {
            evaluationItem = EvaluationDataHelper.fetchEvaluationItemById(sectionId, activity);
            ArrayList<String> sectionIds = arguments.getStringArrayList(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS);
            nextSectionEvaluationItemArrayList = EvaluationDataHelper.getNextSectionItems(sectionIds, activity);
        }

        evaluationItems = evaluationItem.getEvaluationItemList();
        valuesDump = EvaluationDataHelper.createValuesDump(evaluationItems);
        listRecyclerViewAdapter = new ListRecyclerViewAdapter(activity, evaluationItems, valuesDump, recyclerView);
        recyclerView.setAdapter(listRecyclerViewAdapter);
        String actionBarTitle = evaluationItem.getName();
        if (!activity.getResources().getString(R.string.evaluation).equals(actionBarTitle)) {
            listRecyclerViewAdapter.setParentTitle(actionBarTitle);
        }
        if (shouldShowAlert) {
            AlertModalManager.createAndShowReferToHeartFailureSpecialistAlertDialog(activity, v -> {
                popBackStack();
                if (activity instanceof EvaluationActivity) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(ConfigurationParams.NEXT_SECTION_ID, NEXT_SECTION_HEART_SPECIALIST);
//                    EvaluationDAO.getInstance().addToHashMap(ConfigurationParams.IS_PAH, true);
                    EvaluationListFragment evaluationListFragment = new EvaluationListFragment();
                    evaluationListFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.container, evaluationListFragment)
                            .addToBackStack(getSupportFragmentManager().getClass().getSimpleName() + ((EvaluationActivity) activity).getHeartSpecialistManagement().getName())
                            .commit();
                }
            }, v -> {
//                EvaluationDAO.getInstance().addToHashMap(ConfigurationParams.IS_PAH, false);
                popBackStack();
            });
        }

        if ((nextSectionEvaluationItemArrayList != null && nextSectionEvaluationItemArrayList.size() >= 1)
                && !ConfigurationParams.PULMONARY_HYPERTENSION.equals(evaluationItem.getId())) {
            SectionEvaluationItem nextSectionEvaluationItem = nextSectionEvaluationItemArrayList.get(0);
            if (nextSectionEvaluationItem.getId().equals(ConfigurationParams.PULMONARY_HYPERTENSION)) {
                if (!ConfigurationParams.VALVULAR_HEART_DISEASE_SEC.equals(evaluationItem.getId())) {
                    nextSectionEvaluationItemArrayList.remove(0);
                }
            }
            getView().getBottomButton().setText(nextSectionEvaluationItemArrayList.get(0).getName());
            listRecyclerViewAdapter.addNextSectionEvaluationItems(nextSectionEvaluationItemArrayList);
        } else {
            getView().getBottomButton().setVisibility(View.GONE);
        }
    }


    // TODO Filip: Nasty hardcoded strings?!?
    @Override
    public boolean isAboutScreen() {
        // TODO(khait@firestak.com): Change equals to startsWith for element section in About screen
        return evaluationItem.getId().startsWith("secabout");
    }

    @Override
    public boolean isEvaluationScreen() {
        return Objects.equals(evaluationItem.getId(), "secevaluation");
    }

    @Override
    public void onResume() {
        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            if (activity instanceof EvaluationActivity) {
                ((EvaluationActivity) activity).setOnBackPressedListener(() -> {
                    if (listRecyclerViewAdapter.isScreenValid()) {
                        listRecyclerViewAdapter.saveAllValues();
                        popBackStack();
                    } else {
                        showAlertToClearInputs((AppCompatActivity) activity);
                    }
                });
            }

            ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayShowTitleEnabled(false);
                TextView titleTextView = new TextView(getActivity());
                titleTextView.setText(evaluationItem.getName());
                actionBar.setCustomView(titleTextView);
                actionBar.setDisplayShowCustomEnabled(true);
                if (actionBarSubtitle == null) {
                    actionBar.setSubtitle("");
                } else {
                    actionBar.setSubtitle(actionBarSubtitle);
                }
            }

            if (ConfigurationParams.EVALUATION.equals(evaluationItem.getId())) {
                if (EvaluationDAO.getInstance().isMinimumToSaveEntered()) {
                    if (EvaluationDAO.getInstance().isEmpty()) {
                        showSaveSnackbar();
                    }
                    EvaluationDAO.getInstance().saveValues();
                }
            }
            setActionBarColor((AppCompatActivity) activity);
        }
    }

    private void setActionBarColor(AppCompatActivity activity) {
        int actionBarColor = ContextCompat.getColor(activity, R.color.pale_lavender);
        int statusBarColor = ContextCompat.getColor(activity, R.color.pale_lavender_dark);
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(new ColorDrawable(actionBarColor));
        }
        Window window = activity.getWindow();
        if (window != null) {
            window.setStatusBarColor(statusBarColor);
        }
    }

    @Override
    public void onPause() {
        if (listRecyclerViewAdapter.isScreenValid()) {
            listRecyclerViewAdapter.saveAllValues();
        }
        if (EvaluationDAO.getInstance().isMinimumToSaveEntered()) {
            if (EvaluationDAO.getInstance().isEmpty()) {
                showSaveSnackbar();
            }
            EvaluationDAO.getInstance().saveValues();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Activity activity = getActivity();
        switch (item.getItemId()) {
            case android.R.id.home:
                if (listRecyclerViewAdapter.isScreenValid()) {
                    listRecyclerViewAdapter.saveAllValues();
                    popBackStack();
                } else {
                    if (activity != null) {
                        showAlertToClearInputs((AppCompatActivity) activity);
                    }
                }
                break;
            case R.id.home:
                if (listRecyclerViewAdapter.isScreenValid()) {
                    listRecyclerViewAdapter.saveAllValues();
                    if (activity instanceof EvaluationActivity) {
                        int pahPosition = PAHpositionInBackStack();
                        if (pahPosition > 0) {
                            popBackStack(pahPosition);
                        } else {
                            ((EvaluationActivity) activity).createHomeScreen(false);
                        }
                    }
                } else {
                    showSnackbarBottomButtonError((AppCompatActivity) activity);
                }
                break;
            case R.id.reset_field:
                //TODO Implement reset fields
                resetValuesForEvaluationItem();
                break;
            case R.id.save_evaluation:
//                Log.e("status", "onSave Click me");
//                if (onSaveEvaluationChecking()) {
//                    onSaveEvaluationButtonClick();
//                }
                break;
        }
        return true;
    }

    public boolean onSaveEvaluationChecking() {
        AppCompatActivity activity = getActivity();
        if (listRecyclerViewAdapter.isScreenValid(false)) {
            listRecyclerViewAdapter.saveAllValues();
            if (EvaluationDAO.getInstance().isMinimumToSaveEntered()) {
                if (EvaluationDAO.getInstance().isEmpty()) {
                    showSaveSnackbar();
                }
                EvaluationDAO.getInstance().saveValues();
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager != null) {
                Bundle bundle = new Bundle();
                ArrayList<SectionEvaluationItem> sublist = new ArrayList<>(nextSectionEvaluationItemArrayList.subList(1, nextSectionEvaluationItemArrayList.size()));
                ArrayList<String> nextSectionEvaluationItemArrayListIds = new ArrayList<>();
                for (SectionEvaluationItem item : sublist) {
                    nextSectionEvaluationItemArrayListIds.add(item.getId());
                }
                bundle.putStringArrayList(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS, nextSectionEvaluationItemArrayListIds);
                if (
                        nextSectionEvaluationItemArrayList.size() >= 1 &&
                                nextSectionEvaluationItemArrayList.get(0).getEvaluationItemList().size() == 1 &&
                                nextSectionEvaluationItemArrayList.get(0).getEvaluationItemList().get(0) instanceof TabEvaluationItem
                ) {
                    TabFragment tabFragment = new TabFragment();
                    bundle.putString(ConfigurationParams.TAB_SECTION_LIST, (nextSectionEvaluationItemArrayList.get(0).getEvaluationItemList().get(0)).getId());
                    tabFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.container, tabFragment)
                            .addToBackStack(fragmentManager.getClass().getSimpleName() + nextSectionEvaluationItemArrayList.get(0).getName())
                            .commit();
                    if (nextSectionEvaluationItemArrayList.get(0).getSectionElementState() != SectionEvaluationItem.SectionElementState.FILLED) {
                        nextSectionEvaluationItemArrayList.get(0).setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                    }
                } else if (nextSectionEvaluationItemArrayList.size() >= 1) {
                    Fragment nextFragment = new EvaluationListFragment();
                    SectionEvaluationItem nextSectionEvaluationItem = nextSectionEvaluationItemArrayList.get(0);
                    if (ConfigurationParams.COMPUTE_EVALUATION.equals(nextSectionEvaluationItem.getId()) || ConfigurationParams.PAH_COMPUTE_EVALUATION.equals(nextSectionEvaluationItem.getId())) {
                        if (EvaluationDAO.getInstance().isMinimumToSaveEntered()) {
                            return true;
                        } else {
                            showSnackbarBottomButtonMinimumNotEnteredError(getActivity());
                        }
                    } else {
                        bundle.putSerializable(ConfigurationParams.NEXT_SECTION_ID, nextSectionEvaluationItem.getId());
                        nextFragment.setArguments(bundle);
                        if (nextSectionEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.OPENED) {
                            nextSectionEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                        }
                        fragmentManager.beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                                .replace(R.id.container, nextFragment)
                                .addToBackStack(fragmentManager.getClass().getSimpleName() + nextSectionEvaluationItem.getName())
                                .commit();
                    }
                }
            }
        } else {
            if (activity != null) {
                showSnackbarBottomButtonError(activity);
            }
        }
        return false;
    }

    public void onSaveEvaluationButtonClick() {
        AppCompatActivity activity = getActivity();
        Log.e("status", "onSaveEvaluation");
        if (activity != null) {
            Log.e("status", "onSaveEvaluation showDialog");
            AlertModalManager.createAndShowSaveNewEvaluationAlertDialog(getActivity(), v -> {
                HashMap<String, Object> evaluationValueMap = EvaluationDAO.getInstance().loadValues();
                evaluationValueMap.put(ConfigurationParams.EVALUATION_ID, -1);
                EvaluationRequest request = new EvaluationRequest(evaluationValueMap, true);
                RestClient.getInstance(activity).getApi().saveEvaluation(request.toMap()).enqueue(new Callback<EvaluationResponse>() {
                    @Override
                    public void onResponse(Call<EvaluationResponse> call, Response<EvaluationResponse> response) {
                        if (response.isSuccessful()) {
                            if (!response.body().isSuccessful()) {
                                showSnackbarBottomButtonGenericError(activity);
                            } else {
                                showSnackbarBottomSaveSuccessful(activity);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<EvaluationResponse> call, Throwable t) {
                        showSnackbarBottomButtonGenericError(activity);
                    }
                });
//                EvaluationDAO.getInstance().clearEvaluation();
//                activity.finish();
            }, v -> {
//                EvaluationDAO.getInstance().clearEvaluation();
//                activity.finish();
            });
        }
    }

    private void showSnackbarBottomSaveSuccessful(AppCompatActivity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.snackbar_bottom_button_save_evaluation_succeed, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.green_text));
            snackbar.show();
        }
    }

    private void showSnackbarBottomButtonGenericError(AppCompatActivity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(),
                    R.string.snackbar_bottom_button_unexpected_error_in_save_evaluation, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }


    private void resetValuesForEvaluationItem() {
        if (listRecyclerViewAdapter != null) {
            listRecyclerViewAdapter.resetFields();
        }
    }

    private void showAlertToClearInputs(AppCompatActivity activity) {
        AlertModalManager.createAndShowCancelScreenInputDialog(activity, v -> {
            for (EvaluationItem item : evaluationItems) {
                Object value = valuesDump.get(item.getId());
                if (value != null) {
                    item.setValue(value);
                }
            }
            popBackStack();
        });
    }

    private void showSnackbarBottomButtonError(AppCompatActivity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.snackbar_bottom_button_error, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    private void showSnackbarBottomButtonMinimumNotEnteredError(AppCompatActivity activity) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.snackbar_bottom_button_error_minimum_not_entered, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    @Override
    public void onBottomButtonClick() {
        Activity activity = getActivity();
        if (listRecyclerViewAdapter.isScreenValid(false)) {
            listRecyclerViewAdapter.saveAllValues();
            if (EvaluationDAO.getInstance().isMinimumToSaveEntered()) {
                if (EvaluationDAO.getInstance().isEmpty()) {
                    showSaveSnackbar();
                }
                EvaluationDAO.getInstance().saveValues();
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager != null) {
                Bundle bundle = new Bundle();
                ArrayList<SectionEvaluationItem> sublist = new ArrayList<>(nextSectionEvaluationItemArrayList.subList(1, nextSectionEvaluationItemArrayList.size()));
                ArrayList<String> nextSectionEvaluationItemArrayListIds = new ArrayList<>();
                for (SectionEvaluationItem item : sublist) {
                    nextSectionEvaluationItemArrayListIds.add(item.getId());
                }
                bundle.putStringArrayList(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS, nextSectionEvaluationItemArrayListIds);
                if (
                        nextSectionEvaluationItemArrayList.size() >= 1 &&
                                nextSectionEvaluationItemArrayList.get(0).getEvaluationItemList().size() == 1 &&
                                nextSectionEvaluationItemArrayList.get(0).getEvaluationItemList().get(0) instanceof TabEvaluationItem
                ) {
                    TabFragment tabFragment = new TabFragment();
                    bundle.putString(ConfigurationParams.TAB_SECTION_LIST, (nextSectionEvaluationItemArrayList.get(0).getEvaluationItemList().get(0)).getId());
                    tabFragment.setArguments(bundle);
                    fragmentManager.beginTransaction()
                            .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                            .replace(R.id.container, tabFragment)
                            .addToBackStack(fragmentManager.getClass().getSimpleName() + nextSectionEvaluationItemArrayList.get(0).getName())
                            .commit();
                    if (nextSectionEvaluationItemArrayList.get(0).getSectionElementState() != SectionEvaluationItem.SectionElementState.FILLED) {
                        nextSectionEvaluationItemArrayList.get(0).setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                    }
                } else if (nextSectionEvaluationItemArrayList.size() >= 1) {
                    Fragment nextFragment = new EvaluationListFragment();
                    SectionEvaluationItem nextSectionEvaluationItem = nextSectionEvaluationItemArrayList.get(0);
                    if (ConfigurationParams.COMPUTE_EVALUATION.equals(nextSectionEvaluationItem.getId()) || ConfigurationParams.PAH_COMPUTE_EVALUATION.equals(nextSectionEvaluationItem.getId())) {
                        boolean isPAH = nextSectionEvaluationItem.getId().equals(ConfigurationParams.PAH_COMPUTE_EVALUATION);
                        EvaluationDAO.getInstance().setISPAH(isPAH);
                        if (EvaluationDAO.getInstance().isMinimumToSaveEntered()) {
                            fragmentManager.beginTransaction()
                                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                                    .replace(R.id.container, new OutputFragment())
                                    .addToBackStack(OutputFragment.class.getSimpleName())
                                    .commit();
                        } else {
                            showSnackbarBottomButtonMinimumNotEnteredError(getActivity());
                        }
                    } else {
                        bundle.putSerializable(ConfigurationParams.NEXT_SECTION_ID, nextSectionEvaluationItem.getId());
                        nextFragment.setArguments(bundle);
                        if (nextSectionEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.OPENED) {
                            nextSectionEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                        }
                        fragmentManager.beginTransaction()
                                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                                .replace(R.id.container, nextFragment)
                                .addToBackStack(fragmentManager.getClass().getSimpleName() + nextSectionEvaluationItem.getName())
                                .commit();
                    }
                }
            }
        } else {
            if (activity != null) {
                showSnackbarBottomButtonError((AppCompatActivity) activity);
            }
        }
    }

    private void showSaveSnackbar() {
        Snackbar snackbar = Snackbar.make(getView().getRecyclerView(), R.string.saved, Snackbar.LENGTH_LONG);
        Snackbar.SnackbarLayout snackbarView = (Snackbar.SnackbarLayout) snackbar.getView();
        ((SnackbarContentLayout) snackbarView.getChildAt(0)).setGravity(Gravity.CENTER);
        ((FrameLayout.LayoutParams) snackbarView.getChildAt(0).getLayoutParams()).gravity = Gravity.CENTER;
        snackbarView.getLayoutParams().height = getView().getBottomButton().getHeight();
        TextView snackBarTextView = snackbarView.findViewById(R.id.snackbar_text);
        snackBarTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        snackBarTextView.setGravity(Gravity.CENTER);
        ((LinearLayout.LayoutParams) snackBarTextView.getLayoutParams()).gravity = Gravity.CENTER;
        AppCompatActivity activity = getActivity();
        if (activity != null) {
            try {
                float textSizeDimension = activity.getResources().getDimension(R.dimen.snackbar_textsize);
                snackBarTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeDimension);
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
            }
        }
        snackbar.show();
    }
}
