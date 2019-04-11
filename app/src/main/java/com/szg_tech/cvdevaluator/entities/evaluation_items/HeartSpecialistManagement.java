package com.szg_tech.cvdevaluator.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.cvdevaluator.R;
import com.szg_tech.cvdevaluator.entities.EvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.SectionEvaluationItem;
import com.szg_tech.cvdevaluator.entities.evaluation_item_elements.TabEvaluationItem;

import java.util.ArrayList;

import static com.szg_tech.cvdevaluator.core.ConfigurationParams.ABNORMAL_PULMONIC_VALVE_LEAFLETS;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.ABNORMAL_TV_LEAFLETS;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.ANNULAR_DIAMETER;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.AORTIC_MEAN_PRESSURE_GRADIENT;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.AORTIC_REGURGITATION;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.AORTIC_ROOT_DIAMETER;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.AORTIC_STENOSIS;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.AORTIC_VALVE_VALOCITY;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.ASD_LESS_2CM;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.BIO_PAH_MAIN;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.BISCUSPID_AORTIC_ROOT_DIAMETER;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.CALCIFIED_AORTIC_VALVE_REDUCED_SYSTOLIC_OPENING;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.CALCULATED_AORTIC_VALVE_AREA;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.CENTRAL_JET_AREA_CM_2;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.CL_LT_MIN_SQ;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.CONGENITAL;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.CONGENITALLY_STENOTIC_AORTIC_VALVE;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.CTEP;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.DRUGS_TOXINS;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.EISENMENGER;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.ERO;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.FAMILIAL;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.FAVORABLE_VALVE_MORPHOLOGY;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.HEART_SPECIALIST_MANAGEMENT;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.HEPATIC_VEIN_FLOW_REVERSAL;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.HIGH;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.HIGH_RISK_SUPRA_INGUINAL_VASCULAR_SURGERY;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.HIV;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.HOLODIASTOLIC_FLOW_REVERSAL;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.IDIOPATHIC;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.INDEXED_VALVE_AREA_AVA_BSA;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.INTERMEDIATE;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.INTERMEDIATE_RISK;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.LA_CLOT;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.LOW;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.LOW_RISK_CATARACT_PLASTIC;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.LVEDD_MM;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.LVEDP_MMHG;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.LVEF_PAH;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.LVESD_MM;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.MAX_VO_MG_KG_MIN;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.MEAN_PAP_MMHG;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.MITRAL_STENOSIS;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.MVA_CM_2;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.NEW_ONSET_ATRIAL_FIBRILATION;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.NO_V_WAVE;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.OTHER_CARDIAC;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.OTHER_SURGICAL_RISK;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PADP_MMHG;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PAH;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PCWP_MMGH;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PHT_MSEC;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PORTAL_HYPERTENSION;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.POST_CORRECTIVE_SURGERY;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PREGNANCY;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PRIMARY_MITRAL_REGURGITATION;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PROHIBITIVE;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PULMONIC_REGURGITATION;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PULMONIC_STENOSIS;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PULMONIC_VALVE_VELOCITY;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PVOD_PCH;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.PVR_WU;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.RA_PRESSURE_MMHG;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.REGURGITANT_FRACTION;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.REGURGITANT_VOLUME_ML_BEAT;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.RESPIRATORY_DISEASE_HYPOXIA;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.RHC;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.RHEUMATIC_AV;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.RHEUMATIC_MV_TV;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.RVEDP_MMGH;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.SCLERODERMA;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.SIX_MW_DISTANCE;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.SLE;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.SPLENECTOMY_SC;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.STROKE_VOLUME_INDEX_SV_SBA;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.SVR_WU;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.TRICUSPID_REGURGITATION;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.VALVULAR;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.VALVULAR_SURGERY_RISK;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.VENA_CONTRACTA_WIDTH;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.VENA_CONTRACTA_WIDTH_TRI;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.VSD_LESS_1CM;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.V_WAVE_AMPLITUDE;
import static com.szg_tech.cvdevaluator.core.ConfigurationParams.WIDE_REGURFITANT_JET;

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
                add(new SectionEvaluationItem(tempContext, BIO_PAH_MAIN, " 6MWT, CPET ", new ArrayList<EvaluationItem>() {
                    {

                        add(new NumericalEvaluationItem(SIX_MW_DISTANCE, getString(R.string.six_mw_distance), getString(R.string.value), 50, 600, true));
                        add(new NumericalEvaluationItem(MAX_VO_MG_KG_MIN, getString(R.string.max_vo_mg_kg_min), getString(R.string.value), 6, 40, true));

                    }
                }, SectionElementState.OPENED));
                add(new SectionEvaluationItem(tempContext, PAH, "PAH clinics", new ArrayList<EvaluationItem>() {
                    {
                        add(new TabEvaluationItem("heart_rate_tab", "tab", new ArrayList<SectionEvaluationItem>() {
                            {
                                add(new SectionEvaluationItem(tempContext, "tab_pg1", getString(R.string.pah), new ArrayList<EvaluationItem>() {
                                    {

                                        add(new BooleanEvaluationItem(IDIOPATHIC, getString(R.string.idiopathic)));
                                        add(new SectionCheckboxEvaluationItem(CONGENITAL, getString(R.string.congenital), new ArrayList<EvaluationItem>() {
                                            {
                                                add(new BooleanEvaluationItem(ASD_LESS_2CM, getString(R.string.asd_less_2cm)));
                                                add(new BooleanEvaluationItem(VSD_LESS_1CM, getString(R.string.vsd_less_1cm)));
                                                add(new BooleanEvaluationItem(POST_CORRECTIVE_SURGERY, getString(R.string.post_corrective_surgery)));
                                                add(new BooleanEvaluationItem(EISENMENGER, getString(R.string.eisenmenger)));
                                            }
                                        }));
                                        add(new BooleanEvaluationItem(SCLERODERMA, getString(R.string.scleroderma)));
                                        add(new BooleanEvaluationItem(SLE, getString(R.string.sle)));
                                        add(new BooleanEvaluationItem(HIV, getString(R.string.hiv)));
                                        add(new BooleanEvaluationItem(PORTAL_HYPERTENSION, "Portal Hypertension"));
                                        add(new BooleanEvaluationItem(RESPIRATORY_DISEASE_HYPOXIA, "Respiratory Disease "));


                                        add(new BooleanEvaluationItem(PVOD_PCH, getString(R.string.pvod_pch)));
                                        add(new BooleanEvaluationItem(SPLENECTOMY_SC, getString(R.string.splenectomy_sc)));
                                        add(new BooleanEvaluationItem(FAMILIAL, getString(R.string.familial)));
                                        add(new BooleanEvaluationItem(CTEP, getString(R.string.ctep)));
                                        add(new BooleanEvaluationItem(DRUGS_TOXINS, getString(R.string.drugs_toxins)));
                                    }
                                }));


                            }
                        }));
                    }

                }, SectionElementState.OPENED));

                add(new SectionEvaluationItem(tempContext, VALVULAR, getString(R.string.valvular), new ArrayList<EvaluationItem>() {
                    {
                        add(new SectionEvaluationItem(tempContext, VALVULAR, getString(R.string.valvular), new ArrayList<EvaluationItem>() {
                            {
                                add(new NumericalEvaluationItem(LVEF_PAH, getString(R.string.lvef), getString(R.string.value), 10, 80, true));
                                add(new BooleanEvaluationItem(NEW_ONSET_ATRIAL_FIBRILATION, getString(R.string.new_onset_atrial_fibrilation)));
                                add(new BooleanEvaluationItem(PREGNANCY, getString(R.string.pregnancy)));
                                add(new SectionCheckboxEvaluationItem(AORTIC_STENOSIS, getString(R.string.aortic_stenosis), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(CALCIFIED_AORTIC_VALVE_REDUCED_SYSTOLIC_OPENING, "Calcified AV"));
                                        add(new BooleanEvaluationItem(CONGENITALLY_STENOTIC_AORTIC_VALVE, getString(R.string.congenitally_stenotic_aortic_valve)));
                                        add(new BooleanEvaluationItem(RHEUMATIC_AV, getString(R.string.rheumatic_av)));
                                        add(new NumericalEvaluationItem(CALCULATED_AORTIC_VALVE_AREA, getString(R.string.calculated_aortic_valve_area), getString(R.string.value), 0.1, 4, false));
                                        add(new NumericalEvaluationItem(AORTIC_MEAN_PRESSURE_GRADIENT, getString(R.string.aortic_mean_pressure_gradient), getString(R.string.value), 4, 60, true));
                                        add(new NumericalEvaluationItem(AORTIC_VALVE_VALOCITY, getString(R.string.aortic_valve_valocity), getString(R.string.value), 1, 6, true));
                                        add(new NumericalEvaluationItem(STROKE_VOLUME_INDEX_SV_SBA, getString(R.string.stroke_volume_index_sv_sba), getString(R.string.value), 1, 9, true));
                                        add(new NumericalEvaluationItem(INDEXED_VALVE_AREA_AVA_BSA, getString(R.string.indexed_valve_area_ava_bsa), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(BISCUSPID_AORTIC_ROOT_DIAMETER, getString(R.string.biscuspid_aortic_root_diameter), getString(R.string.value), 0.1, 7, false));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(MITRAL_STENOSIS, getString(R.string.mitral_stenosis), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(MVA_CM_2, getString(R.string.mva_cm_2), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(PHT_MSEC, getString(R.string.pht_msec), getString(R.string.value), 50, 400, true));
                                        add(new BooleanEvaluationItem(RHEUMATIC_MV_TV, getString(R.string.rheumatic_mv_tv)));
                                        add(new BooleanEvaluationItem(FAVORABLE_VALVE_MORPHOLOGY, getString(R.string.favorable_valve_morphology)));
                                        add(new BooleanEvaluationItem(LA_CLOT, getString(R.string.la_clot)));
                                    }
                                }));

                                add(new SectionCheckboxEvaluationItem(PULMONIC_STENOSIS, getString(R.string.pulmonic_stenosis), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(PULMONIC_VALVE_VELOCITY, getString(R.string.pulmonic_valve_velocity), getString(R.string.value), 0.5, 5, false));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(AORTIC_REGURGITATION, getString(R.string.aortic_regurgitation), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(HOLODIASTOLIC_FLOW_REVERSAL, getString(R.string.holodiastolic_flow_reversal)));
                                        add(new NumericalEvaluationItem(VENA_CONTRACTA_WIDTH, getString(R.string.vena_contracta_width), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(REGURGITANT_VOLUME_ML_BEAT, getString(R.string.regurgitant_volume_ml_beat), getString(R.string.value), 0, 99, true));
                                        add(new NumericalEvaluationItem(REGURGITANT_FRACTION, getString(R.string.regurgitant_fraction), getString(R.string.value), 0, 61, true));
                                        add(new NumericalEvaluationItem(ERO, getString(R.string.ero), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(LVEDD_MM, getString(R.string.lvedd_mm), getString(R.string.value), 10, 90, true));
                                        add(new NumericalEvaluationItem(LVESD_MM, getString(R.string.lvesd_mm), getString(R.string.value), 10, 60, true));
                                        add(new NumericalEvaluationItem(AORTIC_ROOT_DIAMETER, getString(R.string.aortic_root_diameter), getString(R.string.value), 2, 9, true));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(PRIMARY_MITRAL_REGURGITATION, getString(R.string.primary_mitral_regurgitation), new ArrayList<EvaluationItem>() {
                                    {

                                        add(new NumericalEvaluationItem(VENA_CONTRACTA_WIDTH, getString(R.string.vena_contracta_width), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(REGURGITANT_VOLUME_ML_BEAT, getString(R.string.regurgitant_volume_ml_beat), getString(R.string.value), 0, 99, true));
                                        add(new NumericalEvaluationItem(REGURGITANT_FRACTION, getString(R.string.regurgitant_fraction), getString(R.string.value), 0, 61, true));
                                        add(new NumericalEvaluationItem(ERO, getString(R.string.ero), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(LVEDD_MM, getString(R.string.lvedd_mm), getString(R.string.value), 10, 90, true));
                                        add(new NumericalEvaluationItem(LVESD_MM, getString(R.string.lvesd_mm), getString(R.string.value), 10, 60, true));

                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(TRICUSPID_REGURGITATION, getString(R.string.tricuspid_regurgitation), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new NumericalEvaluationItem(ANNULAR_DIAMETER, getString(R.string.annular_diameter), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(CENTRAL_JET_AREA_CM_2, getString(R.string.central_jet_area_cm_2), getString(R.string.value), 0.1, 9, false));
                                        add(new NumericalEvaluationItem(VENA_CONTRACTA_WIDTH_TRI, getString(R.string.vena_contracta_width), getString(R.string.value), 0.1, 9, false));
                                        add(new BooleanEvaluationItem(HEPATIC_VEIN_FLOW_REVERSAL, getString(R.string.hepatic_vein_flow_reversal)));
                                        add(new BooleanEvaluationItem(ABNORMAL_TV_LEAFLETS, getString(R.string.abnormal_tv_leaflets)));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(PULMONIC_REGURGITATION, getString(R.string.pulmonic_regurgitation), new ArrayList<EvaluationItem>() {
                                    {
                                        add(new BooleanEvaluationItem(WIDE_REGURFITANT_JET, getString(R.string.wide_regurfitant_jet)));
                                        add(new BooleanEvaluationItem(ABNORMAL_PULMONIC_VALVE_LEAFLETS, getString(R.string.abnormal_pulmonic_valve_leaflets)));
                                    }
                                }));
                            }
                        }, SectionElementState.OPENED));

                        add(new SectionEvaluationItem(tempContext, VALVULAR_SURGERY_RISK, getString(R.string.valvular_surgery_risk), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(LOW, getString(R.string.low)));
                                add(new BooleanEvaluationItem(INTERMEDIATE, getString(R.string.intermediate)));
                                add(new BooleanEvaluationItem(HIGH, getString(R.string.high)));
                                add(new BooleanEvaluationItem(PROHIBITIVE, getString(R.string.prohibitive)));
                            }
                        }, SectionElementState.OPENED));
                        add(new SectionEvaluationItem(tempContext, OTHER_SURGICAL_RISK, getString(R.string.other_surgical_risk), new ArrayList<EvaluationItem>() {
                            {
                                add(new BooleanEvaluationItem(HIGH_RISK_SUPRA_INGUINAL_VASCULAR_SURGERY, getString(R.string.high_risk_supra_inguinal_vascular_surgery)));
                                add(new BooleanEvaluationItem(LOW_RISK_CATARACT_PLASTIC, getString(R.string.low_risk_cataract_plastic)));
                                add(new BooleanEvaluationItem(INTERMEDIATE_RISK, getString(R.string.intermediate_risk)));
                                add(new BooleanEvaluationItem(OTHER_CARDIAC, getString(R.string.other_cardiac)));
                            }
                        }));
                    }

                }, SectionElementState.OPENED));
                {
                    add(new SectionEvaluationItem(tempContext, RHC, getString(R.string.rhc), new ArrayList<EvaluationItem>() {
                        {
                            add(new NumericalEvaluationItem(MEAN_PAP_MMHG, getString(R.string.mean_pap_mmhg), getString(R.string.value), 10, 70, true));
                            add(new NumericalEvaluationItem(PVR_WU, getString(R.string.pvr_wu), getString(R.string.value), 1, 20, false));
                            add(new NumericalEvaluationItem(LVEDP_MMHG, getString(R.string.lvedp_mmhg), getString(R.string.value), 8, 50, true));
                            add(new NumericalEvaluationItem(PCWP_MMGH, getString(R.string.pcwp_mmgh), getString(R.string.value), 3, 40, true));
                            add(new NumericalEvaluationItem(CL_LT_MIN_SQ, getString(R.string.cl_lt_min_sq), getString(R.string.value), 0.9, 5, false));
                            add(new NumericalEvaluationItem(RA_PRESSURE_MMHG, getString(R.string.ra_pressure_mmhg), getString(R.string.value), 0, 40, true));
                            add(new NumericalEvaluationItem(V_WAVE_AMPLITUDE, getString(R.string.v_wave_amplitude), getString(R.string.value), 0, 40, true));
                            add(new BooleanEvaluationItem(NO_V_WAVE, getString(R.string.no_v_wave)));
                            add(new NumericalEvaluationItem(PADP_MMHG, getString(R.string.padp_mmhg), getString(R.string.value), 5, 40, true));
                            add(new NumericalEvaluationItem(RVEDP_MMGH, getString(R.string.rvedp_mmgh), getString(R.string.value), 3, 20, true));
                            add(new NumericalEvaluationItem(SVR_WU, getString(R.string.svr_wu), "SVR, WU", 1, 19, false));
                        }

                    }));


                }
            }
        };
    }
}
