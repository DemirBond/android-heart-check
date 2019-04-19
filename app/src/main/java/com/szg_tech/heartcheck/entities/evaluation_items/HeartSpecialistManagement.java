package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionPlaceholderEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.StringEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.TabEvaluationItem;

import static com.szg_tech.cvdevaluator.core.ConfigurationParams.*;

import java.util.ArrayList;

public class HeartSpecialistManagement extends SectionEvaluationItem {
    public HeartSpecialistManagement(Context context) {
        super(context, HEART_SPECIALIST_MANAGEMENT, null);
        name = getString(R.string.heart_specialist_management);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionEvaluationItem(tempContext, BIO_PAH_MAIN, " Exercise capacity ", new ArrayList<EvaluationItem>() {
                    {

                        add(new NumericalEvaluationItem(SIX_MW_DISTANCE, "txt6MWT","value", 50, 600, true));
                        add(new NumericalEvaluationItem(MAX_VO_MG_KG_MIN, "txtVO2", "value",6, 40, true));

                    }

                }, SectionElementState.OPENED));



               }
            {

                add(new SectionEvaluationItem(tempContext, PAH, "PAH", new ArrayList<EvaluationItem>() {
                    {

                                add(new SectionEvaluationItem(tempContext, "tab_pg1", "PAH", new ArrayList<EvaluationItem>() {
                                    {

                                        add(new BooleanEvaluationItem(IDIOPATHIC, "chkIdio"));
                                        add(new SectionCheckboxEvaluationItem(CONGENITAL, "chkCongenital", new ArrayList<EvaluationItem>() {
                                            {
                                                add(new BooleanEvaluationItem(ASD_LESS_2CM, "chkASD"));
                                                add(new BooleanEvaluationItem(VSD_LESS_1CM, "chkVSD"));
                                                add(new BooleanEvaluationItem(POST_CORRECTIVE_SURGERY, "chkPCS"));
                                                add(new BooleanEvaluationItem(EISENMENGER, "chkEisen"));
                                            }
                                        }));
                                        add(new BooleanEvaluationItem(SCLERODERMA, "chkSclero"));
                                        add(new BooleanEvaluationItem(SLE, "chkSLE"));
                                        add(new BooleanEvaluationItem(HIV, "chkHIV"));
                                        add(new BooleanEvaluationItem(PORTAL_HYPERTENSION, "chkFF"));
                                        add(new BooleanEvaluationItem(RESPIRATORY_DISEASE_HYPOXIA, "chkRESP "));


                                        add(new BooleanEvaluationItem(PVOD_PCH, "chkPVOD"));
                                        add(new BooleanEvaluationItem(SPLENECTOMY_SC, "chkSplen"));
                                        add(new BooleanEvaluationItem(FAMILIAL, "chkFamilial"));
                                        add(new BooleanEvaluationItem(CTEP, "chkCTEP"));
                                        add(new BooleanEvaluationItem(DRUGS_TOXINS, "chkDrugs"));
                                    }
                                }));



                    }

                }, SectionElementState.OPENED));

                add(new SectionEvaluationItem(tempContext, VALVULAR, "Valvular Heart Disease", new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionEvaluationItem(tempContext, VALVULAR, "secvalvular", new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(LVEF_PAH, "txtLVEF", "value", 10, 80, true));
                                add(new BooleanEvaluationItem(NEW_ONSET_ATRIAL_FIBRILATION, "chknewonsetAF"));
                                add(new BooleanEvaluationItem(PREGNANCY, "chkpreg"));
                                add(new SectionCheckboxEvaluationItem(AORTIC_STENOSIS, "chkAorticStenosis", new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(CALCIFIED_AORTIC_VALVE_REDUCED_SYSTOLIC_OPENING, "chkCalcAortValve"));
                                        add(new BooleanEvaluationItem(CONGENITALLY_STENOTIC_AORTIC_VALVE, "chkCongenStenAortValve"));
                                        add(new BooleanEvaluationItem(RHEUMATIC_AV, "chkreumaticAV"));
                                        add(new NumericalEvaluationItem(CALCULATED_AORTIC_VALVE_AREA, "txtCalcAortValveArea", "value", 0.1, 4, false));
                                        add(new NumericalEvaluationItem(AORTIC_MEAN_PRESSURE_GRADIENT, "txtAortMeanPressGradient", "value", 4, 60, true));
                                        add(new NumericalEvaluationItem(AORTIC_VALVE_VALOCITY, "txtAortValveVel","value", 1, 6, true));
                                        add(new NumericalEvaluationItem(STROKE_VOLUME_INDEX_SV_SBA, "txtStrokeVolIndex", "value", 1, 9, true));
                                        add(new NumericalEvaluationItem(INDEXED_VALVE_AREA_AVA_BSA, "txtIndexedValveArea","value", 0.1, 9, false));
                                        add(new NumericalEvaluationItem(BISCUSPID_AORTIC_ROOT_DIAMETER, "txtAortRootDiameter", "value", 0.1, 7, false));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(MITRAL_STENOSIS, "chkMitralStenosis", new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(MVA_CM_2, "txtMVA", "value", 0.1, 9, false));
                                        add(new NumericalEvaluationItem(PHT_MSEC, "txtPHT", "value", 50, 400, true));
                                        add(new BooleanEvaluationItem(RHEUMATIC_MV_TV, "chkrheumaticMV"));
                                        add(new BooleanEvaluationItem(FAVORABLE_VALVE_MORPHOLOGY, "chkFavValveMorph"));
                                        add(new BooleanEvaluationItem(LA_CLOT, "chkLAClot"));
                                    }
                                }));

                                add(new SectionCheckboxEvaluationItem(PULMONIC_STENOSIS, "chkPulmonicStenosis", new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(PULMONIC_VALVE_VELOCITY, "txtPulValveVel", "value", 0.5, 5, false));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(AORTIC_REGURGITATION, "chkAorticRegurgitation", new ArrayList<EvaluationItem>() {
                                        {
                                        add(new BooleanEvaluationItem(HOLODIASTOLIC_FLOW_REVERSAL, "chkHolodiastolicRev"));
                                        add(new NumericalEvaluationItem(VENA_CONTRACTA_WIDTH, "txtVenaContractaWidth2", "value", 0.1, 9, false));
                                        add(new NumericalEvaluationItem(REGURGITANT_VOLUME_ML_BEAT, "txtRegurVolume", "value", 0, 99, true));
                                        add(new NumericalEvaluationItem(REGURGITANT_FRACTION, "txtRegurFrac", "value", 0, 61, true));
                                        add(new NumericalEvaluationItem(ERO, "txtERO", "value", 0.1, 9, false));
                                        add(new NumericalEvaluationItem(LVEDD_MM, "txtLVEDd", "value", 10, 90, true));
                                        add(new NumericalEvaluationItem(LVESD_MM, "txtLVESd", "value", 10, 60, true));
                                        add(new NumericalEvaluationItem(AORTIC_ROOT_DIAMETER, "txtAorticRootDiameter", "value", 2, 9, true));
                                }
                                }));
                                add(new SectionCheckboxEvaluationItem(PRIMARY_MITRAL_REGURGITATION, "", new ArrayList<EvaluationItem>() {
                                    {

                                        add(new NumericalEvaluationItem(VENA_CONTRACTA_WIDTH, "txtVenaContractaWidth2", "value", 0.1, 9, false));
                                        add(new NumericalEvaluationItem(REGURGITANT_VOLUME_ML_BEAT, "txtRegurVolume", "value", 0, 99, true));
                                        add(new NumericalEvaluationItem(REGURGITANT_FRACTION, "txtRegurFrac", "value", 0, 61, true));
                                        add(new NumericalEvaluationItem(ERO, "txtERO", "value", 0.1, 9, false));
                                        add(new NumericalEvaluationItem(LVEDD_MM, "txtLVEDd", "value", 10, 90, true));
                                        add(new NumericalEvaluationItem(LVESD_MM, "txtLVESd", "value", 10, 60, true));

                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(TRICUSPID_REGURGITATION, "chkTricuspidRegurgitation", new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(ANNULAR_DIAMETER, "txtAnnularDiameter", "value", 0.1, 9, false));
                                        add(new NumericalEvaluationItem(CENTRAL_JET_AREA_CM_2, "txtCentralJetArea", "value", 0.1, 9, false));
                                        add(new NumericalEvaluationItem(VENA_CONTRACTA_WIDTH_TRI, "txtVenaContractaWidth", "value", 0.1, 9, false));
                                        add(new BooleanEvaluationItem(HEPATIC_VEIN_FLOW_REVERSAL, "chkHepaticVeinFlowRev"));
                                        add(new BooleanEvaluationItem(ABNORMAL_TV_LEAFLETS,"chkabTVleaflet"));
                                }
                                }));
                                add(new SectionCheckboxEvaluationItem(PULMONIC_REGURGITATION, "chkPulmonicRegurgitation", new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(WIDE_REGURFITANT_JET, "chkWideRegurJet"));
                                        add(new BooleanEvaluationItem(ABNORMAL_PULMONIC_VALVE_LEAFLETS, "chkabnpulval"));
                                    }
                                }));
                            }
                        }, SectionElementState.OPENED));

                        add(new SectionEvaluationItem(tempContext, VALVULAR_SURGERY_RISK, "secvalvular_surgery_risk", new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(LOW, "chklowrisk"));
                                add(new BooleanEvaluationItem(INTERMEDIATE, "chkintermediaterisk"));
                                add(new BooleanEvaluationItem(HIGH, "chkhighrisk"));
                                add(new BooleanEvaluationItem(PROHIBITIVE, "chkprohibitive"));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(tempContext, OTHER_SURGICAL_RISK, "secother_surgical_risk", new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(HIGH_RISK_SUPRA_INGUINAL_VASCULAR_SURGERY, "chkvascular"));
                                add(new BooleanEvaluationItem(LOW_RISK_CATARACT_PLASTIC, "chklowriskelec"));
                                add(new BooleanEvaluationItem(INTERMEDIATE_RISK, "chkelective"));
                                add(new BooleanEvaluationItem(OTHER_CARDIAC, "chkcardiac"));
                            }
                        }));
                    }

                }, SectionElementState.OPENED));


                add(new SectionEvaluationItem(tempContext, RHC, "Right heart catheterization", new ArrayList<EvaluationItem>() {
                    {
                        add(new NumericalEvaluationItem(MEAN_PAP_MMHG, "txtMPAP", "", 10, 70, true));
                        add(new NumericalEvaluationItem(PVR_WU, "txtPVR", "", 1, 20, false));
                        add(new NumericalEvaluationItem(LVEDP_MMHG, "txtLVEDP", "", 8, 50, true));
                        add(new NumericalEvaluationItem(PCWP_MMGH, "txtPCWP", "", 3, 40, true));
                        add(new NumericalEvaluationItem(CL_LT_MIN_SQ, "txtCI", "", 0.9, 5, false));
                        add(new NumericalEvaluationItem(RA_PRESSURE_MMHG,"txtRAP", "", 0, 40, true));
                        add(new NumericalEvaluationItem(V_WAVE_AMPLITUDE, "txtVWA", "", 0, 40, true));
                        add(new BooleanEvaluationItem(NO_V_WAVE,"chkVWA"));
                        add(new NumericalEvaluationItem(PADP_MMHG, "txtPADP", "", 5, 40, true));
                        add(new NumericalEvaluationItem(RVEDP_MMGH, "txtRVEDP", "", 3, 20, true));
                        add(new NumericalEvaluationItem(SVR_WU, "txtSVR", "value", 1, 19, false));
                    }

                }, SectionElementState.OPENED));


            }


        };
    }
}