package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.heartcheck.R;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

import static com.szg_tech.heartcheck.core.ConfigurationParams.ABNORMAL_PULMONIC_VALVE_LEAFLETS;
import static com.szg_tech.heartcheck.core.ConfigurationParams.ABNORMAL_TV_LEAFLETS;
import static com.szg_tech.heartcheck.core.ConfigurationParams.ANNULAR_DIAMETER;
import static com.szg_tech.heartcheck.core.ConfigurationParams.AORTIC_MEAN_PRESSURE_GRADIENT;
import static com.szg_tech.heartcheck.core.ConfigurationParams.AORTIC_REGURGITATION;
import static com.szg_tech.heartcheck.core.ConfigurationParams.AORTIC_ROOT_DIAMETER;
import static com.szg_tech.heartcheck.core.ConfigurationParams.AORTIC_STENOSIS;
import static com.szg_tech.heartcheck.core.ConfigurationParams.AORTIC_VALVE_VALOCITY;
import static com.szg_tech.heartcheck.core.ConfigurationParams.ASD_LESS_2CM;
import static com.szg_tech.heartcheck.core.ConfigurationParams.BIO_PAH_MAIN;
import static com.szg_tech.heartcheck.core.ConfigurationParams.BISCUSPID_AORTIC_ROOT_DIAMETER;
import static com.szg_tech.heartcheck.core.ConfigurationParams.CALCIFIED_AORTIC_VALVE_REDUCED_SYSTOLIC_OPENING;
import static com.szg_tech.heartcheck.core.ConfigurationParams.CALCULATED_AORTIC_VALVE_AREA;
import static com.szg_tech.heartcheck.core.ConfigurationParams.CENTRAL_JET_AREA_CM_2;
import static com.szg_tech.heartcheck.core.ConfigurationParams.CL_LT_MIN_SQ;
import static com.szg_tech.heartcheck.core.ConfigurationParams.CONGENITAL;
import static com.szg_tech.heartcheck.core.ConfigurationParams.CONGENITALLY_STENOTIC_AORTIC_VALVE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.CTEP;
import static com.szg_tech.heartcheck.core.ConfigurationParams.DRUGS_TOXINS;
import static com.szg_tech.heartcheck.core.ConfigurationParams.EISENMENGER;
import static com.szg_tech.heartcheck.core.ConfigurationParams.ERO;
import static com.szg_tech.heartcheck.core.ConfigurationParams.FAMILIAL;
import static com.szg_tech.heartcheck.core.ConfigurationParams.FAVORABLE_VALVE_MORPHOLOGY;
import static com.szg_tech.heartcheck.core.ConfigurationParams.HEART_SPECIALIST_MANAGEMENT;
import static com.szg_tech.heartcheck.core.ConfigurationParams.HEPATIC_VEIN_FLOW_REVERSAL;
import static com.szg_tech.heartcheck.core.ConfigurationParams.HIGH;
import static com.szg_tech.heartcheck.core.ConfigurationParams.HIGH_RISK_SUPRA_INGUINAL_VASCULAR_SURGERY;
import static com.szg_tech.heartcheck.core.ConfigurationParams.HIV;
import static com.szg_tech.heartcheck.core.ConfigurationParams.HOLODIASTOLIC_FLOW_REVERSAL;
import static com.szg_tech.heartcheck.core.ConfigurationParams.IDIOPATHIC;
import static com.szg_tech.heartcheck.core.ConfigurationParams.INDEXED_VALVE_AREA_AVA_BSA;
import static com.szg_tech.heartcheck.core.ConfigurationParams.INTERMEDIATE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.INTERMEDIATE_RISK;
import static com.szg_tech.heartcheck.core.ConfigurationParams.LA_CLOT;
import static com.szg_tech.heartcheck.core.ConfigurationParams.LOW;
import static com.szg_tech.heartcheck.core.ConfigurationParams.LOW_RISK_CATARACT_PLASTIC;
import static com.szg_tech.heartcheck.core.ConfigurationParams.LVEDD_MM;
import static com.szg_tech.heartcheck.core.ConfigurationParams.LVEDP_MMHG;
import static com.szg_tech.heartcheck.core.ConfigurationParams.LVEF_PAH;
import static com.szg_tech.heartcheck.core.ConfigurationParams.LVESD_MM;
import static com.szg_tech.heartcheck.core.ConfigurationParams.MAX_VO_MG_KG_MIN;
import static com.szg_tech.heartcheck.core.ConfigurationParams.MEAN_PAP_MMHG;
import static com.szg_tech.heartcheck.core.ConfigurationParams.MITRAL_STENOSIS;
import static com.szg_tech.heartcheck.core.ConfigurationParams.MVA_CM_2;
import static com.szg_tech.heartcheck.core.ConfigurationParams.NEW_ONSET_ATRIAL_FIBRILATION;
import static com.szg_tech.heartcheck.core.ConfigurationParams.NO_V_WAVE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.OTHER_CARDIAC;
import static com.szg_tech.heartcheck.core.ConfigurationParams.OTHER_SURGICAL_RISK;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PADP_MMHG;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PAH;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PCWP_MMGH;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PHT_MSEC;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PORTAL_HYPERTENSION;
import static com.szg_tech.heartcheck.core.ConfigurationParams.POST_CORRECTIVE_SURGERY;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PREGNANCY;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PRIMARY_MITRAL_REGURGITATION;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PROHIBITIVE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PULMONIC_REGURGITATION;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PULMONIC_STENOSIS;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PULMONIC_VALVE_VELOCITY;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PVOD_PCH;
import static com.szg_tech.heartcheck.core.ConfigurationParams.PVR_WU;
import static com.szg_tech.heartcheck.core.ConfigurationParams.RA_PRESSURE_MMHG;
import static com.szg_tech.heartcheck.core.ConfigurationParams.REGURGITANT_FRACTION;
import static com.szg_tech.heartcheck.core.ConfigurationParams.REGURGITANT_VOLUME_ML_BEAT;
import static com.szg_tech.heartcheck.core.ConfigurationParams.RESPIRATORY_DISEASE_HYPOXIA;
import static com.szg_tech.heartcheck.core.ConfigurationParams.RHC;
import static com.szg_tech.heartcheck.core.ConfigurationParams.RHEUMATIC_AV;
import static com.szg_tech.heartcheck.core.ConfigurationParams.RHEUMATIC_MV_TV;
import static com.szg_tech.heartcheck.core.ConfigurationParams.RVEDP_MMGH;
import static com.szg_tech.heartcheck.core.ConfigurationParams.SCLERODERMA;
import static com.szg_tech.heartcheck.core.ConfigurationParams.SIX_MW_DISTANCE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.SLE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.SPLENECTOMY_SC;
import static com.szg_tech.heartcheck.core.ConfigurationParams.STROKE_VOLUME_INDEX_SV_SBA;
import static com.szg_tech.heartcheck.core.ConfigurationParams.SVR_WU;
import static com.szg_tech.heartcheck.core.ConfigurationParams.TRICUSPID_REGURGITATION;
import static com.szg_tech.heartcheck.core.ConfigurationParams.VALVULAR;
import static com.szg_tech.heartcheck.core.ConfigurationParams.VALVULAR_SURGERY_RISK;
import static com.szg_tech.heartcheck.core.ConfigurationParams.VENA_CONTRACTA_WIDTH;
import static com.szg_tech.heartcheck.core.ConfigurationParams.VENA_CONTRACTA_WIDTH_TRI;
import static com.szg_tech.heartcheck.core.ConfigurationParams.VSD_LESS_1CM;
import static com.szg_tech.heartcheck.core.ConfigurationParams.V_WAVE_AMPLITUDE;
import static com.szg_tech.heartcheck.core.ConfigurationParams.WIDE_REGURFITANT_JET;

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
                        add(new NumericalEvaluationItem(SIX_MW_DISTANCE, "txt6MWT", "value", 50, 600, true));
                        add(new NumericalEvaluationItem(MAX_VO_MG_KG_MIN, "txtVO2", "value", 6, 40, true));
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
                                        add(new NumericalEvaluationItem(AORTIC_VALVE_VALOCITY, "txtAortValveVel", "value", 1, 6, true));
                                        add(new NumericalEvaluationItem(STROKE_VOLUME_INDEX_SV_SBA, "txtStrokeVolIndex", "value", 1, 9, true));
                                        add(new NumericalEvaluationItem(INDEXED_VALVE_AREA_AVA_BSA, "txtIndexedValveArea", "value", 0.1, 9, false));
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
                                        add(new BooleanEvaluationItem(ABNORMAL_TV_LEAFLETS, "chkabTVleaflet"));
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
                        add(new NumericalEvaluationItem(RA_PRESSURE_MMHG, "txtRAP", "", 0, 40, true));
                        add(new NumericalEvaluationItem(V_WAVE_AMPLITUDE, "txtVWA", "", 0, 40, true));
                        add(new BooleanEvaluationItem(NO_V_WAVE, "chkVWA"));
                        add(new NumericalEvaluationItem(PADP_MMHG, "txtPADP", "", 5, 40, true));
                        add(new NumericalEvaluationItem(RVEDP_MMGH, "txtRVEDP", "", 3, 20, true));
                        add(new NumericalEvaluationItem(SVR_WU, "txtSVR", "value", 1, 19, false));
                    }

                }, SectionElementState.OPENED));


            }


        };
    }
}