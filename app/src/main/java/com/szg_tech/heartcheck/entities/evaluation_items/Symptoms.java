package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.heartcheck.R;

import static com.szg_tech.heartcheck.core.ConfigurationParams.*;

import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BoldEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.EmptyCellEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.NumericalEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.RadioButtonGroupEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class Symptoms extends SectionEvaluationItem {
    Symptoms(Context context) {
        super(context, SYMPTOMS, null);
        tempContext = context;
        name = getString(R.string.symptoms);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.LOCKED;
        this.dependsOn = BIO;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        ArrayList<EvaluationItem> items = new ArrayList<>();

        items.add(new SectionCheckboxEvaluationItem(DYSPNEA, getString(R.string.dyspnea), new ArrayList<EvaluationItem>() {{
            add(new BoldEvaluationItem(PLEASE_SELECT_ONE, getString(R.string.please_select_one))  {{
                setBackgroundHighlighted(true);
            }
            });
            add(new EmptyCellEvaluationItem());
            add(new RadioButtonGroupEvaluationItem(NEW_HF, "Unknown, suspected HF", PLEASE_SELECT_ONE, false) {{
                setBackgroundHighlighted(true);
            }
            });
            add(new RadioButtonGroupEvaluationItem(CHRONIC_HF, getString(R.string.chronic_hf), PLEASE_SELECT_ONE, false) {{
                setBackgroundHighlighted(true);
            }
            });
            add(new RadioButtonGroupEvaluationItem(LUNG, "Chronic lung disease", PLEASE_SELECT_ONE, false) {{
                setBackgroundHighlighted(true);
            }
            });

            String dyspneaGroupNameSecond = "dyspnea2";
            add(new EmptyCellEvaluationItem());
            add(new RadioButtonGroupEvaluationItem(OUTPATIENT, " Slowly progressive  ", dyspneaGroupNameSecond, false) {{
                setBackgroundHighlighted(true);
            }
            });
            add(new RadioButtonGroupEvaluationItem(EMERGENCY_ROOM, "Rapidly progressive  ", dyspneaGroupNameSecond, false) {{
                setBackgroundHighlighted(true);
            }
            });
            add(new RadioButtonGroupEvaluationItem(IN_HOSPITAL, "Decompensated / Hospitalized", dyspneaGroupNameSecond, false,
                    new ArrayList<EvaluationItem>() {{
                        add(new RadioButtonGroupEvaluationItem(DAY1, " Day 1", IN_HOSPITAL, false) {
                            {
                                setBackgroundHighlighted(true);
                            }
                        });

                    }}
            ) {
                {
                    setBackgroundHighlighted(true);
                }
            });
            add(new EmptyCellEvaluationItem());
            add(new SectionCheckboxEvaluationItem(DYSPNEA_ON_EXERTION, "Dyspnea on exertion", new ArrayList<EvaluationItem>() {{
                add(new BooleanEvaluationItem(STRENUOUS_EXERTION, getString(R.string.strenuous_exertion)));
                add(new BooleanEvaluationItem(MORE_THAN_DAILY_ROUTINE, getString(R.string.more_than_daily_routine)));
                add(new BooleanEvaluationItem(DAILY_ROUTINE_MINIMAL_ACTIVITIES, getString(R.string.daily_routine_minimal_activities)));



            }
            }));

            add(new BooleanEvaluationItem(DYSPNEA_AT_REST, "Dyspnea at rest"));
            add(new BooleanEvaluationItem(WEIGHT_GAIN, "Weight gain"));
        }
        }));
            items.add(new SectionCheckboxEvaluationItem(CHEST_PAIN, getString(R.string.chest_pain), new ArrayList<EvaluationItem>() {{
                        add(new SectionCheckboxEvaluationItem(EMERGENCY_ROOM_CP, "Escalating / ER visit ", new ArrayList<EvaluationItem>() {{
                                add(new BooleanEvaluationItem(TWO_TYPICAL_OR_PROBABLE_ANGINA, "Highly suspicious"));
                                add(new BooleanEvaluationItem(TYPICAL_OR_PROBABLE_ANGINA_MORE_20_MIN, "Moderately suspicious"));
                                add(new BooleanEvaluationItem(ASA_USE_IN_PAST_1_WEEK, "Slightly suspicious"));

                            }
                        }));
                add(new SectionCheckboxEvaluationItem(POSITIVE_TROPONIN, "Positive troponin", new ArrayList<EvaluationItem>() {{
                    add(new BooleanEvaluationItem(TROPONIN_X_MORE_3_ABOVE_NORMAL, "Troponin 3 times above normal"));
                    add(new BooleanEvaluationItem(TROPONIN_1_3_ABOVE_NORMAL, "Troponin 1 to 3 times above normal"));
                }
                }));
                        add(new SectionCheckboxEvaluationItem(TYPICAL_ANGINA_NEW, "Typical angina", new ArrayList<EvaluationItem>() {{
                                add(new BooleanEvaluationItem(ESCALATING_IN_FREQUENCY, "Escalating in frequency, duration oer severity"));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(PROBABLY_ANGINA_NEW, "Probable angina", new ArrayList<EvaluationItem>() {{
                                add(new BooleanEvaluationItem(ESCALATING_IN_FREQUENCY, "Escalating in frequency, duration oer severity"));
                            }
                        }));
                        add(new SectionCheckboxEvaluationItem(UNDETERMINED_CP_NEW, "Undetermined chest pain", new ArrayList<EvaluationItem>() {{
                                add(new SectionCheckboxEvaluationItem(SIDE_HEMITHORAX, getString(R.string.side_hemithorax), new ArrayList<EvaluationItem>() {{
                                        add(new BoldEvaluationItem(QUALITY, getString(R.string.quality)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(SHARP, getString(R.string.sharp)));
                                        add(new BooleanEvaluationItem(PRESSURE, getString(R.string.pressure)));
                                        add(new BooleanEvaluationItem(TIGHTNESS, getString(R.string.tightness)));
                                        add(new BooleanEvaluationItem(SORENESS, getString(R.string.soreness)));
                                        add(new BooleanEvaluationItem(HEAVINESS, getString(R.string.heaviness)));
                                        add(new BoldEvaluationItem(AGGRAVATED_BY, getString(R.string.aggravated_by)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(LYING, getString(R.string.lying)));
                                        add(new BooleanEvaluationItem(BREATHING, getString(R.string.breathing)));
                                        add(new BooleanEvaluationItem(COUGHING, getString(R.string.coughing)));
                                        add(new BooleanEvaluationItem(EXERTION, getString(R.string.exertion)));
                                        add(new BooleanEvaluationItem(PALPATION, getString(R.string.palpation)));
                                        add(new BoldEvaluationItem(RELIEVED_BY, getString(R.string.relieved_by)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(NTG, getString(R.string.ntg)));
                                        add(new BooleanEvaluationItem(REST, getString(R.string.rest)));
                                        add(new BooleanEvaluationItem(SITTING_UP, getString(R.string.sitting_up)));
                                        add(new BooleanEvaluationItem(LYING_ON_SIDE, getString(R.string.lying_on_side)));
                                        add(new BooleanEvaluationItem(ANALGESICS, getString(R.string.analgesics)));
                                        add(new BoldEvaluationItem(RADIATION, getString(R.string.radiation)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(JAW, getString(R.string.jaw)));
                                        add(new BooleanEvaluationItem(BACK, getString(R.string.back)));
                                        add(new BooleanEvaluationItem(ARM, getString(R.string.arm)));
                                        add(new BoldEvaluationItem(ASSOCIATED_WITH, "Associated with") {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(DYSPNEA_CP, getString(R.string.dyspnea)));
                                        add(new BooleanEvaluationItem(NAUSEA, getString(R.string.nausea)));
                                        add(new BooleanEvaluationItem(DIAPHORESIS, getString(R.string.diaphoresis)));
                                        add(new BooleanEvaluationItem(FAINTNESS, getString(R.string.faintness)));
                                        add(new BooleanEvaluationItem(CPPALPITATIONS, "CPPalpitations"));
                                        add(new BoldEvaluationItem(LASTING, "Lasting") {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(CPSECONDS, "Seconds"));
                                        add(new BooleanEvaluationItem(CPMINUTES, "Minutes"));
                                        add(new BooleanEvaluationItem(CPHOURS, "Hours"));
                                        add(new BooleanEvaluationItem(CPCONSTANT, "Constant"));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(INTERCOSTAL_CP, getString(R.string.intercostal_cp), new ArrayList<EvaluationItem>() {{
                                        add(new BoldEvaluationItem(QUALITY, getString(R.string.quality)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(SHARP, getString(R.string.sharp)));
                                        add(new BooleanEvaluationItem(PRESSURE, getString(R.string.pressure)));
                                        add(new BooleanEvaluationItem(TIGHTNESS, getString(R.string.tightness)));
                                        add(new BooleanEvaluationItem(SORENESS, getString(R.string.soreness)));
                                        add(new BooleanEvaluationItem(HEAVINESS, getString(R.string.heaviness)));
                                        add(new BoldEvaluationItem(AGGRAVATED_BY, getString(R.string.aggravated_by)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(LYING, getString(R.string.lying)));
                                        add(new BooleanEvaluationItem(BREATHING, getString(R.string.breathing)));
                                        add(new BooleanEvaluationItem(COUGHING, getString(R.string.coughing)));
                                        add(new BooleanEvaluationItem(EXERTION, getString(R.string.exertion)));
                                        add(new BooleanEvaluationItem(PALPATION, getString(R.string.palpation)));
                                        add(new BoldEvaluationItem(RELIEVED_BY, getString(R.string.relieved_by)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(NTG, getString(R.string.ntg)));
                                        add(new BooleanEvaluationItem(REST, getString(R.string.rest)));
                                        add(new BooleanEvaluationItem(SITTING_UP, getString(R.string.sitting_up)));
                                        add(new BooleanEvaluationItem(LYING_ON_SIDE, getString(R.string.lying_on_side)));
                                        add(new BooleanEvaluationItem(ANALGESICS, getString(R.string.analgesics)));
                                        add(new BoldEvaluationItem(RADIATION, getString(R.string.radiation)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(JAW, getString(R.string.jaw)));
                                        add(new BooleanEvaluationItem(BACK, getString(R.string.back)));
                                        add(new BooleanEvaluationItem(ARM, getString(R.string.arm)));
                                        add(new BoldEvaluationItem(ASSOCIATED_WITH, getString(R.string.associated_with)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(DYSPNEA_CP, getString(R.string.dyspnea)));
                                        add(new BooleanEvaluationItem(NAUSEA, getString(R.string.nausea)));
                                        add(new BooleanEvaluationItem(DIAPHORESIS, getString(R.string.diaphoresis)));
                                        add(new BooleanEvaluationItem(FAINTNESS, getString(R.string.faintness)));
                                        add(new BooleanEvaluationItem(CPPALPITATIONS, "CPPalpitations"));
                                        add(new BoldEvaluationItem(LASTING, "Lasting") {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(CPSECONDS, "Seconds"));
                                        add(new BooleanEvaluationItem(CPMINUTES, "Minutes"));
                                        add(new BooleanEvaluationItem(CPHOURS, "Hours"));
                                        add(new BooleanEvaluationItem(CPCONSTANT, "Constant"));
                                    }
                                }));
                                add(new SectionCheckboxEvaluationItem(CENTRAL_PRECORDIAL_CP, getString(R.string.central_precordial_cp), new ArrayList<EvaluationItem>() {{
                                        add(new BoldEvaluationItem(QUALITY, getString(R.string.quality)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(SHARP, getString(R.string.sharp)));
                                        add(new BooleanEvaluationItem(PRESSURE, getString(R.string.pressure)));
                                        add(new BooleanEvaluationItem(TIGHTNESS, getString(R.string.tightness)));
                                        add(new BooleanEvaluationItem(SORENESS, getString(R.string.soreness)));
                                        add(new BooleanEvaluationItem(HEAVINESS, getString(R.string.heaviness)));
                                        add(new BoldEvaluationItem(AGGRAVATED_BY, getString(R.string.aggravated_by)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(LYING, getString(R.string.lying)));
                                        add(new BooleanEvaluationItem(BREATHING, getString(R.string.breathing)));
                                        add(new BooleanEvaluationItem(COUGHING, getString(R.string.coughing)));
                                        add(new BooleanEvaluationItem(EXERTION, getString(R.string.exertion)));
                                        add(new BooleanEvaluationItem(PALPATION, getString(R.string.palpation)));
                                        add(new BoldEvaluationItem(RELIEVED_BY, getString(R.string.relieved_by)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(NTG, getString(R.string.ntg)));
                                        add(new BooleanEvaluationItem(REST, getString(R.string.rest)));
                                        add(new BooleanEvaluationItem(SITTING_UP, getString(R.string.sitting_up)));
                                        add(new BooleanEvaluationItem(LYING_ON_SIDE, getString(R.string.lying_on_side)));
                                        add(new BooleanEvaluationItem(ANALGESICS, getString(R.string.analgesics)));

                                        add(new BoldEvaluationItem(RADIATION, getString(R.string.radiation)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(JAW, getString(R.string.jaw)));
                                        add(new BooleanEvaluationItem(BACK, getString(R.string.back)));
                                        add(new BooleanEvaluationItem(ARM, getString(R.string.arm)));
                                        add(new BoldEvaluationItem(ASSOCIATED_WITH, getString(R.string.associated_with)) {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(DYSPNEA_CP, getString(R.string.dyspnea)));
                                        add(new BooleanEvaluationItem(NAUSEA, getString(R.string.nausea)));
                                        add(new BooleanEvaluationItem(DIAPHORESIS, getString(R.string.diaphoresis)));
                                        add(new BooleanEvaluationItem(FAINTNESS, getString(R.string.faintness)));
                                        add(new BooleanEvaluationItem(CPPALPITATIONS, "CPPalpitations"));
                                        add(new BoldEvaluationItem(LASTING, "Lasting") {{
                                                setBackgroundHighlighted(true);
                                            }
                                        });
                                        add(new BooleanEvaluationItem(CPSECONDS, "Seconds"));
                                        add(new BooleanEvaluationItem(CPMINUTES, "Minutes"));
                                        add(new BooleanEvaluationItem(CPHOURS, "Hours"));
                                        add(new BooleanEvaluationItem(CPCONSTANT, "Constant"));
                                    }
                                }));
                            }
                        }));
                        add(new BooleanEvaluationItem(UNABLE_TO_EXERCISE, getString(R.string.unable_to_exercise)));
                    }
                }));
            items.add(new SectionCheckboxEvaluationItem(SYNCOPE_PRESYNCOPE, " Presyncope / Syncope / Seizure", new ArrayList<EvaluationItem>() {{
                        add(new BoldEvaluationItem(CIRCUMSTANCE, getString(R.string.circumstance)) {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(UPRIGHT_POSITION, getString(R.string.upright_position)));
                        add(new BooleanEvaluationItem(SUDDEN_NOISE, getString(R.string.sudden_noise)));
                        add(new BooleanEvaluationItem(NECK_MOVEMENT_MANIPULATION, getString(R.string.neck_movement_manipulation)));
                        add(new BooleanEvaluationItem(EXERTIONAL, getString(R.string.exertional)));
                        add(new BooleanEvaluationItem(SPORADIC, "Sporadic"));
                        add(new BoldEvaluationItem(PRODROMAL_SYMPTOMS, getString(R.string.prodromal_symptoms)) {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(NAUSEA_SYN, getString(R.string.nausea)));
                        add(new BooleanEvaluationItem(DIZZINESS, getString(R.string.dizziness)));
                        add(new BooleanEvaluationItem(SYNPALPITATIONS, getString(R.string.palpitations)));
                        add(new BooleanEvaluationItem(SYNCHEST_PAIN, getString(R.string.chest_pain)));
                        add(new BooleanEvaluationItem(AURA, getString(R.string.aura)));
                        add(new BoldEvaluationItem(SYNCOPE_DURATION_DURING_SYNCOPE, getString(R.string.syncope_duration_during_syncope)) {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new NumericalEvaluationItem(MINUTES_SYN_DUR, "Minutes", "Value", 0, 10, true));
                        add(new NumericalEvaluationItem(SECONDS_SYN_DUR, "Seconds", "Value", 0, 300, true));
                        add(new BooleanEvaluationItem(CYANOSIS, getString(R.string.cyanosis)));
                        add(new BooleanEvaluationItem(PALLOR_DIAPHORESIS, getString(R.string.pallor_diaphoresis)));
                        add(new BooleanEvaluationItem(UNUSUAL_POSTURE, getString(R.string.unusual_posture)));
                        add(new BoldEvaluationItem(POSTICTAL_SYMPTOMS, getString(R.string.postictal_symptoms)) {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(DISORIENTATION, getString(R.string.disorientation)));
                        add(new BooleanEvaluationItem(PARALYSIS, getString(R.string.paralysis)));
                        add(new BooleanEvaluationItem(CHEST_PAIN_POS_CP, getString(R.string.chest_pain)));
                        add(new BooleanEvaluationItem(PROLONGED_FATIGUE, getString(R.string.prolonged_fatigue)));
                        add(new BooleanEvaluationItem(TRAUMATIC_INJURY, getString(R.string.traumatic_injury)));
                    }
                }));
            items.add(new SectionCheckboxEvaluationItem(WEAKNESS, "Weakness", new ArrayList<EvaluationItem>() {{
                        add(new BooleanEvaluationItem(MALAISE, "Malaise / Fatigue"));
                    }
                }));
            items.add(new SectionCheckboxEvaluationItem(SYMPALPITATIONS, "Palpitations", new ArrayList<EvaluationItem>() {{
                        add(new BoldEvaluationItem(PAL_FREQUENCY, "Frequency") {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(PALDAY, "Daily"));
                        add(new BooleanEvaluationItem(PALWEEK, "Weekly"));
                        add(new BooleanEvaluationItem(PALMONTH, "Monthly"));
                        add(new BooleanEvaluationItem(PALYEAR, "Yearly"));
                        add(new BoldEvaluationItem(PAL_TYPE, "Type") {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(EXTRASYSTOLIC, "Extrasystolic"));
                        add(new SectionCheckboxEvaluationItem(TACHYCARDIC, "Tachycardic", new ArrayList<EvaluationItem>() {{
                                add(new BoldEvaluationItem(VAGAL, "Reaction to vagal manuever") {{
                                        setBackgroundHighlighted(true);
                                    }
                                });
                                add(new BooleanEvaluationItem(VAGAL_ABRUPT, "Abrupt termination"));
                                add(new BooleanEvaluationItem(VAGAL_GRADUAL, "Gradual termination"));
                                add(new BooleanEvaluationItem(VAGAL_NORESPONSE, "No response"));
                            }}
                            ));
                        add(new BooleanEvaluationItem(ANXIETY, "Anxiety"));
                        add(new BooleanEvaluationItem(PULSATION, "Strong pulsation "));
                        add(new BoldEvaluationItem(SYMPTOM_DURATION, "Symptom duration") {{
                                setBackgroundHighlighted(true);
                            }
                        });

                        add(new NumericalEvaluationItem(SECONDS_PAL_DUR, "Seconds", "Value", 0, 60, true));
                        add(new NumericalEvaluationItem(MINUTES_PAL_DUR, "Minutes", "Value", 0, 60, true));
                        add(new NumericalEvaluationItem(HOURS_PAL_DUR, "Hours", "Value", 0, 300, true));
                        add(new BoldEvaluationItem(PAL_SYMPTOMS, "Associated symptoms") {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(PAL_SYNCOPE, "Syncope"));
                        add(new BooleanEvaluationItem(PAL_ANGINA, "Angina"));
                        add(new BooleanEvaluationItem(PAL_POLYURIA, "Polyuria"));
                        add(new BooleanEvaluationItem(PAL_NECK, "Pulsations in neck"));

                        add(new BoldEvaluationItem(PAL_EKG, "EKG during symptoms") {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(PAL_NSR, "Normal sinus rhtym"));
                        add(new BooleanEvaluationItem(PAL_REGRR, "Regular RR, other than sinus "));
                        add(new BooleanEvaluationItem(PAL_IRREGRR, "Irregular RR, other than sinus"));


                        add(new BoldEvaluationItem(PAL_ONSET, "Onset, trigger") {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(PAL_SUDDEN, "Sudden onset"));
                        add(new BooleanEvaluationItem(PAL_POSITION, "Position change "));
                        add(new BooleanEvaluationItem(PAL_EXERTION, "Exertional"));
                        add(new BooleanEvaluationItem(PAL_POSTEXERTION, "Post exertion"));
                    }
                }));
            items.add(new SectionCheckboxEvaluationItem(ABDOMINAL, "Abdominal pain", new ArrayList<EvaluationItem>() {{
                        add(new BoldEvaluationItem(PAIN_QUALITY, "Quality") {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(ABSHARP, "Sharp"));
                        add(new BooleanEvaluationItem(ABCOLIC, "Colicky"));
                        add(new BooleanEvaluationItem(ABACHING, "Aching or muscle spasm"));
                        add(new BoldEvaluationItem(PAIN_LOCATION, "Location ") {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(PERIUMBILICAL, "Periumbilical"));
                        add(new BooleanEvaluationItem(EPIGASTRIC, "Epigastric"));
                        add(new BooleanEvaluationItem(SUPRAPUBIC, "Suprapubic"));
                        add(new BooleanEvaluationItem(ABSPASM, " Referred "));
                        add(new BoldEvaluationItem(ASSOCIATED_FINDINGS, "Associated findings") {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new BooleanEvaluationItem(DISTENTION, "Distention"));
                        add(new BooleanEvaluationItem(REBOUND, "Rebound tenderness"));
                        add(new BooleanEvaluationItem(PULSATILE, "Pulsatile mass"));
                        add(new BooleanEvaluationItem(BOWELSOUNDS, "Abnormal bowel sounds"));
                        add(new BooleanEvaluationItem(MCBURNEY, "McBurney sign"));
                        add(new BooleanEvaluationItem(MURPHY, "Murphy sign"));
                        add(new BooleanEvaluationItem(PSAOS, "Psaos sign"));
                        add(new BooleanEvaluationItem(ROVSING, "Rovsing sign"));
                        add(new BooleanEvaluationItem(OBTURATOR, "Obturator sign"));
                        add(new BooleanEvaluationItem(CARNETT, "Carnett sign"));
                        add(new BooleanEvaluationItem(COSTOVERTEBRAL, "Costovertebral tendernesss"));
                        add(new SectionCheckboxEvaluationItem(SKIN, "Skin findings", new ArrayList<EvaluationItem>() {{
                                add(new BooleanEvaluationItem(HERPES, "Herpes"));
                                add(new BooleanEvaluationItem(CELULITIS, "Celulitis"));
                                add(new BooleanEvaluationItem(ECHYMOSIS, "Flank or periumbilical echymosis"));
                                add(new BooleanEvaluationItem(CAPUT, "Caput medusa"));
                                add(new BooleanEvaluationItem(HENOCH, "Purpura "));
                            }}
                        ));
                        add(new BoldEvaluationItem(ASSOCIATED_SYMPTOMS, "Associated symptoms") {{
                                setBackgroundHighlighted(true);
                            }
                        });
                        add(new SectionCheckboxEvaluationItem(VOMITING, "Vomiting", new ArrayList<EvaluationItem>() {{
                                add(new BooleanEvaluationItem(VOMITING_FIRST, "Vomiting precedes pain"));
                                add(new BooleanEvaluationItem(PAIN_FIRST, "Pain precedes vomiting"));
                            }})
                        );
                        add(new BooleanEvaluationItem(ANOREXIA, "Anorexia"));
                        add(new BooleanEvaluationItem(BOWEL, "Change in bowel habits"));
                        add(new BooleanEvaluationItem(POSTOPERATIVE, "Post operative status"));
                        add(new BooleanEvaluationItem(FAMILY_HISTORYAA, "Family history of AAA"));
                        add(new BooleanEvaluationItem(OBGYN, "Ob gyn history"));
                        add(new BooleanEvaluationItem(HEMATURIA, "Hematuria"));
                        add(new BooleanEvaluationItem(URINARY, "Change in urinary habit"));
                    }
                }));
            items.add(new SectionCheckboxEvaluationItem(EPISTAXIS, "Epistaxis", new ArrayList<EvaluationItem>() {{

        }
        }));
        items.add(new SectionCheckboxEvaluationItem(HEADACHED_BLURRED_VISION_OR_AMS, "Headache, blurred vision", new ArrayList<EvaluationItem>() {{

        }
        }));
        items.add(new SectionCheckboxEvaluationItem(CHEST_BACK_PAIN_DYSPNEA, "Back pain", new ArrayList<EvaluationItem>() {{

        }
        }));
        return items;
    }
}
