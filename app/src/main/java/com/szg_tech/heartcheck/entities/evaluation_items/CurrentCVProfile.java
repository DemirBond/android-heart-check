package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.EmptyCellEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

import static com.szg_tech.heartcheck.core.ConfigurationParams.*;

class CurrentCVProfile extends SectionEvaluationItem {

    CurrentCVProfile(Context context) {
        super(context, CURRENT_PAST_CV_PROFILE, null);
        name = "Cardiovascular";
        this.evaluationItemList = createEvaluationItemElementsList(context);
        sectionElementState = SectionEvaluationItem.SectionElementState.LOCKED;
        this.dependsOn = BIO;
    }

    public class CoronaryHeartDisease extends SectionEvaluationItem {
        public CoronaryHeartDisease(Context context) {
            super(context, CORONARY_HEART_DISEASE, null);
            name = getString(R.string.coronary_heart_disease);
            this.evaluationItemList = createEvaluationItemElementsList();
            sectionElementState = SectionEvaluationItem.SectionElementState.OPENED;
        }

        private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
            ArrayList<EvaluationItem> list = new ArrayList<>();
            list.add(new SectionCheckboxEvaluationItem(ACUTE_CORONARY_SYNDROME, getString(R.string.acute_coronary_syndrome), new ArrayList<EvaluationItem>() {
                {
                    add(new BooleanEvaluationItem(MORE_2_ANGINA_24HR, "chkangina"));
                    add(new BooleanEvaluationItem(ANGINA_MORE_20MIN, getString(R.string.angina_more_20min)));
                    add(new BooleanEvaluationItem(ASA_ACS, getString(R.string.asa_use_in_past_1_week)));
                    add(new BooleanEvaluationItem(POSITIVE_TROP_I_OR_T, getString(R.string.positive_trop_i_or_t)));
                    add(new BooleanEvaluationItem(MORE_2_ANTANGINAL, getString(R.string.more_2_antanginal)));
                    add(new SectionCheckboxEvaluationItem(STEMI, getString(R.string.stemi), new ArrayList<EvaluationItem>() {
                        {
                            add(new NumericalEvaluationItem(DURATION_HOURS, getString(R.string.duration_hours), getString(R.string.value), 0, 48, true));
                            add(new BooleanEvaluationItem(ANTERIOR, getString(R.string.anterior)));
                            add(new BooleanEvaluationItem(INFERIOR, getString(R.string.inferior)));
                            add(new BooleanEvaluationItem(OTHER, getString(R.string.other)));
                        }
                    }));
                    add(new BooleanEvaluationItem(REFRACTORY_ANGINA, getString(R.string.refractory_angina)));
                    add(new BooleanEvaluationItem(CHANGING_TROP_I, getString(R.string.changing_trop_i)));
                }
            }));
            list.add(new SectionCheckboxEvaluationItem(PCI_CABG, getString(R.string.pci_cabg), new ArrayList<EvaluationItem>() {
                {
                    add(new NumericalEvaluationItem(LAST_PROCEDURE, getString(R.string.last_procedure), getString(R.string.value), 0, 50, true));
                    add(new BooleanEvaluationItem(BMS, getString(R.string.bms)));
                    add(new BooleanEvaluationItem(DES, getString(R.string.des)));
                    add(new SectionCheckboxEvaluationItem(CABG, getString(R.string.cabg), new ArrayList<EvaluationItem>() {
                        {
                            add(new BooleanEvaluationItem(AUTO_VEIN, getString(R.string.auto_vein)));
                            add(new BooleanEvaluationItem(AUTO_ARTERY, getString(R.string.auto_artery)));
                            add(new BooleanEvaluationItem(NON_AUTO, getString(R.string.non_auto)));
                        }
                    }));
                }
            }));
            list.add(new SectionCheckboxEvaluationItem(NYHA_CCVS_CLASS, "NYHA Class", new ArrayList<EvaluationItem>() {
                {
                    add(new RadioButtonGroupEvaluationItem(NYHA_CCVS_CLASS_1, "NYHA Class 1", "section_nyha_class", false));
                    add(new RadioButtonGroupEvaluationItem(NYHA_CCVS_CLASS_2, "NYHA Class 2", "section_nyha_class", false));
                    add(new RadioButtonGroupEvaluationItem(NYHA_CCVS_CLASS_3, "NYHA Class 3", "section_nyha_class", false));
                    add(new RadioButtonGroupEvaluationItem(NYHA_CCVS_CLASS_4, "NYHA Class 4", "section_nyha_class", false));
                }
            }));
            list.add(new BooleanEvaluationItem(LM, getString(R.string.lm)));
            list.add(new BooleanEvaluationItem(LAD, getString(R.string.lad)));
            list.add(new BooleanEvaluationItem(RCA, getString(R.string.rca)));
            list.add(new BooleanEvaluationItem(LCX, getString(R.string.lcx)));
            list.add(new SectionCheckboxEvaluationItem(ICD_10, getString(R.string.icd_10), new ArrayList<EvaluationItem>() {
                {
                    add(new BooleanEvaluationItem(CHRONIC_TOTAL_OCCLUSION, getString(R.string.chronic_total_occlusion)));
                    add(new BooleanEvaluationItem(CORONARY_ANEURYSM, getString(R.string.coronary_aneurysm)));
                    add(new BooleanEvaluationItem(CORONARY_DISSECTION, getString(R.string.coronary_dissection)));
                    add(new BooleanEvaluationItem(CALCIFIED_CORONARY_LESION, getString(R.string.calcified_coronary_lesion)));
                    add(new BooleanEvaluationItem(LIPID_RICH_PLAQUE, getString(R.string.lipid_rich_plaque)));
                    add(new BooleanEvaluationItem(DOCUMENTED_VASOSPASM, getString(R.string.documented_vasospasm)));
                }
            }));
            list.add(new NumericalEvaluationItem(VESSEL_MORE_50, getString(R.string.vessel_more_50), getString(R.string.value), 1, 3, true));
            list.add(new NumericalEvaluationItem(LVEF_CHD, getString(R.string.lvef), getString(R.string.value), 10, 80, true));
            return list;
        }
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList(final Context context) {
        return new ArrayList<EvaluationItem>() {
            {
                add(new CoronaryHeartDisease(tempContext));
                add(new SectionEvaluationItem(tempContext, SYSTEMIC_ARTERIAL_HYPERTENSION, "Hypertension", new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(AMB_SBP, "Ambulatory SBP", "Value", 80, 190, true));
                        add(new NumericalEvaluationItem(AMB_DBP, "Ambulatory DBP", "Value", 30, 150, true));

                        add(new BooleanEvaluationItem(SBP_TREATED, "SBP treated"));
                        add(new BooleanEvaluationItem(AFRICAN_AMERICAN, "African American"));
                        add(new BoldEvaluationItem(SECONDARY_HYPERTENSION, "Secondary hypertension") {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(PRIMARY_HYPERALDESTERONISM, "Primary hyperaldesteronism"));
                        add(new BooleanEvaluationItem(RENOVASCULAR_ATHEROSCLEROTIC, "Atherosclerotic renovascular"));
                        add(new BooleanEvaluationItem(PHEOCROMOCYTOMA, "Pheocromocytoma"));
                        add(new BooleanEvaluationItem(OSA, "OSA"));
                        add(new BoldEvaluationItem(ACUTELY_SYMPTOMATIC, "Acutely Symptomatic") {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(BACK_PAIN, "Chest or back pain"));
                        add(new BooleanEvaluationItem(HEADACHED_BLURRED_VISION_OR_AMS, "Headache"));
                        add(new BooleanEvaluationItem(BLURRED_VISION, "Blurred vision"));
                            add(new BooleanEvaluationItem(EPISTAXIS, "Epistaxis"));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED) {
                    {
                        setBottomButtonReferenceSkipped(true);
                    }
                });
                add(new SectionEvaluationItem(tempContext, HEART_FAILURE, getString(R.string.heart_failure), new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(HF_DIAGNOSIS_DURATION_WEEK, "Duration / week", getString(R.string.value), 0, 999, true));
                        add(new BooleanEvaluationItem(PREVIOUS_HF_HOSPITALIZATION, getString(R.string.previous_hf_hospitalization)));
                        add(new BooleanEvaluationItem(S_P_ICD, "Status post AICD"));
                        add(new BooleanEvaluationItem(CRT_ICD, "Status post CRT"));
                        add(new NumericalEvaluationItem(LVEF, getString(R.string.lvef), getString(R.string.value), 10, 80, true));
                        add(new SectionEvaluationItem(tempContext, NYHA_CLASS, "Heart Failure Class / Stage", new ArrayList<EvaluationItem>() {
                            {
                                add(new SectionCheckboxEvaluationItem(NYHA_CCVS_CLASS, "NYHA Class", new ArrayList<EvaluationItem>() {
                                    {
                                        add(new RadioButtonGroupEvaluationItem(NYHA_CCVS_CLASS_1, "NYHA Class 1", "section_nyha_class", false));
                                        add(new RadioButtonGroupEvaluationItem(NYHA_CCVS_CLASS_2, "NYHA Class 2", "section_nyha_class", false));
                                        add(new RadioButtonGroupEvaluationItem(NYHA_CCVS_CLASS_3, "NYHA Class 3", "section_nyha_class", false));
                                        add(new RadioButtonGroupEvaluationItem(NYHA_CCVS_CLASS_4, "NYHA Class 4", "section_nyha_class", false));
                                    }
                                }));
                                add(new BooleanEvaluationItem(AT_HIGH_RISK, getString(R.string.at_high_risk)));
                                add(new BooleanEvaluationItem(NO_SIGNS_OF_HF, getString(R.string.no_signs_of_hf)));
                                add(new BooleanEvaluationItem(SYMPTOMS_OF_HF, getString(R.string.symptoms_of_hf)));
                                add(new SectionCheckboxEvaluationItem(REFRACTORY_HF, getString(R.string.refractory_hf), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BoldEvaluationItem(CALCULATE_HFSS, getString(R.string.calculate_hfss)));
                                        add(new SectionCheckboxEvaluationItem(NO_SIGNIFICANT_COMORBIDITIES, getString(R.string.no_significant_comorbidities), new ArrayList<EvaluationItem>() {
                                            {
                                            }
                                        }) {
                                            {
                                                setShouldShowAlert(true);
                                            }
                                        });
                                        add(new NumericalEvaluationItem(VO_MAX_KG, getString(R.string.vo_max_kg), getString(R.string.value), 6, 40, true));
                                    }
                                }));

                            }
                        }, SectionElementState.OPENED) {
                            {
                                setHasStateIcon(false);
                            }
                        });
                        add(new EmptyCellEvaluationItem());
                        add(new BooleanEvaluationItem(IDIOPATHIC_DCM_NONISCHEMIC, getString(R.string.idiopathic_dcm_nonischemic)));
                        add(new SectionCheckboxEvaluationItem(POST_MI_MORE_45, getString(R.string.post_mi_more_45), new ArrayList<EvaluationItem>() {
                            {
                                new BooleanEvaluationItem(LV_ANEURYSM, getString(R.string.lv_aneurysm));
                            }
                        }));
                        add(new BooleanEvaluationItem(ISCHEMIC_POST_MI_LESS_45, getString(R.string.ischemic_post_mi_less_45)));
                        add(new BooleanEvaluationItem(CARDIOTOXINS, getString(R.string.cardiotoxins)));
                        add(new BooleanEvaluationItem(FAMILIAL_CMP, getString(R.string.familial_cmp)));
                        add(new BooleanEvaluationItem(MYOCARDITIS, "Myocarditis"));
                        add(new BooleanEvaluationItem(RV_DYSPLASIA, getString(R.string.rv_dysplasia)));
                        add(new SectionCheckboxEvaluationItem(HOCM, getString(R.string.hocm), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(LVH_MORE_30, getString(R.string.lvh_more_30)));
                                add(new BooleanEvaluationItem(ABNORMAL_BP_RESPONSE_TO_EXERCISE, getString(R.string.abnormal_bp_response_to_exercise)));
                                add(new BooleanEvaluationItem(HISTORY_OF_SUDDEN_DEATH, getString(R.string.history_of_sudden_death)));
                                add(new BooleanEvaluationItem(REST_DYNAMIC_PEAK, getString(R.string.rest_dynamic_peak)));
                            }
                        }));
                        add(new BooleanEvaluationItem(PERIPARTUM_CMP, getString(R.string.peripartum_cmp)));

                    }
                }, SectionElementState.OPENED));
                add(new SectionEvaluationItem(tempContext, ATRIAL_FIBRILATION, getString(R.string.atrial_fibrilation), new ArrayList<EvaluationItem>() {
                    {
                        add(new EmptyCellEvaluationItem());
                        add(new BooleanEvaluationItem(CHRONIC_AF, getString(R.string.chronic_af)));
                        add(new BooleanEvaluationItem(PERSISTENT_AF, getString(R.string.persistent_af)));
                        add(new BooleanEvaluationItem(PAROXYMAL_AF, getString(R.string.paroxymal_af)));
                        add(new BooleanEvaluationItem(S_P_SUCCESSFUL_ABLATION, getString(R.string.s_p_successful_ablation)));
                        add(new BoldEvaluationItem(PLEASE_SELECT_ONE, getString(R.string.please_select_one)));
                        add(new RadioButtonGroupEvaluationItem(RHYTM_CONTROL, getString(R.string.rhytm_control), "radio_section", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new SectionCheckboxEvaluationItem(CURRENT_ANIARRYTHMIC_THERAPY, getString(R.string.current_aniarrythmic_therapy), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(PROPOFONONE_FLECANIDE, getString(R.string.propofonone_flecanide)));
                                        add(new BooleanEvaluationItem(SOTALOL_AMIODARONE_MULTAQ_DOFETILIDE, getString(R.string.sotalol_amiodarone_multaq_dofetilide)));
                                    }
                                }));

                            }
                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new RadioButtonGroupEvaluationItem(VENTRICULAR_RATE_CONTROL, getString(R.string.ventricular_rate_control), "radio_section", false, new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(HEART_RATE_WITH_ACTIVITY, getString(R.string.heart_rate_with_activity), getString(R.string.value), 40, 300, true));
                            }
                        }) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new EmptyCellEvaluationItem());
                        add(new SectionCheckboxEvaluationItem(SYMPTOMATIC, getString(R.string.symptomatic), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(ACUTELY, getString(R.string.acutely)));
                            }
                        }));


                        add(new NumericalEvaluationItem(DURATION_DAYS, getString(R.string.duration_days), getString(R.string.value), 0, 999, true));

                        add(new EmptyCellEvaluationItem());
                        add(new SectionCheckboxEvaluationItem(PREVIOUS_TIA_CVA, getString(R.string.previous_tia_cva), new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(LAST_THROMBOEMBOLIC_EVENT_MONTHS_AGO, getString(R.string.last_thromboembolic_event_months_ago), getString(R.string.value), 0, 600, true));
                            }
                        }));

                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
                add(new SectionEvaluationItem(tempContext, THROMBOEMBOLIC_VKA, getString(R.string.thromboembolic_vka), new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionEvaluationItem(tempContext, THROMBOEMBOLIC_PREVENTION_VKA_THERAPY, "Thromboembolism / VKA ", new ArrayList<EvaluationItem>() {
                            {

                                add(new SectionCheckboxEvaluationItem(PATIENT_BLEED_RISK, "Patient related bleeding risk", new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(ACTIVE_GASTRODUODENAL_ULCER, getString(R.string.active_gastroduodenal_ulcer)));
                                        add(new BooleanEvaluationItem(BLEED_IN_3_MO_BEFORE_ADMISSION, getString(R.string.bleed_in_3_mo_before_admission)));
                                        add(new BooleanEvaluationItem(PLATELET_COUNT_LESS_50, getString(R.string.platelet_count_less_50)));
                                        add(new BooleanEvaluationItem(ICU_OR_CCU_ADMISSION, getString(R.string.icu_or_ccu_admission)));
                                        add(new BooleanEvaluationItem(CENTRAL_VENOUS_CATHETER, getString(R.string.central_venous_catheter)));

                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(PROCEDURAL_BLEED_RISK, "Procedure related bleeding risk", new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(PRIOR_BLEED_DURING_BRIDGING_SIMILAR, getString(R.string.prior_bleed_during_bridging_similar)));
                                        add(new BooleanEvaluationItem(PRIOR_ASA_USE, getString(R.string.prior_asa_use)));
                                        add(new BooleanEvaluationItem(RISK_NOT_CLINICALLY_IMPORTANT_LOW, getString(R.string.risk_not_clinically_important_low)));
                                        add(new BooleanEvaluationItem(RISK_UNCERTAIN, getString(R.string.risk_uncertain)));
                                        add(new BooleanEvaluationItem(RISK_INTERMEDIATE_HIGH, getString(R.string.risk_intermediate_high)));
                                    }
                                }));
                                add(new BooleanEvaluationItem(DEEP_VENOUS_THROMBOSIS, getString(R.string.deep_venous_thrombosis)));
                                add(new BooleanEvaluationItem(PULMONARY_EMBOLISM, getString(R.string.pulmonary_embolism)));
                                add(new SectionCheckboxEvaluationItem(DVY_PE_DIAGNOSIS_PREVENTION, "DVT diagnosis, prevention", new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(MAJOR_SURGERY_TRAUMA, getString(R.string.major_surgery_trauma)));
                                        add(new BooleanEvaluationItem(MAJOR_GYN_UROLOGY, getString(R.string.major_gyn_urology)));
                                        add(new BooleanEvaluationItem(TKR, getString(R.string.tkr)));
                                        add(new BooleanEvaluationItem(THR, getString(R.string.thr)));
                                        add(new BooleanEvaluationItem(HIP_FRACTURE, getString(R.string.hip_fracture)));
                                        add(new BooleanEvaluationItem(SPINE_SURGERY, getString(R.string.spine_surgery)));
                                        add(new BooleanEvaluationItem(SPINAL_CORD_INJURY, getString(R.string.spinal_cord_injury)));
                                        add(new SectionCheckboxEvaluationItem(MEDICAL_ILLNESS, getString(R.string.medical_illness), new ArrayList<EvaluationItem>() {
                                            {


                                                add(new BooleanEvaluationItem(PAINFUL_DEEP_VENOUS_PALPATION_AND_EDEMA, getString(R.string.painful_deep_venous_palpation_and_edema)));


                                                add(new BooleanEvaluationItem(RESPIRATORY_FAILURE, getString(R.string.respiratory_failure)));
                                                add(new BooleanEvaluationItem(ALREADY_KNOWN_THROMBOPHILIC_CONDITION, getString(R.string.already_known_thrombophilic_condition)));
                                                add(new BooleanEvaluationItem(RECENT_TRAUMA_SURGERY, getString(R.string.recent_trauma_surgery)));
                                                add(new BooleanEvaluationItem(REDUCED_MOBILITY, getString(R.string.reduced_mobility)));
                                                add(new BooleanEvaluationItem(ONGOING_HORMONAL_TREATMENT, getString(R.string.ongoing_hormonal_treatment)));
                                                add(new BooleanEvaluationItem(ACUTE_INFECTION_RHEUMATOLOGIC_DISORDER, "Active infection, rheumatologic disorder"));
                                            }
                                        }));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(ACUTE_CVA, getString(R.string.acute_cva), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(NIHSS, getString(R.string.nihss), getString(R.string.value), 0, 42, true));
                                        add(new BooleanEvaluationItem(UNILATERAL_WEAKNESS, getString(R.string.unilateral_weakness)));
                                        add(new BooleanEvaluationItem(SPEECH_DISTURBANCE, getString(R.string.speech_disturbance)));
                                        add(new NumericalEvaluationItem(DURATION_OF_SYMPTOMS, getString(R.string.duration_of_symptoms), getString(R.string.value), 0, 24, true));
                                        add(new BooleanEvaluationItem(PRE_HOSPITAL_CARE, getString(R.string.pre_hospital_care)));
                                    }
                                }));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(tempContext, VALVULAR_HEART_DISEASE_THROMBOEMBOLIC, "Valvular heart disease ", new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(MECHANICAL_CAGEBALL, getString(R.string.mechanical_cageball)));
                                add(new BooleanEvaluationItem(MECHANICAL_DISK_BILEAFLET_MITRAL, getString(R.string.mechanical_disk_bileaflet_mitral)));
                                add(new BooleanEvaluationItem(MECHANICAL_DISK_BILEAFLET_AORTIC, getString(R.string.mechanical_disk_bileaflet_aortic)));
                                add(new SectionCheckboxEvaluationItem(RHEUMATIC_MITRAL_VALVE_DISEASE, getString(R.string.rheumatic_mitral_valve_disease), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(LA_THROMBUS, getString(R.string.la_thrombus)));
                                        add(new NumericalEvaluationItem(LA_DIAMETER, getString(R.string.la_diameter), getString(R.string.value), 2, 7, true));
                                    }
                                }));
                                add(new BooleanEvaluationItem(BIOPROSTHETIC_VALVE, getString(R.string.bioprosthetic_valve)));
                                add(new BooleanEvaluationItem(SYSTEMIC_EMBOLISM, getString(R.string.systemic_embolism)));
                                add(new BooleanEvaluationItem(INFECTIVE_ENDROCARDITIS, getString(R.string.infective_endrocarditis)));
                                add(new BooleanEvaluationItem(LEFT_SIDED_PV_THROMBOSIS, getString(R.string.left_sided_pv_thrombosis)));
                                add(new BooleanEvaluationItem(RIGHT_SIDED_PV_THROMBOSIS, getString(R.string.right_sided_pv_thrombosis)));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(tempContext, CARDIAC_SOURCE_OF_EMBOLISM, getString(R.string.cardiac_source_of_embolism), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(NON_ACUTE_ARTERIAL_ISCHEMIC_STROKE, getString(R.string.non_acute_arterial_ischemic_stroke)) {
                                    {
                                        setBackgroundHighlighted(true);
                                    }
                                });
                                add(new BooleanEvaluationItem(AORTIC_ARCH_ATHEROSCLEROSIS, getString(R.string.aortic_arch_atherosclerosis)));
                                add(new BooleanEvaluationItem(LV_THROMBUS, getString(R.string.lv_thrombus)));
                                add(new BooleanEvaluationItem(PFO, getString(R.string.pfo)));
                                add(new BooleanEvaluationItem(MVP, getString(R.string.mvp)));
                                add(new BooleanEvaluationItem(MITRAL_ANNULAR_VALCIFICATION, getString(R.string.mitral_annular_valcification)));
                                add(new BooleanEvaluationItem(CALCIFIC_AORTIC_VALVE_DISEASE, getString(R.string.calcific_aortic_valve_disease)));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(tempContext, MISCELLANEOUS, getString(R.string.miscellaneous), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(HIT, getString(R.string.hit)));
                                add(new BooleanEvaluationItem(CEREBRAL_VENOUS_THROMBOSIS, getString(R.string.cerebral_venous_thrombosis)));
                                add(new BooleanEvaluationItem(HYPERCOAGULABLE_STATE, getString(R.string.hypercoagulable_state)));
                            }
                        }, SectionElementState.OPENED));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
                add(new SectionEvaluationItem(tempContext, VENTRICULAR_TACHYARRTHYMIAS, getString(R.string.ventricular_tachyarrthymias), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(NSVT, getString(R.string.nsvt)));
                        add(new BooleanEvaluationItem(MONOMORPHIC_VT, getString(R.string.monomorphic_vt)));
                        add(new BooleanEvaluationItem(REPETITIVE_MONOMORPHIC_VT, getString(R.string.repetitive_monomorphic_vt)));
                        add(new BooleanEvaluationItem(POLYMORPHIC_VT, getString(R.string.polymorphic_vt)));
                        add(new BooleanEvaluationItem(TORSADES, getString(R.string.torsades)));
                        add(new BooleanEvaluationItem(INCESSANT_VT, getString(R.string.incessant_vt)));
                        add(new BooleanEvaluationItem(IDIOPATHIC_VT, getString(R.string.idiopathic_vt)));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED) {
                    {
                        setBottomButtonReferenceSkipped(true);
                    }
                });
                add(new SectionEvaluationItem(tempContext, BRADYARRTHYMIA_SYNCOPE, getString(R.string.bradyarrthymia_syncope), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(SYMPTOMATIC_SINUS_NODE_DYSFUNCTION, getString(R.string.symptomatic_sinus_node_dysfunction)));
                        add(new BooleanEvaluationItem(HIGH_GRADE_AV_NODE_DISEASE, getString(R.string.high_grade_av_node_disease)));
                        add(new BooleanEvaluationItem(ISOLATED_NEUROCARDIOGENIC_UNEXPLAINED_SYNCOPE, getString(R.string.isolated_neurocardiogenic_unexplained_syncope)));
                        add(new BooleanEvaluationItem(CAROTID_SINUS_HYPERSENSITIVITY, getString(R.string.carotid_sinus_hypersensitivity)));
                        add(new BooleanEvaluationItem(POTS, getString(R.string.pots)));
                        add(new BooleanEvaluationItem(AUTONOMIC_FAILURE_SYNDROME, getString(R.string.autonomic_failure_syndrome)));
                        add(new BooleanEvaluationItem(HISTORY_OF_CARDIAC_ARREST, getString(R.string.history_of_cardiac_arrest)));
                        add(new BooleanEvaluationItem(BRUGADA_SYNDROME, getString(R.string.brugada_syndrome)));
                        add(new BooleanEvaluationItem(LONG_QT, getString(R.string.long_qt)));
                        add(new BooleanEvaluationItem(SARCOIDOSIS_GIANT_CELL_CHAGAS, getString(R.string.sarcoidosis_giant_cell_chagas)));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED) {
                    {
                        setBottomButtonReferenceSkipped(true);
                    }
                });

                add(new SectionEvaluationItem(tempContext, VALVULAR_HEART_DISEASE, getString(R.string.valvular), new ArrayList<EvaluationItem>() {
                    {
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED) {
                    {
                        setShouldShowAlert(true);
                    }
                });
                add(new SectionEvaluationItem(tempContext, PULMONARY_HYPERTENSION, getString(R.string.pulmonary_hypertension), new ArrayList<EvaluationItem>() {
                    {
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED) {
                    {
                        setShouldShowAlert(true);
                    }
                });
                add(new SectionEvaluationItem(tempContext, VASCULAR_DISEASES, getString(R.string.vascular_diseases), new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionEvaluationItem(tempContext, SYMPTOMATIC_CAROTID_DISEASE, getString(R.string.symptomatic_carotid_disease), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(NONCARDIOEMBOLIC_VCA_TIA, "Noncardioembolic CVA associated with Carotid Plaque"));
                                add(new BooleanEvaluationItem(NONCARDIOEMBOLIC_TIA, "Noncardioembolic TIA associated with Carotid Plaque"));
                                add(new BooleanEvaluationItem(MORE_50_CAROTID_STENOSIS, getString(R.string.more_50_carotid_stenosis)));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(tempContext, PERIPHERIC_VASCULAR_DISEASE, getString(R.string.peripheric_vascular_disease), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(ABI_LESS_09, getString(R.string.abi_less_09)));

                                add(new BooleanEvaluationItem(CRITICAL_LIMB_ISCHEMIA, getString(R.string.critical_limb_ischemia)));
                                add(new BooleanEvaluationItem(ENDOVASCULAR_REVASCULARIZATION, getString(R.string.endovascular_revascularization)));
                                add(new BooleanEvaluationItem(PERIPHERAL_ARTERY_BYPASS_GRAFT, getString(R.string.peripheral_artery_bypass_graft)));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(tempContext, ABDOMINAL_AORTIC_ANEURYSM, "Aortic Aneurysm", new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(AA_DIAMETER_MORE_5, getString(R.string.aa_diameter_more_5)));
                                add(new BooleanEvaluationItem(THORACIC, "Thoracic Aortic Aneurysm "));
                                add(new BooleanEvaluationItem(THORACIC_ABDOMINAL, "Thoracoabdominal Aortic Aneurysm"));
                            }
                        }, SectionElementState.OPENED));
                    }
                }, SectionEvaluationItem.SectionElementState.OPENED));
            }
        };
    }
}
