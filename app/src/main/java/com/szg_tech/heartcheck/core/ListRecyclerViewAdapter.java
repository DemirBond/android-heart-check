package com.szg_tech.heartcheck.core;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.DatePicker;
import android.widget.LinearLayout;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.core.views.CustomEditText;
import com.szg_tech.heartcheck.core.views.CustomTextView;
import com.szg_tech.heartcheck.core.views.cell.BoldTextCell;
import com.szg_tech.heartcheck.core.views.cell.CellItem;
import com.szg_tech.heartcheck.core.views.cell.CellWithIndent;
import com.szg_tech.heartcheck.core.views.cell.CheckBoxCell;
import com.szg_tech.heartcheck.core.views.cell.ChevronCell;
import com.szg_tech.heartcheck.core.views.cell.DatePickerCell;
import com.szg_tech.heartcheck.core.views.cell.EmptyCell;
import com.szg_tech.heartcheck.core.views.cell.MinutesSecondsCell;
import com.szg_tech.heartcheck.core.views.cell.RadioButtonCell;
import com.szg_tech.heartcheck.core.views.cell.SectionCell;
import com.szg_tech.heartcheck.core.views.cell.SectionCheckboxCell;
import com.szg_tech.heartcheck.core.views.cell.SectionDependsOnManager;
import com.szg_tech.heartcheck.core.views.cell.SectionPlaceholderCell;
import com.szg_tech.heartcheck.core.views.cell.StringEditTextCell;
import com.szg_tech.heartcheck.core.views.cell.StringEditTextDependantCell;
import com.szg_tech.heartcheck.core.views.cell.TextCell;
import com.szg_tech.heartcheck.core.views.modal.AlertModalManager;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.DatePickerEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.EmptyCellEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.MinutesSecondsEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.NumericalDependantEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionPlaceholderEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.StringEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.TabEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.TextEvaluationItem;
import com.szg_tech.heartcheck.fragments.evaluation_list.EvaluationListFragment;
import com.szg_tech.heartcheck.fragments.tab_fragment.TabFragment;
import com.szg_tech.heartcheck.storage.EvaluationDAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.szg_tech.heartcheck.core.ConfigurationParams.DBP;
import static com.szg_tech.heartcheck.core.ConfigurationParams.DBP_OPTIONAL;
import static com.szg_tech.heartcheck.core.ConfigurationParams.NA_MEQ_L;
import static com.szg_tech.heartcheck.core.ConfigurationParams.SBP;
import static com.szg_tech.heartcheck.core.ConfigurationParams.SBP_OPTIONAL_LOWER;
import static com.szg_tech.heartcheck.core.ConfigurationParams.SBP_OPTIONAL_UPPER;
import static com.szg_tech.heartcheck.core.ConfigurationParams.SERUM_OSMOLALITY;
import static com.szg_tech.heartcheck.core.ConfigurationParams.URINE_NA_MEQ_L;
import static com.szg_tech.heartcheck.core.ConfigurationParams.URINE_OSMOLALITY;

public class ListRecyclerViewAdapter extends RecyclerView.Adapter<ListRecyclerViewAdapter.ViewHolder> {
    private AppCompatActivity activity;
    private List<EvaluationItem> evaluationItemsList;
    private HashMap<String, Map<RadioButtonGroupEvaluationItem, RadioButtonCell>> radioGroupMap = new HashMap<>();
    private ArrayList<SectionEvaluationItem> nextSectionEvaluationItems = new ArrayList<>();
    private SectionDependsOnManager sectionDependsOnManager = new SectionDependsOnManager();
    private String parentTitle;
    private ArrayList<EvaluationItem> expandedItems = new ArrayList<>();
    private HashMap<String, Integer> depthMap;
    private List<String> depthMapLeaf;
    private HashMap<String, Object> oldValues;

    private boolean onBind;


    public ListRecyclerViewAdapter(AppCompatActivity activity, List<EvaluationItem> evaluationItemsList, HashMap<String, Object> valuesDump) {
        this.activity = activity;
        this.evaluationItemsList = new ArrayList<>(evaluationItemsList);
        depthMap = new HashMap<>();
        depthMapLeaf = new ArrayList<>();
        calculateDepth(evaluationItemsList, 0);
        populateWithSeparators(evaluationItemsList);

        oldValues = valuesDump;
    }

    @Override
    public int getItemViewType(int position) {
        EvaluationItem evaluationItem = evaluationItemsList.get(position);
        if (evaluationItem instanceof BooleanEvaluationItem) {
            return TypeElementEnum.BOOLEAN.ordinal();
        } else if (evaluationItem instanceof StringEvaluationItem) {
            return TypeElementEnum.STRING.ordinal();
        } else if (evaluationItem instanceof NumericalEvaluationItem) {
            return TypeElementEnum.NUMERICAL.ordinal();
        } else if (evaluationItem instanceof SectionEvaluationItem) {
            return TypeElementEnum.SECTION.ordinal();
        } else if (evaluationItem instanceof RadioButtonGroupEvaluationItem) {
            return TypeElementEnum.RADIO_BUTTON_GROUP.ordinal();
        } else if (evaluationItem instanceof SectionPlaceholderEvaluationItem) {
            return TypeElementEnum.SECTION_PLACE_HOLDER.ordinal();
        } else if (evaluationItem instanceof BoldEvaluationItem) {
            return TypeElementEnum.BOLD.ordinal();
        } else if (evaluationItem instanceof MinutesSecondsEvaluationItem) {
            return TypeElementEnum.MINUTES_SECONDS.ordinal();
        } else if (evaluationItem instanceof SectionCheckboxEvaluationItem) {
            return TypeElementEnum.SECTION_CHECKBOX.ordinal();
        } else if (evaluationItem instanceof NumericalDependantEvaluationItem) {
            return TypeElementEnum.NUMERICAL_DEPENDANT.ordinal();
        } else if (evaluationItem instanceof EmptyCellEvaluationItem) {
            return TypeElementEnum.EMPTY_CELL.ordinal();
        } else if (evaluationItem instanceof DatePickerEvaluationItem) {
            return TypeElementEnum.DATE_PICKER.ordinal();
        } else if (evaluationItem instanceof TextEvaluationItem) {
            return TypeElementEnum.TEXT.ordinal();
        }
        return TypeElementEnum.UNKNOWN.ordinal();
    }

    public void addNextSectionEvaluationItems(ArrayList<SectionEvaluationItem> nextSectionEvaluationItems) {
        if (nextSectionEvaluationItems != null) {
            this.nextSectionEvaluationItems = nextSectionEvaluationItems;
        }
    }

    @NonNull
    @Override
    public ListRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TypeElementEnum type = TypeElementEnum.values()[viewType];
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        switch (type) {
            case BOOLEAN:
                CheckBoxCell checkBoxCell = new CheckBoxCell(activity);
                checkBoxCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(checkBoxCell);
            case STRING:
            case NUMERICAL:
                StringEditTextCell stringEditTextCell = new StringEditTextCell(activity);
                stringEditTextCell.setLayoutParams(layoutParams);
                if (type == TypeElementEnum.NUMERICAL || type == TypeElementEnum.NUMERICAL_DEPENDANT) {
                    stringEditTextCell.setNumeric();
                }
                return new ListRecyclerViewAdapter.ViewHolder(stringEditTextCell);

            case NUMERICAL_DEPENDANT:
                StringEditTextDependantCell stringEditTextDependantCell = new StringEditTextDependantCell(activity);
                stringEditTextDependantCell.setLayoutParams(layoutParams);
                if (type == TypeElementEnum.NUMERICAL || type == TypeElementEnum.NUMERICAL_DEPENDANT) {
                    stringEditTextDependantCell.setNumeric();
                }
                return new ListRecyclerViewAdapter.ViewHolder(stringEditTextDependantCell);
            case SECTION:
                SectionCell sectionCell = new SectionCell(activity);
                sectionCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(sectionCell);
            case RADIO_BUTTON_GROUP:
                RadioButtonCell radioButtonCell = new RadioButtonCell(activity);
                radioButtonCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(radioButtonCell);
            case SECTION_PLACE_HOLDER:
                SectionPlaceholderCell sectionPlaceholderCell = new SectionPlaceholderCell(activity);
                sectionPlaceholderCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(sectionPlaceholderCell);
            case BOLD:
                BoldTextCell boldTextCell = new BoldTextCell(activity);
                boldTextCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(boldTextCell);
            case MINUTES_SECONDS:
                MinutesSecondsCell minutesSecondsCell = new MinutesSecondsCell(activity);
                minutesSecondsCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(minutesSecondsCell);
            case SECTION_CHECKBOX:
                SectionCheckboxCell sectionCheckboxCell = new SectionCheckboxCell(activity);
                sectionCheckboxCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(sectionCheckboxCell);
            case EMPTY_CELL:
                EmptyCell emptyCell = new EmptyCell(activity, ContextCompat.getColor(activity, R.color.lighter_purple));
                return new ListRecyclerViewAdapter.ViewHolder(emptyCell);
            case DATE_PICKER:
                DatePickerCell datePickerCell = new DatePickerCell(activity);
                datePickerCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(datePickerCell);
            case TEXT:
                TextCell textCell = new TextCell(activity);
                textCell.setLayoutParams(layoutParams);
                return new ListRecyclerViewAdapter.ViewHolder(textCell);
        }
        StringEditTextCell stringEditTextCell = new StringEditTextCell(activity);
        return new ListRecyclerViewAdapter.ViewHolder(stringEditTextCell);
    }

    private void markChildAsChecked(EvaluationItem parent, boolean isChecked) {
        if (parent != null && !isChecked) {
            if (parent instanceof SectionCheckboxEvaluationItem
                    || parent instanceof RadioButtonGroupEvaluationItem) {
                List<EvaluationItem> children = parent.getEvaluationItemList();
                for (EvaluationItem item : children) {
                    if (item instanceof BooleanEvaluationItem && ((BooleanEvaluationItem) item).isChecked()) {
                        ((BooleanEvaluationItem) item).setChecked(false);
                    } else if (item instanceof SectionCheckboxEvaluationItem) {
                        ((SectionCheckboxEvaluationItem) item).setChecked(false);
                        markChildAsChecked(item, false);
                    } else if (item instanceof RadioButtonGroupEvaluationItem) {
                        ((RadioButtonGroupEvaluationItem) item).setChecked(false);
                        markChildAsChecked(item, false);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    private void markParentAsChecked(EvaluationItem child, boolean isChecked) {
        EvaluationItem parent = null;
        for (EvaluationItem item : expandedItems) {
            List children = item.getEvaluationItemList();
            if (children != null && children.contains(child)) {
                parent = item;
                break;
            }
        }
        if (parent != null) {
            if (parent instanceof SectionCheckboxEvaluationItem) {
                if (isChecked) {
                    ((SectionCheckboxEvaluationItem) parent).setChecked(true);
                    markParentAsChecked(parent, true);
                } else {
                    List<EvaluationItem> children = parent.getEvaluationItemList();
                    boolean flagAllUnCheck = true;
                    for (EvaluationItem item : children) {
                        if (item instanceof BooleanEvaluationItem && ((BooleanEvaluationItem) item).isChecked()) {
                            flagAllUnCheck = false;
                            break;
                        } else if (item instanceof SectionCheckboxEvaluationItem && ((SectionCheckboxEvaluationItem) item).isChecked()) {
                            flagAllUnCheck = false;
                            break;
                        }
                    }
                    if (flagAllUnCheck) {
                        ((SectionCheckboxEvaluationItem) parent).setChecked(false);
                        markParentAsChecked(parent, false);
                    }
                }
            } else if (parent instanceof RadioButtonGroupEvaluationItem) {
                ((RadioButtonGroupEvaluationItem) parent).setChecked(isChecked);
                Map<RadioButtonGroupEvaluationItem, RadioButtonCell> radioButtons = radioGroupMap.get(((RadioButtonGroupEvaluationItem) parent).getGroupName());
                if (radioButtons != null) {
                    for (RadioButtonGroupEvaluationItem radioButtonItem : radioButtons.keySet()) {
                        if (parent != radioButtonItem) {
                            radioButtonItem.setChecked(false);
                        }
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    private void deselectRadioButtons(Map<RadioButtonGroupEvaluationItem, RadioButtonCell> radioButtons, RadioButtonCell radioButtonCell) {
        for (Map.Entry<RadioButtonGroupEvaluationItem, RadioButtonCell> entry : radioButtons.entrySet()) {
            RadioButtonGroupEvaluationItem item = entry.getKey();
            RadioButtonCell currentCell = entry.getValue();
            if (radioButtonCell != currentCell) {
                currentCell.getRadioButton().setChecked(false);
                currentCell.getRadioButton().invalidate();
                item.setChecked(false);
                List<EvaluationItem> children = item.getEvaluationItemList();
                if (children != null) {
                    for (EvaluationItem child : children) {
                        if (child instanceof SectionCheckboxEvaluationItem) {
                            ((SectionCheckboxEvaluationItem) child).setChecked(false);
                        } else if (child instanceof RadioButtonGroupEvaluationItem) {
                            ((RadioButtonGroupEvaluationItem) child).setChecked(false);
                        }
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    private void setScaleInAnimation(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(475);
        scaleAnimation.setDuration(375);
        view.startAnimation(scaleAnimation);
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);
        view.startAnimation(set);
    }

    @Override
    public void onBindViewHolder(ListRecyclerViewAdapter.ViewHolder holder, int position) {
        if (holder != null) {
            EvaluationItem evaluationItem = evaluationItemsList.get(position);
            String name = evaluationItem.getName();
            if (holder.view instanceof LinearLayout) {
                String id = evaluationItem.getId();
                if (id == null && position > 0) {
                    id = evaluationItemsList.get(position - 1).getId();
                }
                if (holder.view instanceof CellWithIndent) {
                    ((CellWithIndent) holder.view).setLevelMark(depthMap.get(id), depthMapLeaf.contains(id));
                }
            }

            if (itemsToAnimateIn != null && itemsToAnimateIn.contains(evaluationItem)) {
                setScaleInAnimation(holder.itemView);
                itemsToAnimateIn.remove(evaluationItem);
            }

            if (evaluationItem.isMandatory()) {
                name += "*";
            }
            holder.view.setLabelText(name);
            holder.view.setHintText(evaluationItem.getHint());

            int cellMinHeight = holder.itemView
                    .getContext()
                    .getResources()
                    .getDimensionPixelSize(R.dimen.icon_cell_height
                    );

            if (evaluationItem instanceof SectionEvaluationItem) {
                if (!((SectionEvaluationItem) evaluationItem).isHasStateIcon()) {
                    ((SectionCell) holder.view).setStateIconLayoutVisibility(false);
                }
                SectionEvaluationItem.SectionElementState state = ((SectionEvaluationItem) evaluationItemsList.get(position)).getSectionElementState();
                switch (state) {
                    case LOCKED:
                        ((SectionCell) holder.view).setLocked();
                        break;
                    case OPENED:
                        ((SectionCell) holder.view).setOpened();
                        break;
                    case VIEWED:
                        ((SectionCell) holder.view).setViewed();
                        break;
                    case FILLED:
                        ((SectionCell) holder.view).setFilled();
                        break;
                }

                String dependsOn = ((SectionEvaluationItem) evaluationItem).getDependsOn();
                SectionEvaluationItem mainEvaluationItem = null;
                if (dependsOn != null) {
                    for (EvaluationItem tempEvaluationItem : evaluationItemsList) {
                        if (tempEvaluationItem instanceof SectionEvaluationItem && tempEvaluationItem.getId().equals(dependsOn)) {
                            mainEvaluationItem = (SectionEvaluationItem) tempEvaluationItem;
                            sectionDependsOnManager.addToMap(mainEvaluationItem, (SectionEvaluationItem) evaluationItem);
                        }
                    }
                    if (mainEvaluationItem != null && mainEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.VIEWED
                            && ((SectionEvaluationItem) evaluationItem).getSectionElementState() == SectionEvaluationItem.SectionElementState.LOCKED) {
                        ((SectionEvaluationItem) evaluationItem).setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                        ((SectionCell) holder.view).setOpened();
                    }
                }
                if (evaluationItem.getId().equals(ConfigurationParams.LABORATORIES) && ((SectionEvaluationItem) evaluationItem).getSectionElementState() == SectionEvaluationItem.SectionElementState.LOCKED) {
                    for (int i = 0; i < evaluationItemsList.size(); i++) {
                        EvaluationItem item = evaluationItemsList.get(i);
                        if ((item.getId().equals(ConfigurationParams.CURRENT_PAST_CV_PROFILE) &&
                                ((SectionEvaluationItem) item).getSectionElementState() == SectionEvaluationItem.SectionElementState.VIEWED)
                                || (item.getId().equals(ConfigurationParams.MAJOR_CV_RISK) &&
                                ((SectionEvaluationItem) item).getSectionElementState() == SectionEvaluationItem.SectionElementState.VIEWED)) {
                            ((SectionEvaluationItem) evaluationItem).setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                            ((SectionCell) holder.view).setOpened();
                        }
                    }
                }

                SectionEvaluationItem finalMainEvaluationItem = mainEvaluationItem;
                ((SectionCell) holder.view).setOnClickListener(v -> {
                    if (((SectionEvaluationItem) evaluationItem).getSectionElementState() == SectionEvaluationItem.SectionElementState.LOCKED) {
                        if (evaluationItem.getId().equals(ConfigurationParams.LABORATORIES)
                                || evaluationItem.getId().equals(ConfigurationParams.DIAGNOSTICS)) {
                            SectionEvaluationItem bioEvaluationItem = null;
                            int bioPosition = 0;
                            SectionEvaluationItem currentCVEvaluationItem = null;
                            int currentCVPosition = 0;
                            SectionEvaluationItem majorCVRiskEvaluationItem = null;
                            int majorCVRiskPosition = 0;

                            SectionEvaluationItem laboratoriesEvaluationItem = null;
                            SectionEvaluationItem diagnosticEvaluationItem = null;

                            for (int i = 0; i < evaluationItemsList.size(); i++) {
                                EvaluationItem item = evaluationItemsList.get(i);
                                switch (item.getId()) {
                                    case ConfigurationParams.BIO:
                                        bioEvaluationItem = (SectionEvaluationItem) item;
                                        bioPosition = i;
                                        break;
                                    case ConfigurationParams.CURRENT_PAST_CV_PROFILE:
                                        currentCVEvaluationItem = (SectionEvaluationItem) item;
                                        currentCVPosition = i;
                                        break;
                                    case ConfigurationParams.MAJOR_CV_RISK:
                                        majorCVRiskEvaluationItem = (SectionEvaluationItem) item;
                                        majorCVRiskPosition = i;
                                        break;
                                    case ConfigurationParams.LABORATORIES:
                                        laboratoriesEvaluationItem = (SectionEvaluationItem) item;
                                        break;
                                    case ConfigurationParams.DIAGNOSTICS:
                                        diagnosticEvaluationItem = (SectionEvaluationItem) item;
                                        break;
                                }
                            }
                            if (bioEvaluationItem != null && bioEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.OPENED) {
                                int finalBioPosition = bioPosition;
                                SectionEvaluationItem finalBioEvaluationItem = bioEvaluationItem;
                                AlertModalManager.createAndShowDependsOnSectionAlertDialog(activity, bioEvaluationItem.getName(), v1 -> goToNextScreen(finalBioPosition, finalBioEvaluationItem));
                            } else if ((currentCVEvaluationItem != null
                                    && currentCVEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.OPENED)
                                    && (majorCVRiskEvaluationItem != null
                                    && majorCVRiskEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.OPENED)) {
                                SectionEvaluationItem finalCurrentCVEvaluationItem = currentCVEvaluationItem;
                                SectionEvaluationItem finalMajorCVRiskEvaluationItem = majorCVRiskEvaluationItem;
                                int finalCurrentCVPosition = currentCVPosition;
                                int finalMajorCVRiskPosition = majorCVRiskPosition;
                                SectionEvaluationItem finalLaboratoriesEvaluationItem = laboratoriesEvaluationItem;
                                SectionEvaluationItem finalDiagnosticEvaluationItem = diagnosticEvaluationItem;
                                AlertModalManager.createAndShowThreeButtonDependsOnDialog(activity, v1 -> {
                                            if (finalLaboratoriesEvaluationItem != null) {
                                                finalLaboratoriesEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                                            }
                                            if (finalDiagnosticEvaluationItem != null) {
                                                finalDiagnosticEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                                            }
                                            goToNextScreen(finalCurrentCVPosition, finalCurrentCVEvaluationItem);
                                        }, v2 -> {
                                            if (finalLaboratoriesEvaluationItem != null) {
                                                finalLaboratoriesEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                                            }
                                            if (finalDiagnosticEvaluationItem != null) {
                                                finalDiagnosticEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                                            }
                                            goToNextScreen(finalMajorCVRiskPosition, finalMajorCVRiskEvaluationItem);
                                        }, v3 -> goToNextScreen(position, (SectionEvaluationItem) evaluationItem)
                                );
                            }
                        } else if (finalMainEvaluationItem != null) {
                            goToMandatorySection(activity, finalMainEvaluationItem);
                        }
                    } else if (activity instanceof AppCompatActivity) {
                        if (isScreenValid()) {
                            goToNextScreen(position, (SectionEvaluationItem) evaluationItem);
                            if (evaluationItem.getId().equals(ConfigurationParams.CURRENT_PAST_CV_PROFILE) ||
                                    evaluationItem.getId().equals(ConfigurationParams.MAJOR_CV_RISK)) {

                                for (EvaluationItem tempEvaluationItem : evaluationItemsList) {
                                    if (tempEvaluationItem.getId().equals(ConfigurationParams.LABORATORIES) || tempEvaluationItem.getId().equals(ConfigurationParams.DIAGNOSTICS)) {
                                        SectionEvaluationItem tempLabOrDiagnosticEvaluationItem = (SectionEvaluationItem) tempEvaluationItem;
                                        if (tempLabOrDiagnosticEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.LOCKED) {
                                            tempLabOrDiagnosticEvaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.OPENED);
                                        }
                                    }
                                }
                            }
                        } else {
                            showSnackbarBottomButtonError(((SectionCell) holder.view).getTextView());
                        }
                    }
                });
            } else if (evaluationItem instanceof SectionPlaceholderEvaluationItem) {
                ArrayList<EvaluationItem> evaluationItems = evaluationItem.getEvaluationItemList();
                if (evaluationItems.get(0) instanceof RadioButtonGroupEvaluationItem) {
                    for (EvaluationItem item : evaluationItems) {
                        if (((RadioButtonGroupEvaluationItem) item).isChecked()) {
                            evaluationItem.setHint(item.getName());
                            holder.view.setHintText(item.getName());
                            break;
                        }
                    }
                }
                ((SectionPlaceholderCell) holder.view).setOnClickListener(v -> {
                    if (activity instanceof AppCompatActivity) {
                        saveAllValues();
                        FragmentManager fragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
                        if (fragmentManager != null) {
                            expandOrCollapseList(evaluationItem, position);
                        }
                    }
                });
            } else if (evaluationItem instanceof RadioButtonGroupEvaluationItem) {
                RadioButtonGroupEvaluationItem radioButtonItem = (RadioButtonGroupEvaluationItem) evaluationItem;
                RadioButtonCell radioButtonCell = (RadioButtonCell) holder.view;

                radioButtonCell.setBackgroundHighlighted(radioButtonItem.isBackgroundHighlighted());
                radioButtonCell.setChecked(radioButtonItem.isChecked());

                String groupName = radioButtonItem.getGroupName();

                Map<RadioButtonGroupEvaluationItem, RadioButtonCell> radioButtons = radioGroupMap.get(groupName);
                if (radioButtons == null) {
                    radioButtons = new HashMap<>();
                    radioGroupMap.put(groupName, radioButtons);
                }
                radioButtons.put(radioButtonItem, radioButtonCell);

                Map<RadioButtonGroupEvaluationItem, RadioButtonCell> finalRadioButtons = radioButtons;
                radioButtonCell.setOnClickListener(v -> {
                    radioButtonItem.setChecked(true);
                    radioButtonCell.setChecked(true);
                    deselectRadioButtons(finalRadioButtons, radioButtonCell);
                    markParentAsChecked(evaluationItem, true);
                    if (evaluationItem.getEvaluationItemList() != null) {
                        expandOrCollapseList(evaluationItem, position);
                    }
                });


                if (evaluationItem.getEvaluationItemList() != null) {
                    radioButtonCell.showChevron(true);
                    setupChevron(radioButtonCell, evaluationItem);

                } else {
                    radioButtonCell.showChevron(false);
                }
            } else if (evaluationItem instanceof BooleanEvaluationItem) {
                CheckBoxCell checkBoxCell = (CheckBoxCell) holder.view;
                BooleanEvaluationItem booleanEvaluationItem = (BooleanEvaluationItem) evaluationItem;
                checkBoxCell.setBackgroundHighlighted(booleanEvaluationItem.isBackgroundHighlighted());
                checkBoxCell.getCheckBox().setOnCheckedChangeListener((buttonView, isChecked) -> {
                    if (!onBind) {
                        booleanEvaluationItem.setChecked(isChecked);
                        markParentAsChecked(booleanEvaluationItem, isChecked);
                    }
                });
                onBind = true;
                checkBoxCell.setChecked(booleanEvaluationItem.isChecked());
                onBind = false;
            } else if (evaluationItem instanceof NumericalEvaluationItem) {
                StringEditTextCell stringEditTextCell = (StringEditTextCell) holder.view;
                setImeOptionsForLastEditText(stringEditTextCell, position);
                CustomEditText editText = stringEditTextCell.getEditText();
                editText.clearTextWatchers();
                if (evaluationItem.getValue() != null) {
                    stringEditTextCell.setCorrect(evaluationItem.isValid());
                }
                if (((NumericalEvaluationItem) evaluationItem).isWhole()) {
                    stringEditTextCell.setNumeric(true);
                }
                Double number = ((NumericalEvaluationItem) evaluationItem).getNumber();
                if (number != null) {
                    editText.setText(((NumericalEvaluationItem) evaluationItem).isWhole() ? String.valueOf(number.intValue()) : String.valueOf(number));
                } else {
                    Objects.requireNonNull(editText.getText()).clear();
                }
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String text = s.toString();
                        if (!text.isEmpty()) {
                            if (text.trim().equals(".")) text = "0";
                            double value = Double.parseDouble(text);
                            if (value >= ((NumericalEvaluationItem) evaluationItem).getFrom()
                                    && value <= ((NumericalEvaluationItem) evaluationItem).getTo()) {
                                ((NumericalEvaluationItem) evaluationItem).setNumber(Double.parseDouble(s.toString()));
                                stringEditTextCell.setCorrect(true);
//                                if (!onBind) {
//                                    markParentAsChecked(evaluationItem, true);
//                                }
                                return;
                            }
                        } else if (!evaluationItem.isMandatory()) {
                            ((NumericalEvaluationItem) evaluationItem).setNumber(null);
                            stringEditTextCell.setCorrect(true);
                            return;
                        }
                        ((NumericalEvaluationItem) evaluationItem).setNumber(null);
                        stringEditTextCell.setCorrect(false);
                    }
                });
                editText.setOnFocusChangeListener((v, hasFocus) -> {
                    if (!hasFocus) {
                        if (!stringEditTextCell.isCorrect()) {
                            String snackbarText = null;
                            if (evaluationItem.isMandatory() && editText.getText().toString().isEmpty()) {
                                snackbarText = String.format(activity.getString(R.string.snackbar_empty_message), evaluationItem.getName());
                            } else if (!editText.getText().toString().isEmpty()) {
                                snackbarText = String.format(activity.getString(R.string.snackbar_range_message), evaluationItem.getName(),
                                        String.valueOf(((NumericalEvaluationItem) evaluationItem).getFrom()), String.valueOf(((NumericalEvaluationItem) evaluationItem).getTo()));
                            }
                            if (snackbarText != null) {
                                Snackbar snackbar = Snackbar.make(editText, snackbarText,
                                        Snackbar.LENGTH_SHORT);
                                snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
                                snackbar.show();
                            }
                        }
                        NumericalEvaluationItem numericalEvaluationItem = ((NumericalEvaluationItem) evaluationItem);
                        if (numericalEvaluationItem.getId().equals(SBP)) {
                            updateNumericalOptionalCell(SBP_OPTIONAL_LOWER);
                            updateNumericalOptionalCell(SBP_OPTIONAL_UPPER);
                        }
                        if (numericalEvaluationItem.getId().equals(DBP)) {
                            updateNumericalOptionalCell(DBP_OPTIONAL);
                        }

                        if (numericalEvaluationItem.getId().equals(NA_MEQ_L)) {
                            updateNumericalOptionalCell(URINE_NA_MEQ_L);
                            updateNumericalOptionalCell(SERUM_OSMOLALITY);
                            updateNumericalOptionalCell(URINE_OSMOLALITY);
                        }
                    } else if (evaluationItem.isMandatory() && editText.getText().toString().isEmpty()) {
                        stringEditTextCell.setCorrect(false);
                    }
                });

            } else if (evaluationItem instanceof NumericalDependantEvaluationItem) {
                StringEditTextDependantCell stringEditTextDependantCell = (StringEditTextDependantCell) holder.view;
                setImeOptionsForLastEditText(stringEditTextDependantCell, position);

                NumericalDependantEvaluationItem dependantItem =
                        ((NumericalDependantEvaluationItem) evaluationItem);

                LinearLayout primaryContainer = stringEditTextDependantCell.getPrimaryContainerView();
                CustomTextView optionalHint = stringEditTextDependantCell.getOptionalHintTextView();
                stringEditTextDependantCell.getEditText().setHint(
                        stringEditTextDependantCell.getContext().getString(R.string.value));


                if (isNaMEQLOptionalCell(dependantItem.getId()) && isMeetCriteriaToShowOptionalValue(
                        dependantItem.getId(),
                        dependantItem.getDependsOn(),
                        dependantItem.getEnableTo(),
                        dependantItem.getEnableFrom())
                ) {
                    primaryContainer.setVisibility(View.VISIBLE);
                    primaryContainer.setMinimumHeight(cellMinHeight);
                    if (dependantItem.getId().equals(URINE_NA_MEQ_L)) {
                        optionalHint.setVisibility(View.VISIBLE);
                        optionalHint.setText(getFormattedString(
                                holder.itemView,
                                dependantItem.getDependsOn(),
                                dependantItem.getHint(),
                                dependantItem.getEnableTo(),
                                dependantItem.getEnableFrom()));
                    }else {
                        optionalHint.setVisibility(View.GONE);
                }
                }else {
                    if (isSPBandDBPOptionalCell(dependantItem.getId()) &&
                            isMeetCriteriaToShowOptionalValue(
                                    dependantItem.getId(),
                                    dependantItem.getDependsOn(),
                                    dependantItem.getEnableTo(),
                                    dependantItem.getEnableFrom())
                    ) {
                        primaryContainer.setVisibility(View.VISIBLE);
                        primaryContainer.setMinimumHeight(cellMinHeight);
                        optionalHint.setVisibility(View.VISIBLE);
                        optionalHint.setText(getFormattedString(
                                holder.itemView,
                                dependantItem.getDependsOn(),
                                dependantItem.getHint(),
                                dependantItem.getTo(),
                                dependantItem.getFrom()));
                    } else {
                        optionalHint.setVisibility(View.GONE);
                        primaryContainer.setVisibility(View.GONE);
                        primaryContainer.setMinimumHeight(0);
                        ((NumericalDependantEvaluationItem)evaluationItem).setNumber(null);
                    }
                }

                if (evaluationItem.getValue() != null) {
                    stringEditTextDependantCell.setCorrect(evaluationItem.isValid());
                }
                CustomEditText editText = stringEditTextDependantCell.getEditText();
                editText.clearTextWatchers();
                if (((NumericalDependantEvaluationItem) evaluationItem).isWhole()) {
                    stringEditTextDependantCell.setNumeric(true);
                }
                Double number = ((NumericalDependantEvaluationItem) evaluationItem).getNumber();
                if (number != null) {
                    editText.setText(((NumericalDependantEvaluationItem) evaluationItem).isWhole() ? String.valueOf(number.intValue()) : String.valueOf(number));
                } else {
                    editText.getText().clear();
                }
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String text = s.toString();
                        if (!text.isEmpty()) {
                            if (text.trim().equals(".")) text = "0";
                            double value = Double.parseDouble(text);

                            if (isSPBandDBPOptionalCell(dependantItem.getId())) {
                                ((NumericalDependantEvaluationItem) evaluationItem).setNumber(Double.parseDouble(s.toString()));
                                stringEditTextDependantCell.setCorrect(true);
                                markParentAsChecked(evaluationItem, true);
                                return;
                            } else {
                                if (value >= ((NumericalDependantEvaluationItem) evaluationItem).getFrom()
                                        && value <= ((NumericalDependantEvaluationItem) evaluationItem).getTo()) {
                                    ((NumericalDependantEvaluationItem) evaluationItem).setNumber(Double.parseDouble(s.toString()));

                                    stringEditTextDependantCell.setCorrect(true);
                                    markParentAsChecked(evaluationItem, true);
                                    return;
                                }
                            }

                        } else if (!evaluationItem.isMandatory()) {
                            ((NumericalDependantEvaluationItem) evaluationItem).setNumber(null);
                            stringEditTextDependantCell.setCorrect(true);
                            return;
                        }
                        ((NumericalDependantEvaluationItem) evaluationItem).setNumber(null);
                        if (!isSPBandDBPOptionalCell(dependantItem.getId())) {
                            stringEditTextDependantCell.setCorrect(false);
                        }
                    }
                });
                editText.setOnFocusChangeListener((v, hasFocus) -> {
                    if (!isSPBandDBPOptionalCell(dependantItem.getId())) {
                        if (!hasFocus) {
                            if (!stringEditTextDependantCell.isCorrect()) {
                                String snackbarText = null;
                                if (evaluationItem.isMandatory() && editText.getText().toString().isEmpty()) {
                                    snackbarText = String.format(activity.getString(R.string.snackbar_empty_message), evaluationItem.getName());
                                } else if (!editText.getText().toString().isEmpty()) {
                                    snackbarText = String.format(activity.getString(R.string.snackbar_range_message), evaluationItem.getName(),
                                            String.valueOf(((NumericalDependantEvaluationItem) evaluationItem).getFrom()), String.valueOf(((NumericalDependantEvaluationItem) evaluationItem).getTo()));
                                }
                                if (snackbarText != null) {
                                    Snackbar snackbar = Snackbar.make(editText, snackbarText,
                                            Snackbar.LENGTH_SHORT);
                                    snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
                                    snackbar.show();
                                }
                            }
                        } else if (evaluationItem.isMandatory() && editText.getText().toString().isEmpty()) {
                            stringEditTextDependantCell.setCorrect(false);
                        }
                    }
                });

            } else if (evaluationItem instanceof StringEvaluationItem) {
                StringEditTextCell stringEditTextCell = (StringEditTextCell) holder.view;
                stringEditTextCell.setEditable(((StringEvaluationItem) evaluationItem).isEditable());
                setImeOptionsForLastEditText(stringEditTextCell, position);
                CustomEditText editText = stringEditTextCell.getEditText();
                editText.clearTextWatchers();
                if (evaluationItem.getValue() != null) {
                    stringEditTextCell.setCorrect(evaluationItem.isValid());
                }
                String text = ((StringEvaluationItem) evaluationItem).getText();
                if (text != null) {
                    editText.setText(text);
                } else {
                    Objects.requireNonNull(editText.getText()).clear();
                }
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String inputText = s.toString();
                        if (inputText.isEmpty()) {
                            ((StringEvaluationItem) evaluationItem).setText(null);
                            if (!evaluationItem.isMandatory()) {
                                stringEditTextCell.setCorrect(true);
                                markParentAsChecked(evaluationItem, true);
                            } else {
                                stringEditTextCell.setCorrect(false);
                            }
                        } else {
                            ((StringEvaluationItem) evaluationItem).setText(s.toString());
                            stringEditTextCell.setCorrect(true);
                        }
                    }
                });
                editText.setOnFocusChangeListener((v, hasFocus) -> {
                    if (!hasFocus) {
                        if (!stringEditTextCell.isCorrect()) {
                            String snackbarText;
                            if (evaluationItem.isMandatory() && editText.getText().toString().isEmpty()) {
                                snackbarText = String.format(activity.getString(R.string.snackbar_empty_message), evaluationItem.getName());
                                Snackbar snackbar = Snackbar.make(editText, snackbarText,
                                        Snackbar.LENGTH_SHORT);
                                snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
                                snackbar.show();
                            }
                        }
                    } else if (evaluationItem.isMandatory() && editText.getText().toString().isEmpty()) {
                        stringEditTextCell.setCorrect(false);
                    }
                });
            } else if (evaluationItem instanceof MinutesSecondsEvaluationItem) {
                Integer minutes = ((MinutesSecondsEvaluationItem) evaluationItem).getMinutes();
                if (minutes != null) {
                    ((MinutesSecondsCell) holder.view).setMinutes(minutes);
                }
                Integer seconds = ((MinutesSecondsEvaluationItem) evaluationItem).getSeconds();
                if (seconds != null) {
                    ((MinutesSecondsCell) holder.view).setSeconds(seconds);
                }
                ((MinutesSecondsCell) holder.view).addOnMinutesChangeListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (s.length() != 0) {
                            ((MinutesSecondsEvaluationItem) evaluationItem).setMinutes(Integer.valueOf(s.toString()));
                        } else {
                            ((MinutesSecondsEvaluationItem) evaluationItem).setMinutes(null);
                        }
                    }
                });
                ((MinutesSecondsCell) holder.view).addOnSecondsChangeListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (s.length() != 0) {
                            ((MinutesSecondsEvaluationItem) evaluationItem).setSeconds(Integer.valueOf(s.toString()));
                        } else {
                            ((MinutesSecondsEvaluationItem) evaluationItem).setSeconds(null);
                        }
                    }
                });
            } else if (evaluationItem instanceof SectionCheckboxEvaluationItem) {
                ((SectionCheckboxCell) holder.view).getCheckBox().setOnCheckedChangeListener((buttonView, isChecked) -> {
                    if (!onBind) {
                        ((SectionCheckboxEvaluationItem) evaluationItem).setChecked(isChecked);
                        markParentAsChecked(evaluationItem, isChecked);
                        markChildAsChecked(evaluationItem, isChecked);
                    }
                });
                onBind = true;
                ((SectionCheckboxCell) holder.view).setChecked(((SectionCheckboxEvaluationItem) evaluationItem).isChecked());
                onBind = false;
                setupChevron(holder.view, evaluationItem);
                ((SectionCheckboxCell) holder.view).setOnClickListener(v -> {
                    if (isScreenValid()) {
                        if (activity instanceof AppCompatActivity  /*&& ((SectionCheckboxCell) holder.view).isChecked() */) {
                            expandOrCollapseList(evaluationItem, position);
                        }
                    } else {
                        showSnackbarBottomButtonError(((SectionCheckboxCell) holder.view).getRootView());
                    }
                });
            } else if (evaluationItem instanceof BoldEvaluationItem) {
                ((BoldTextCell) holder.view).setBackgroundHighlighted(((BoldEvaluationItem) evaluationItem).isBackgroundHighlighted());
            } else if (evaluationItem instanceof DatePickerEvaluationItem) {
                DatePicker datePicker = ((DatePickerCell) holder.view).getDatePicker();
                Calendar calendar = Calendar.getInstance();
                Long value = ((DatePickerEvaluationItem) evaluationItem).getDate();
                if (value != null) {
                    calendar.setTimeInMillis(value);
                }
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), (view, year, monthOfYear, dayOfMonth) -> {
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.MONTH, monthOfYear);
                    cal.set(Calendar.YEAR, year);
                    evaluationItem.setValue(cal.getTimeInMillis());
                });
            }
        }
    }

    private void setupChevron(CellItem cellItem, EvaluationItem item) {
        float rotationAngle = 0.0f;
        if (expandedItems.contains(item)) {
            rotationAngle = 90.0f;
        }
        ((ChevronCell) cellItem).getChevron().setRotation(rotationAngle);
    }

    private List<EvaluationItem> itemsToAnimateIn;
    private List<EvaluationItem> itemsToAnimateOut;

    private void expandOrCollapseList(EvaluationItem evaluationItem, int position) {
        try {
            if (expandedItems.contains(evaluationItem)) {
                collapseList(evaluationItem);
            } else {
                itemsToAnimateIn = new ArrayList<>();
                expandedItems.add(evaluationItem);
                ArrayList<EvaluationItem> children = evaluationItem.getEvaluationItemList();
                evaluationItemsList.addAll(position + 1, children);
                itemsToAnimateIn.addAll(children);
                for (EvaluationItem child : children) {
                    oldValues.put(child.getId(), child.getValue());
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            Log.e("Adapter", "Index wrong!");
        }
        notifyDataSetChanged();
    }

    private void collapseList(EvaluationItem parentItem) {
        itemsToAnimateOut = new ArrayList<>();
        expandedItems.remove(parentItem);
        List<EvaluationItem> children = parentItem.getEvaluationItemList();
        if (children != null && children.size() > 0) {
            evaluationItemsList.removeAll(children);
            for (EvaluationItem child : children) {
                oldValues.remove(child.getId());
                itemsToAnimateOut.add(child);
                collapseList(child);
            }
        }
    }

    private void populateWithSeparators(List<EvaluationItem> items) {
        if (items != null && items.size() > 0) {
            EvaluationItem firstItem = items.get(0);
            int depth = depthMap.get(firstItem.getId());
            if (depth > 1) {
                if (!(firstItem instanceof EmptyCellEvaluationItem)) {
                    items.add(0, new EmptyCellEvaluationItem(depth));
                }
                EvaluationItem lastItem = items.get(items.size() - 1);
                if (!(lastItem instanceof EmptyCellEvaluationItem)) {
                    items.add(new EmptyCellEvaluationItem(depth));
                }
            }
            for (EvaluationItem item : items) {
                List<EvaluationItem> children = item.getEvaluationItemList();
                populateWithSeparators(children);
            }
        }
    }

    private void calculateDepth(List<EvaluationItem> items, int depth) {
        if (items != null) {
            for (EvaluationItem item : items) {
                String id = item.getId();
                depthMap.put(id, depth);
                calculateDepth(item.getEvaluationItemList(), depth + 1);
                if (items.indexOf(item) == items.size() - 1) {
                    depthMapLeaf.add(id);
                }
            }
        }
    }

    public void saveAllValues() {
        for (EvaluationItem evaluationItem : evaluationItemsList) {
            EvaluationDAO.getInstance().addToHashMap(evaluationItem.getId(), evaluationItem.getValue());
        }
        EvaluationDAO.getInstance().saveValues();
    }

    public boolean isScreenValid() {
        return isScreenValid(true);
    }

    public boolean isScreenValid(boolean isEmptyAllowed) {
        boolean isValid = true;
        boolean isAllTheSame = true;
        boolean isFilled = true;
        for (int i = 0; i < evaluationItemsList.size(); i++) {
            EvaluationItem item = evaluationItemsList.get(i);
            if (!item.isValid()) {
                isValid = false;
            }
            if (
                    !isEmptyAllowed
                            && item.isMandatory()
                            && (item instanceof NumericalEvaluationItem || item instanceof StringEvaluationItem)
                            && item.getValue() == null
            ) {
                isFilled = false;
            }
            Object oldValue = oldValues.get(item.getId());
            if (oldValue != null && !Objects.equals(item.getValue(), oldValue)) {
                isAllTheSame = false;
            }
            if (!isValid && !isAllTheSame) {
                break;
            }
        }
        return isValid || (isAllTheSame && isFilled);
    }

    private void goToNextScreen(int position, SectionEvaluationItem evaluationItem) {
        saveAllValues();
        FragmentManager fragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
        if (fragmentManager != null) {
            Bundle bundle = new Bundle();

            // This block here removes bottom button reference buttons from list that should be opened
            ArrayList<String> nextSectionsArrayList = new ArrayList<>();
            for (int i = position + 1; i < getItemCount(); i++) {
                EvaluationItem nextEvaluationItem = evaluationItemsList.get(i);
                if (nextEvaluationItem instanceof SectionEvaluationItem) {
                    if (!((SectionEvaluationItem) nextEvaluationItem).isBottomButtonReferenceSkipped()) {
                        nextSectionsArrayList.add(nextEvaluationItem.getId());
                    }
                }
            }
            for (SectionEvaluationItem item : nextSectionEvaluationItems) {
                nextSectionsArrayList.add(item.getId());
            }
            bundle.putStringArrayList(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS, nextSectionsArrayList);
            if (evaluationItem.getEvaluationItemList().size() == 1 && evaluationItem.getEvaluationItemList().get(0) instanceof TabEvaluationItem) {
                TabFragment tabFragment = new TabFragment();
                bundle.putString(ConfigurationParams.TAB_SECTION_LIST, (evaluationItem.getEvaluationItemList().get(0)).getId());
                tabFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .replace(R.id.container, tabFragment)
                        .addToBackStack(fragmentManager.getClass().getSimpleName() + evaluationItem.getName())
                        .commit();
                if (evaluationItem.getSectionElementState() != SectionEvaluationItem.SectionElementState.FILLED) {
                    evaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                }
            } else {
                EvaluationListFragment evaluationListFragment = new EvaluationListFragment();
                bundle.putSerializable(ConfigurationParams.NEXT_SECTION_ID, evaluationItem.getId());
                bundle.putBoolean(ConfigurationParams.SHOULD_SHOW_ALERT, evaluationItem.isShouldShowAlert());
                evaluationListFragment.setArguments(bundle);
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                        .replace(R.id.container, evaluationListFragment)
                        .addToBackStack(fragmentManager.getClass().getSimpleName() + evaluationItem.getName())
                        .commit();
                if (evaluationItem.getSectionElementState() != SectionEvaluationItem.SectionElementState.FILLED) {
                    evaluationItem.setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                }
            }
        }
    }

    private void startMandatoryFragment(EvaluationItem sectionEvaluationItem) {
        FragmentManager fragmentManager = ((AppCompatActivity) activity).getSupportFragmentManager();
        if (fragmentManager != null) {
            EvaluationListFragment evaluationListFragment = new EvaluationListFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(ConfigurationParams.NEXT_SECTION_ID, sectionEvaluationItem.getId());
            ArrayList<String> nextSectionsArrayList = new ArrayList<>();
            int position = evaluationItemsList.indexOf(sectionEvaluationItem);

            for (int i = position + 1; i < getItemCount(); i++) {
                EvaluationItem nextEvaluationItem = evaluationItemsList.get(i);
                if (nextEvaluationItem instanceof SectionEvaluationItem) {
                    nextSectionsArrayList.add(nextEvaluationItem.getId());
                }
            }
            for (SectionEvaluationItem item : nextSectionEvaluationItems) {
                nextSectionsArrayList.add(item.getId());
            }

            bundle.putStringArrayList(ConfigurationParams.NEXT_SECTION_EVALUATION_ITEMS, nextSectionsArrayList);
            bundle.putString(ConfigurationParams.SUBTITLE, parentTitle);
            evaluationListFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.container, evaluationListFragment)
                    .addToBackStack(fragmentManager.getClass().getSimpleName() + sectionEvaluationItem.getName())
                    .commit();
        }
    }

    private void goToMandatorySection(AppCompatActivity activity, SectionEvaluationItem sectionEvaluationItem) {
        if (sectionEvaluationItem.getSectionElementState() == SectionEvaluationItem.SectionElementState.LOCKED) {
            String dependsOn = sectionEvaluationItem.getDependsOn();
            SectionEvaluationItem finalMainEvaluationItem = null;
            for (EvaluationItem evaluationItem : evaluationItemsList) {
                if (evaluationItem instanceof SectionEvaluationItem && evaluationItem.getId().equals(dependsOn)) {
                    finalMainEvaluationItem = (SectionEvaluationItem) evaluationItem;
                }
            }
            if (finalMainEvaluationItem != null) {
                goToMandatorySection(activity, finalMainEvaluationItem);
            }
        } else if (activity instanceof AppCompatActivity) {
            AlertModalManager.createAndShowDependsOnSectionAlertDialog(activity, sectionEvaluationItem.getName(), v -> {
                saveAllValues();
                startMandatoryFragment(sectionEvaluationItem);
                if ((sectionEvaluationItem).getSectionElementState() != SectionEvaluationItem.SectionElementState.FILLED) {
                    (sectionEvaluationItem).setSectionElementState(SectionEvaluationItem.SectionElementState.VIEWED);
                }
            });
        }
    }

    private void setImeOptionsForLastEditText(Object cell, int position) {
        boolean isLastInput = true;
        for (int i = position + 1; i < getItemCount(); i++) {
            if (getItemViewType(position) == TypeElementEnum.STRING.ordinal()
                    || getItemViewType(position) == TypeElementEnum.NUMERICAL.ordinal()
                    || getItemViewType(position) == TypeElementEnum.NUMERICAL_DEPENDANT.ordinal()) {
                isLastInput = false;
                break;
            }
        }
        if(cell instanceof StringEditTextCell){
            if (isLastInput) {
                ((StringEditTextCell)cell).setImeOptions(EditorInfo.IME_ACTION_DONE);
                ((StringEditTextCell)cell).setOnEditorActionListener(
                        new StringEvaluationItem.DoneOnEditorActionListener());
            } else {
                ((StringEditTextCell)cell).setImeOptions(EditorInfo.IME_ACTION_NEXT);
            }
        }else if (cell instanceof StringEditTextDependantCell) {
            if (isLastInput) {
                ((StringEditTextDependantCell)cell).setImeOptions(EditorInfo.IME_ACTION_DONE);
                ((StringEditTextDependantCell)cell).setOnEditorActionListener(
                        new StringEvaluationItem.DoneOnEditorActionListener());
            } else {
                ((StringEditTextDependantCell)cell).setImeOptions(EditorInfo.IME_ACTION_NEXT);
            }
        }
    }

    @Override
    public int getItemCount() {
        return evaluationItemsList.size();
    }

    public void setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
    }

    private void showSnackbarBottomButtonError(View view) {
        if (activity != null) {
            Snackbar snackbar = Snackbar.make(view, R.string.snackbar_bottom_button_error, Snackbar.LENGTH_LONG);
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(activity, R.color.snackbar_red));
            snackbar.show();
        }
    }

    public void resetFields() {
        for (EvaluationItem item : evaluationItemsList) {
            if (item instanceof RadioButtonGroupEvaluationItem) {
                ((RadioButtonGroupEvaluationItem) item).setChecked(false);
            } else if (item instanceof SectionCheckboxEvaluationItem) {
                ((SectionCheckboxEvaluationItem) item).setChecked(false);
            } else if (item instanceof BooleanEvaluationItem) {
                ((BooleanEvaluationItem) item).setChecked(false);
            }
            Object oldValue = oldValues.get(item.getId());
            item.setValue(oldValue);
        }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        protected CellItem view;

        ViewHolder(View itemView) {
            super(itemView);
            view = (CellItem) itemView;
        }
    }

    private int getPositionById(String id) {
        int position = 0;
        for (EvaluationItem item : evaluationItemsList) {
            if (item.getId().equals(id)) {
                return position;
            }
            position++;
        }
        return -1;
    }

    private void updateNumericalOptionalCell(String id) {
        int position = getPositionById(id);
        if (position > 0) {
            notifyItemChanged(position);
        }
    }

    private boolean isMeetCriteriaToShowOptionalValue(String dependantId, String id, double to, double from) {
        if (id.isEmpty()) {
            return false;
        }

        for (EvaluationItem item : evaluationItemsList) {
            if (item instanceof NumericalEvaluationItem) {
                if (item.getId().equals(id)) {
                    if (item.getValue() != null) {
                        double value = (double) item.getValue();
                        switch (id) {
                            case SBP:
                                if(dependantId.equals(SBP_OPTIONAL_LOWER)){
                                    return value < from;
                                }else if(dependantId.equals(SBP_OPTIONAL_UPPER)){
                                    return  value > to;
                                }
                            case DBP:
                                return value > to;
                            case NA_MEQ_L:
                                return value < to;
                        }
                    }
                }
            }
        }
        return false;
    }

    private String getFormattedString(View view, String id, String hint, double to, double from){
        if (id.isEmpty()) {
            return "";
        }
        for (EvaluationItem item : evaluationItemsList) {
            if (item instanceof NumericalEvaluationItem) {
                if (item.getId().equals(id)) {
                    if (item.getValue() != null) {
                        double value = (double) item.getValue();
                        switch (id) {
                            case SBP:
                                if (value > to) {
                                    return String.format(hint,
                                            view.getContext().getString(R.string.greater),
                                            to);
                                } else if (value < from) {
                                    return String.format(hint,
                                            view.getContext().getString(R.string.less),
                                            from);
                                }
                            case DBP:
                                if (value > to) {
                                    return String.format(hint,
                                            view.getContext().getString(R.string.greater),
                                            to);
                                }
                            case NA_MEQ_L:
                                if (value < to) {
                                    return String.format(hint,
                                            view.getContext().getString(R.string.less),
                                            to);
                                }
                        }
                    }
                }
            }
        }
        return "";
    }

    private boolean isSPBandDBPOptionalCell(String id) {
        return id.equals(SBP_OPTIONAL_LOWER)  || id.equals(SBP_OPTIONAL_UPPER) ||
                id.equals(DBP_OPTIONAL);
    }

    private boolean isNaMEQLOptionalCell(String id) {
        return id.equals(URINE_NA_MEQ_L) || id.equals(SERUM_OSMOLALITY) ||
                id.equals(URINE_OSMOLALITY);
    }
}