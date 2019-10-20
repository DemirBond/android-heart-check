package com.szg_tech.heartcheck.core;

public class ConfigurationParams {

    //
    // Evaluation -> Bio:
    //
    public static final String BIO = "secbio";
    public static final String NAME = "secname";
    public static final String SUBTITLE = "secsubtitle";
    public static final String SHOULD_SHOW_ALERT = "secshould_show_alert";
    public static final String IS_SAVED_EVALUATION_LIST = "sec_saved_evaluation_list";
    public static final String AGE = "txtage";

    public static final String GENDER = "gender";
    public static final String MALE = "male";
    public static final String FEMALE = "female";

    public static final String BMI = "txtBMI";
    public static final String WEIGHT = "weight";
    public static final String HEART_RATE = "txtHR";
    public static final String RESP_RATE = "txtresprate";
    public static final String TEMPARATURE = "txttemp";
    public static final String SBP = "txtsbp";
    public static final String DBP = "txtdbp";
    public static final String IS_PAH = "isPAH";
    public static final String ORTHOSTATIC_SBP = "txtOrthostaticSBP";
    public static final String ORTHOSTATIC_SYMPTOMPS = "chkSymptomatic";
    public static final String WAIST_CIRC = "txtwaist";
    public static final String AA = "chkAsianCode";
    public static final String PREGNANCY = "chkpreg";
    public static final String RASAT = "txtO2Sat";

    //
    // Evaluation -> Symptoms:
    //
    public static final String SYMPTOMS = "secsymptoms";

    // Evaluation -> Symptoms -> Dyspnea:
    public static final String DYSPNEA = "secdyspnea";
    public static final String PLEASE_SELECT_ONE = "secplease_select_one";
    public static final String NEW_HF = "chknewHF";
    public static final String CHRONIC_HF = "chkHFPLVF";
    public static final String LUNG = "chklung";
    public static final String OUTPATIENT = "chkD5";
    public static final String EMERGENCY_ROOM = "chkD4";

    public static final String IN_HOSPITAL = "secin_hospital";
    public static final String DAY1 = "chkD1";
    public static final String DAY2 = "chkD2";
    public static final String DAY3 = "chkD3";
    public static final String DAY4 = "chkD4";
    public static final String DAY5 = "chkD5";
    public static final String DAY6 = "chkD6";

    public static final String DYSPNEA_ON_EXERTION = "chkDOE";
    public static final String STRENUOUS_EXERTION = "chkclass1";
    public static final String MORE_THAN_DAILY_ROUTINE = "chkclass2";
    public static final String DAILY_ROUTINE_MINIMAL_ACTIVITIES = "chkclass3";

    public static final String DYSPNEA_AT_REST = "chkdysp";
    public static final String WEIGHT_GAIN = "chkWeight";

    // Evaluation -> Symptoms -> Chest Pain:
    public static final String CHEST_PAIN = "sectionCP";

    // Evaluation -> Symptoms -> Chest Pain -> Emergency Room:
    public static final String EMERGENCY_ROOM_CP = "chkER";
    public static final String TWO_TYPICAL_OR_PROBABLE_ANGINA = "chkangina";
    public static final String TYPICAL_OR_PROBABLE_ANGINA_MORE_20_MIN = "chkangina20";
    public static final String ASA_ACS = "chkASA";
    public static final String ASA_USE_IN_PAST_1_WEEK = "chkASAuse";

    public static final String POSITIVE_TROP_I_OR_T = "chktrop";
    public static final String POSITIVE_TROPONIN = "chkpositivetrop";
    public static final String TROPONIN_X_MORE_3_ABOVE_NORMAL = "chktrop2";
    public static final String TROPONIN_1_3_ABOVE_NORMAL = "chktrop3";

    // Evaluation -> Symptoms -> Chest Pain -> Typical angina:
    public static final String TYPICAL_ANGINA_NEW = "chkTA";
    public static final String ESCALATING_IN_FREQUENCY = "chkescTA";

    // Evaluation -> Symptoms -> Chest Pain -> Probable angina:
    public static final String PROBABLY_ANGINA_NEW = "chkPA";

    // Evaluation -> Symptoms -> Chest Pain -> Undetermined chest pain:
    public static final String UNDETERMINED_CP_NEW = "chkNCP";

    // Evaluation -> Symptoms -> Chest Pain -> Undetermined chest pain -> Side/Hemithorax:
    public static final String SIDE_HEMITHORAX = "chkpleur";
    public static final String QUALITY = "secquality";
    public static final String SHARP = "chkCPSharp";
    public static final String PRESSURE = "chkCPPressure";
    public static final String TIGHTNESS = "chkCPTightness";
    public static final String SORENESS = "chkCPSoreness";
    public static final String HEAVINESS = "chktearing";
    public static final String AGGRAVATED_BY = "secaggravated_by";
    public static final String LYING = "chkCPLying";
    public static final String BREATHING = "chkCPBreathing";
    public static final String COUGHING = "chkCPCoughing";
    public static final String EXERTION = "chkCPExertion";
    public static final String PALPATION = "chkCPPalpation";
    public static final String RELIEVED_BY = "secrelieved_by";
    public static final String NTG = "chkCPNTG";
    public static final String REST = "chkCPRest";
    public static final String SITTING_UP = "chkCPSitting";
    public static final String LYING_ON_SIDE = "chkCPlyingside";
    public static final String ANALGESICS = "chkCPAnalgesics";
    public static final String RADIATION = "secradiation";
    public static final String JAW = "chkCPJaw";
    public static final String BACK = "chkCPBack";
    public static final String ARM = "chkCPArm";
    public static final String ASSOCIATED_WITH = "secassociated_with";
    public static final String DYSPNEA_CP = "chkCPDyspnea";
    public static final String NAUSEA = "chkCPNausea";
    public static final String DIAPHORESIS = "chkCPDiaph";
    public static final String FAINTNESS = "chkCPFaint";
    public static final String CPPALPITATIONS = "chkCPPalpitations";
    public static final String LASTING = "seclasting";
    public static final String CPSECONDS = "chkCPseconds";
    public static final String CPMINUTES = "chkCPminutes";
    public static final String CPCONSTANT = "chkCPconstant";
    public static final String CPHOURS = "chkCPhours";

    // Evaluation -> Symptoms -> Chest Pain -> Undetermined chest pain: -> Intercostal CP:
    public static final String INTERCOSTAL_CP = "chkCPbreath";

    // Evaluation -> Symptoms -> Chest Pain -> Undetermined chest pain: -> Central/Precordial CP:
    public static final String CENTRAL_PRECORDIAL_CP = "chkPrecordial";

    // Evaluation -> Symptoms -> Chest Pain -> Unable to Exercise:
    public static final String UNABLE_TO_EXERCISE = "chkunable";

    // Evaluation -> Symptoms -> Presyncope / Syncope / Seizure:
    public static final String SYNCOPE_PRESYNCOPE = "chkTestSyncope";
    public static final String CIRCUMSTANCE = "seccircumstance";
    public static final String UPRIGHT_POSITION = "chkSynStanding";
    public static final String SUDDEN_NOISE = "chkSynOther";
    public static final String NECK_MOVEMENT_MANIPULATION = "chkSynneck";
    public static final String EXERTIONAL = "chkSynProSitting";
    public static final String SPORADIC = "chkSynsporadic";
    public static final String PRODROMAL_SYMPTOMS = "secprodromal_symptoms";
    public static final String NAUSEA_SYN = "chkSynNausea";
    public static final String DIZZINESS = "chkSynDizziness";
    public static final String SYNPALPITATIONS = "chkSynPalpitations";
    public static final String AURA = "chkSynaura";
    public static final String SYNCOPE_DURATION_DURING_SYNCOPE = "secsyncope_duration_during_syncope";
    public static final String MINUTES_SYN_DUR = "txtSynMin";               // This is not in code yet, probably should
    public static final String SECONDS_SYN_DUR = "txtSynSec";               // This is not in code yet, probably should
    public static final String CYANOSIS = "chkSynNone";
    public static final String PALLOR_DIAPHORESIS = "chkSynpallor";
    public static final String UNUSUAL_POSTURE = "chkSynposture";
    public static final String POSTICTAL_SYMPTOMS = "secpostictal_symptoms";
    public static final String DISORIENTATION = "chkSynDisor";
    public static final String PARALYSIS = "chkSynPara";
    public static final String CHEST_PAIN_POS_CP = "chkSynPosCP";
    public static final String PROLONGED_FATIGUE = "chkSynfatigue";
    public static final String TRAUMATIC_INJURY = "chkTraumaticInj";

    // Evaluation -> Symptoms -> Edema:
    //public static final String SYMEDEMA = "sectionedema";
    //public static final String PITTING = "chkpitting";
    //public static final String NONPITTING = "chknonpitting";
    //public static final String LOCALIZED = "chklocaledema";
    //public static final String DIFFUSE = "chkdiffusedema";

    // Evaluation -> Symptoms -> Weakness:
    public static final String WEAKNESS = "sectionweakness";
    public static final String MALAISE = "chkmalaise";

    // Evaluation -> Symptoms -> Palpitations:
    public static final String SYMPALPITATIONS = "sectionpalpitaions";
    public static final String PAL_FREQUENCY = "secfrequency";
    public static final String PALDAY = "chkpalday";
    public static final String PALWEEK = "chkpalweek";
    public static final String PALMONTH = "chkpalmonth";
    public static final String PALYEAR = "chkpalyear";
    public static final String PAL_TYPE = "secType";
    public static final String EXTRASYSTOLIC = "chkextrasys";

    // Evaluation -> Symptoms -> Palpitations -> Tachycardic:
    public static final String TACHYCARDIC = "chktachycardic";
    public static final String VAGAL = "secvagal";
    public static final String VAGAL_ABRUPT = "chkvagalabrupt";
    public static final String VAGAL_GRADUAL = "chkvagalgradual";
    public static final String VAGAL_NORESPONSE = "chknoresponse";

    public static final String ANXIETY = "chkanxiety";
    public static final String PULSATION = "chkpulsation";
    public static final String SYMPTOM_DURATION = "secsymptom_duration";
    public static final String SECONDS_PAL_DUR = "txtpalseconds";
    public static final String MINUTES_PAL_DUR = "txtpalminutes";
    public static final String HOURS_PAL_DUR = "txtpalhours";
    public static final String PAL_SYNCOPE = "chkpalsyncope";
    public static final String PAL_ANGINA = "chkpalangina";
    public static final String PAL_SYMPTOMS = "secpal_symptoms";
    public static final String PAL_POLYURIA= "chkpalpoyuria";
    public static final String PAL_NECK = "chkpalneck";
    public static final String PAL_EKG = "secpal_ekg";
    public static final String PAL_NSR = "chkpalNSR";
    public static final String PAL_REGRR = "chkpalregRR";
    public static final String PAL_IRREGRR= "chkpalirregRR";
    public static final String PAL_ONSET = "secpal_onset";
    public static final String PAL_SUDDEN = "chkpalsudden";
    public static final String PAL_POSITION = "chkpalposition";
    public static final String PAL_EXERTION= "chkpalexertion";
    public static final String PAL_POSTEXERTION = "chkpostexertion";

    // Evaluation -> Symptoms -> Abdominal Pain:
    public static final String ABDOMINAL = "sectionabdominalpain";
    public static final String PAIN_QUALITY = "secpain_quality";
    public static final String ABSHARP = "chkAbsharp";
    public static final String ABCOLIC = "chkAbcolic";
    public static final String ABACHING = "chkAbaching";
    public static final String PAIN_LOCATION = "secpain_location";
    public static final String PERIUMBILICAL = "chkperiumbilical";
    public static final String EPIGASTRIC= "chkepigastric";
    public static final String SUPRAPUBIC = "chksuprapubic";
    public static final String ABSPASM = "chkAbspasm";
    public static final String ASSOCIATED_FINDINGS = "secassociated_findings";
    public static final String DISTENTION = "chkdistention";
    public static final String REBOUND= "chkrebound";
    public static final String PULSATILE = "chkpulsatile";
    public static final String BOWELSOUNDS = "chkbowelsounds";
    public static final String MCBURNEY = "chkMcburney";
    public static final String MURPHY= "chkmurphy";
    public static final String PSAOS = "chkpsaos";
    public static final String ROVSING= "chkrovsing";
    public static final String OBTURATOR = "chkobturator";
    public static final String CARNETT= "chkcarnett";
    public static final String COSTOVERTEBRAL = "chkcostovertebral";

    // Evaluation -> Symptoms -> Abdominal Pain -> Skin findings:
    public static final String SKIN = "chkskin";
    public static final String HERPES = "chkherpes";
    public static final String CELULITIS= "chkcelulitis";
    public static final String ECHYMOSIS = "chkechymosis";
    public static final String CAPUT= "chkcaput";
    public static final String ICTERUS = "chkicterus";
    public static final String HENOCH = "chkhenoch";

    public static final String ASSOCIATED_SYMPTOMS = "secassociated_symptoms";

    // Evaluation -> Symptoms -> Abdominal Pain -> Vomiting:
    public static final String VOMITING = "chkvomiting";
    public static final String VOMITING_FIRST = "chkvomitfirst";
    public static final String PAIN_FIRST= "chkpainfirst";

    public static final String ANOREXIA = "chkanorexia";
    public static final String BOWEL= "chkbowel";
    public static final String POSTOPERATIVE = "chkchkpostoperative";
    public static final String FAMILY_HISTORYAA= "chkfamilyhistoryAA";
    public static final String URINARY = "chkurinary";
    public static final String HEMATURIA= "chkhematuria";
    public static final String OBGYN = "chkobgyn";

    // Evaluation -> Symptoms -> Shock:
    public static final String SHOCK = "secshock";
    public static final String HYPOVOLEMIA = "chkhypovolemia";
    public static final String INFECTIOUS = "chkinfectious";
    public static final String SPINALCORD= "chkspinalcord";
    public static final String ALLERGIC = "chkallergen";
    public static final String PHARMACOLOGIC = "chkpharmacologic";


    //
    // Evaluation -> Review of Systems:
    //
    public static final String REVIEW_OF_SYSTEMS = "secreview_of_systems";
    public static final String WEIGHT_CHANGE = "chkweightchange";
    public static final String THYROTOXICOSIS = "chkThyro";
    public static final String HYPOTHYRO = "chkHypoThyro";
    public static final String OSA = "chkOSA";
    public static final String SINUS = "Chksinus";
    public static final String COUGH = "Chkcough";
    public static final String SPUTUM = "Chksputum";
    public static final String HEMOPTYSIS = "chkhemoptysis";
    public static final String PREVIOUS_DVTE = "chkDVTE";
    public static final String PND = "chkPND";
    public static final String ORTHOPNEA = "chkorthopnea";
    public static final String PALPITATIONS = "chkpalpitations";
    public static final String ACTIVE_PEPTIC_ULCER_DISEASE = "chkPUD";
    public static final String LIVER_DISEASE = "chkliver";
    public static final String BLEED_IN_THE_PAST_3_MONTHS = "chkbleed";
    public static final String TIA = "chktia";
    public static final String CLAUDICATION = "chkclaudication";
    public static final String ULCER = "chkulcer";
    public static final String CARPAL = "chkcarpal";
    public static final String NEUROPATHY = "chkneuropathy";
    public static final String UNILATERAL_LOWER_LIMB_PAIN = "chkunilateral";
    public static final String PREVIOUS_DVT_PE = "chkPVTE";
    public static final String RHEUMATIC_DISEASE = "chkrheum";


    //
    // Evaluation -> Physical Exam:
    //
    public static final String PHYSICAL_EXAM = "secphysical_exam";
    public static final String NECK_VEINS = "chkhepato";
    public static final String JUGULAR_VENOUS_DISTENTION = "chkJVD";
    public static final String CAROTID_BRUIT = "chkbruit";
    public static final String DISPLACED_PMI = "chkPMI";
    public static final String LEFT_SIDED_S3 = "chkS3";
    public static final String LEFT_SIDED_S4 = "chkS4";
    public static final String FRICTION_RUB = "chkrub";
    public static final String DISTANT = "chkdistant";

    // Evaluation -> Physical Exam -> Murmur, pathological heart sounds:
    public static final String HEART_MURMUR = "chkHeartMurmur";
    public static final String FOCUS_ON_THE_MOST_ABNORMAL_AUSCULTATION_FOCI = "secfocus_on_the_most_abnormal_auscultation_foci";

    // Evaluation -> Physical Exam -> Murmur, pathological heart sounds -> SI Mitral:
    public static final String SI_MITRAL = "chkS1Mitral";
    public static final String LOUD_S1_MITRAL = "chkS1MitralLoud";
    public static final String NORMAL_S1_MITRAL = "chkS1MitralNormal";
    public static final String SOFT_SI_MITRAL = "chkS1MitralSoft";

    // Evaluation -> Physical Exam -> Murmur, pathological heart sounds -> S2 Aortic:
    public static final String S2_AORTIC = "chkS2Aortic";
    public static final String LOUD_S2_AORTIC = "chkS2MitralLoud";
    public static final String NORMAL_S2_AORTIC = "chkS2MitralNormal";
    public static final String SOFT_S2_AORTIC = "chkS2MitralSoft";

    // Evaluation -> Physical Exam -> Murmur, pathological heart sounds -> P2 Pulmonic:
    public static final String P2_PULMONIC = "chkP2Pulmonic";
    public static final String LOUD_P2_PULMONIC = "chkP2PulmonicLoud";
    public static final String NORMAL_P2_PULMONIC = "chkP2PulmonicNormal";
    public static final String SOFT_P2_PULMONIC = "chkP2PulmonicSoft";

    // Evaluation -> Physical Exam -> Murmur, pathological heart sounds -> S1 Tricuspid:
    public static final String S1_TRICUSPID = "chkS1Tricuspid";
    public static final String LOUD_S1_TRICUSPID = "chkS1TricuspidLoud";
    public static final String NORMAL_S1_TRICUSPID = "chkS1TricuspidNormal";
    public static final String SOFT_S1_TRICUSPID = "chkS1TricuspidSoft";

    // Evaluation -> Physical Exam -> Murmur, pathological heart sounds -> Murmur characteristics:
    public static final String MURMUR = "secmurmur";
    public static final String SYSTOLIC_MURMUR = "chkSystolicMurmur";
    public static final String CRESCENDO_DECRESCENDO = "chkCresDecres";
    public static final String EARLY_MID_SYSTOLIC_PEAKING = "chkEarlyMidPeak";
    public static final String LATE_SYSTOLIC_PEAKING = "chkLatePeak";
    public static final String PLATEAU_SHAPED = "chkPlateuShaped";
    public static final String HALOSYSTOLIC = "chkHalosystolic";
    public static final String PANSYSTOLIC = "chkPansystolic";
    public static final String MIDSYSTOLIC = "chkMidsystolic";
    public static final String SOFTER_WITH_SQUAT = "chksquat";
    public static final String SOFTER_WITH_STANDING = "chkstanding";
    public static final String EJECTION_SOUND = "chkejectionsound";
    public static final String SYSTOLIC_CLICK = "chksystolicclick";
    public static final String DIASTOLIC_MURMUR = "chkDiastolicMurmur";
    public static final String DECRESCENDO = "chkDecrescendo";
    public static final String RUMBLE = "chkRumble";
    public static final String MITRAL_OPENING_SNAP = "chkMitralOpeningSnap";

    public static final String NEW_RALES = "chkMR";
    public static final String PULMONARY_EDEMA = "chkPEd";
    public static final String DIMINISHED_BREATH_SOUNDS = "chkbreath";
    public static final String DRY_RALES = "chkrhonchi";
    public static final String PERCUSSION = "chkpercussion";
    public static final String INCREASED_THORAX_DIAMETER = "chkthorax";
    public static final String ABDOMINAL_TENDERNESS = "chkabdominal";
    public static final String ABDOMINAL_DISTENTION = "chkdistention";
    public static final String ABDOMINAL_BOWEL = "chkbowelsounds";
    public static final String COSTO_VERTEBRAL = "chkcostovertebral";
    public static final String HJR = "chkHJR";
    public static final String ASCITES = "chkascites";
    public static final String ANY_CNS_SYMPTOMS = "chkAMS";

    // Evaluation -> Physical Exam -> Cyanosis:
    public static final String SYMCYANOSIS = "chkCyanosis";
    public static final String CENTRAL = "chkcentral";
    public static final String PERIPHERAL = "chkperipheral";

    public static final String COLD_CLAMMY_EXTERMITIES = "chkshock";
    public static final String CLUBBING = "Chkskinwarm";
    public static final String EDEMA = "chkedema";
    public static final String ABSENTR = "chkabsentright";
    public static final String ABSENTL = "chkabsentleft";
    public static final String ABBRUIT = "chkabbruit";
    public static final String DIFFERENCE_IN_SBP = "txtDiffInSBP";


    //
    // Evaluation -> Cardiovascular:
    //
    public static final String CURRENT_PAST_CV_PROFILE = "seccurrent_past_cv_profile";

    // Evaluation -> Cardiovascular -> Coronary Heart Disease:
    public static final String CORONARY_HEART_DISEASE = "seccoronary_heart_disease";

    // Evaluation -> Cardiovascular -> Coronary Heart Disease -> Acute Coronary Syndrome:
    public static final String ACUTE_CORONARY_SYNDROME = "chkACS";
    public static final String MORE_2_ANGINA_24HR = "chkang24";
    public static final String ANGINA_MORE_20MIN = "chkAn20";
    public static final String MORE_2_ANTANGINAL = "chkAnAn";
    public static final String STEMI = "chkSTEMI";
    public static final String DURATION_HOURS = "TxtSTEMIdur";
    public static final String ANTERIOR = "chkanterior";
    public static final String INFERIOR = "chkinferior";
    public static final String OTHER = "chkother";
    public static final String REFRACTORY_ANGINA = "chkrefractory";
    public static final String CHANGING_TROP_I = "chkchangetrop";

    // Evaluation -> Cardiovascular -> Coronary Heart Disease -> PCI, CABG:
    public static final String PCI_CABG = "chkPCI";
    public static final String LAST_PROCEDURE = "Txtprocedure";
    public static final String BMS = "chkBMS";
    public static final String DES = "chkDES";
    public static final String CABG = "chkCABG";
    public static final String AUTO_VEIN = "chkautovein";
    public static final String AUTO_ARTERY = "chkautoartery";
    public static final String NON_AUTO = "chknonauto";

    // Evaluation -> Cardiovascular -> Coronary Heart Disease -> STABLE ANG:
    public static final String STABLE_ANG = "chkSTENUSIS";
    public static final String NYHA_CCVS_CLASS_12 = "chkNYHA1_2";
    public static final String NYHA_CCVS_CLASS_22 = "chkNYHA2_2";
    public static final String NYHA_CCVS_CLASS_32 = "chkNYHA3_2";
    public static final String NYHA_CCVS_CLASS_42 = "chkNYHA4_2";

    public static final String LM = "chkLM";
    public static final String LAD = "chkLAD";
    public static final String RCA = "chkRCA";
    public static final String LCX = "chkLCX";

    // Evaluation -> Cardiovascular -> Coronary Heart Disease -> ICD-10:
    public static final String ICD_10 = "secicd_10";
    public static final String CHRONIC_TOTAL_OCCLUSION = "chkCTO";
    public static final String CORONARY_ANEURYSM = "chkcoraneurysm";
    public static final String CORONARY_DISSECTION = "chkcordissection";
    public static final String CALCIFIED_CORONARY_LESION = "chkcalcified";
    public static final String LIPID_RICH_PLAQUE = "chklipidrich";
    public static final String DOCUMENTED_VASOSPASM = "chkvasospasm";

    public static final String VESSEL_MORE_50 = "txtNumVessel";
    public static final String LVEF_CHD = "TxtHF";

    // Evaluation -> Cardiovascular -> Heart Failure:
    public static final String HEART_FAILURE = "chkHF";
    public static final String HF_DIAGNOSIS_DURATION_WEEK = "txtdur";
    public static final String PREVIOUS_HF_HOSPITALIZATION = "chkfoutpt";
    public static final String S_P_ICD = "chkICD";
    public static final String CRT_ICD = "chkCRTI";
    public static final String LVEF = "txtCHF";

    // Evaluation -> Cardiovascular -> Heart Failure -> Heart Failure Stage:
    public static final String NYHA_CLASS = "secnyha_class";

    public static final String AT_HIGH_RISK = "chkA";
    public static final String NO_SIGNS_OF_HF = "chkB";
    public static final String SYMPTOMS_OF_HF = "chkC";
    public static final String NYHA_CCVS_CLASS = "chkNYHA";
    public static final String NYHA_CCVS_CLASS_1 = "chkNYHA1";
    public static final String NYHA_CCVS_CLASS_2 = "chkNYHA2";
    public static final String NYHA_CCVS_CLASS_3 = "chkNYHA3";
    public static final String NYHA_CCVS_CLASS_4 = "chkNYHA4";

    // Evaluation -> Cardiovascular -> Heart Failure -> Heart Failure Stage -> Refractory HF Requiring Specialized Interventions:
    public static final String REFRACTORY_HF = "chkD";
    public static final String CALCULATE_HFSS = "secCalculate_HFSS";
    public static final String NO_SIGNIFICANT_COMORBIDITIES = "chkcom";
    public static final String VO_MAX_KG = "txtVO2";

    // Evaluation -> Cardiovascular -> Heart Failure:
    public static final String IDIOPATHIC_DCM_NONISCHEMIC = "chkNonischemicCMP";
    public static final String POST_MI_MORE_45 = "chkMI";
    public static final String LV_ANEURYSM = "chkLVaneurysm";
    public static final String ISCHEMIC_POST_MI_LESS_45 = "chkIschemic";
    public static final String CARDIOTOXINS = "chkCardiotoxins";
    public static final String FAMILIAL_CMP = "chkFamHXofCMP";
    public static final String MYOCARDITIS = "chkmyocarditis";
    public static final String RV_DYSPLASIA = "chkSuspectedRVDysplasia";

    // Evaluation -> Cardiovascular -> Heart Failure -> HOCM:
    public static final String HOCM = "chkIschemicCMP";
    public static final String LVH_MORE_30 = "chkLVHGreater30";
    public static final String ABNORMAL_BP_RESPONSE_TO_EXERCISE = "chkAbnormBP";
    public static final String HISTORY_OF_SUDDEN_DEATH = "chkFamHistSuddenDeath";
    public static final String REST_DYNAMIC_PEAK = "chkLVOT";

    // Evaluation -> Cardiovascular -> Heart Failure:
    public static final String PERIPARTUM_CMP = "chkrestrictive";

    // Evaluation -> Cardiovascular -> Atrial Fibrillation:
    public static final String ATRIAL_FIBRILATION = "chkatrialfib";
    public static final String CHRONIC_AF = "chkchronicAF";
    public static final String PERSISTENT_AF = "chkpersistent";
    public static final String PAROXYMAL_AF = "chkparoxysmal";
    public static final String S_P_SUCCESSFUL_ABLATION = "chkablation";

    // Evaluation -> Cardiovascular -> Atrial Fibrillation -> Rhytm Control:
    public static final String RHYTM_CONTROL = "chkCV";
    public static final String CURRENT_ANIARRYTHMIC_THERAPY = "chkCAA";
    public static final String SOTALOL_AMIODARONE_MULTAQ_DOFETILIDE = "chkclass3AA";
    public static final String PROPOFONONE_FLECANIDE = "chkclass1AA";

    // Evaluation -> Cardiovascular -> Atrial Fibrillation -> Ventricular Rate Control:
    public static final String VENTRICULAR_RATE_CONTROL = "chkpharm";
    public static final String HEART_RATE_WITH_ACTIVITY = "TxtCMP";

    // Evaluation -> Cardiovascular -> Atrial Fibrillation -> Symptomatic:
    public static final String SYMPTOMATIC = "chkVHD";
    public static final String ACUTELY = "chkacutely";

    // Evaluation -> Cardiovascular -> Atrial Fibrillation:
    public static final String DURATION_DAYS = "Txtafd";

    // Evaluation -> Cardiovascular -> Atrial Fibrillation -> Previous TIA/CVA:
    public static final String PREVIOUS_TIA_CVA = "chkPrevious";
    public static final String LAST_THROMBOEMBOLIC_EVENT_MONTHS_AGO = "TxtPrevious";

    // Evaluation -> Cardiovascular -> Thromboembolic/VKA:
    public static final String THROMBOEMBOLIC_VKA = "secthromboembolic_vka";

    // Evaluation -> Cardiovascular -> Thromboembolic/VKA -> Thromboembolism / VKA:
    public static final String THROMBOEMBOLIC_PREVENTION_VKA_THERAPY = "secthromboembolic_prevention_vka_therapy";
    public static final String INR = "txtINR";

    // Evaluation -> Cardiovascular -> Thromboembolic/VKA -> Thromboembolism / VKA -> Patient related bleeding risk:
    public static final String PATIENT_BLEED_RISK = "chkbldrisk";
    public static final String ACTIVE_GASTRODUODENAL_ULCER = "chkPUD";
    public static final String BLEED_IN_3_MO_BEFORE_ADMISSION = "chkbleed";
    public static final String PLATELET_COUNT_LESS_50 = "chkplt";
    public static final String ICU_OR_CCU_ADMISSION = "chkICU";
    public static final String CENTRAL_VENOUS_CATHETER = "chkCVC";

    // Evaluation -> Cardiovascular -> Thromboembolic/VKA -> Thromboembolism / VKA -> Procedure related bleeding risk:
    public static final String PROCEDURAL_BLEED_RISK = "chkprocedural_bleed_risk";
    public static final String PRIOR_BLEED_DURING_BRIDGING_SIMILAR = "chkprior";
    public static final String PRIOR_ASA_USE = "chkpriorASA";
    public static final String RISK_NOT_CLINICALLY_IMPORTANT_LOW = "chkminorpro";
    public static final String RISK_UNCERTAIN = "chksurgery";
    public static final String RISK_INTERMEDIATE_HIGH = "chkemergencysurgery";

    // Evaluation -> Cardiovascular -> Thromboembolic/VKA -> Thromboembolism / VKA:
    public static final String DEEP_VENOUS_THROMBOSIS = "chkDeepVenousThrombosis";
    public static final String PULMONARY_EMBOLISM = "chkPE";

    // Evaluation -> Cardiovascular -> Thromboembolic/VKA -> Thromboembolism / VKA -> DVT diagnosis, prevention:
    public static final String DVY_PE_DIAGNOSIS_PREVENTION = "chkDVTprevention";
    public static final String MAJOR_SURGERY_TRAUMA = "chkgeneral";
    public static final String MAJOR_GYN_UROLOGY = "chkurology";
    public static final String TKR = "chkknee";
    public static final String THR = "chkhip";
    public static final String HIP_FRACTURE = "chkHPS";
    public static final String SPINE_SURGERY = "chkcancer";
    public static final String SPINAL_CORD_INJURY = "chkspinal";
    public static final String MEDICAL_ILLNESS = "chkacute";
    public static final String PAINFUL_DEEP_VENOUS_PALPATION_AND_EDEMA = "chkswelling";
    public static final String ACTIVE_CANCER = "chkactivecancer";
    public static final String PREVIOUS_VTE = "chkPVTE";
    public static final String RESPIRATORY_FAILURE = "chkRF";
    public static final String ALREADY_KNOWN_THROMBOPHILIC_CONDITION = "chkthrombo";
    public static final String RECENT_TRAUMA_SURGERY = "chkRecent";
    public static final String REDUCED_MOBILITY = "chkReduced";
    public static final String ONGOING_HORMONAL_TREATMENT = "chkhormone";
    public static final String ACUTE_INFECTION_RHEUMATOLOGIC_DISORDER = "chkinfection";

    // Evaluation -> Cardiovascular -> Thromboembolic/VKA -> Thromboembolism / VKA -> Acute CVA:
    public static final String ACUTE_CVA = "chkacutecva";
    public static final String NIHSS = "txtNIHSS";
    public static final String UNILATERAL_WEAKNESS = "chkunilateral_weakness";
    public static final String SPEECH_DISTURBANCE = "chkspeech_disturbance";
    public static final String DURATION_OF_SYMPTOMS = "ssdur";
    public static final String PRE_HOSPITAL_CARE = "chkpreh";

    // Evaluation -> Cardiovascular -> Thromboembolic/VKA -> Valvular heart disease:
    public static final String VALVULAR_HEART_DISEASE_THROMBOEMBOLIC = "secvalvular_heart_disease_thromboembolic";
    public static final String MECHANICAL_CAGEBALL = "chkcage";
    public static final String MECHANICAL_DISK_BILEAFLET_MITRAL = "chkmech";
    public static final String MECHANICAL_DISK_BILEAFLET_AORTIC = "chkMdav";
    public static final String RHEUMATIC_MITRAL_VALVE_DISEASE = "chkRMVD";
    public static final String LA_THROMBUS = "chkLAthr";
    public static final String LA_DIAMETER = "txtLAd";
    public static final String BIOPROSTHETIC_VALVE = "chkbiop";
    public static final String SYSTEMIC_EMBOLISM = "chksysemb";
    public static final String INFECTIVE_ENDROCARDITIS = "chkIE";
    public static final String LEFT_SIDED_PV_THROMBOSIS = "chkLPVT";
    public static final String RIGHT_SIDED_PV_THROMBOSIS = "chkRPVT";

    // Evaluation -> Cardiovascular -> Thromboembolic/VKA -> Other Cardiac Source of Embolism\n(Non Atrial Fibrillation):
    public static final String CARDIAC_SOURCE_OF_EMBOLISM = "seccardiac_source_of_embolism";
    public static final String NON_ACUTE_ARTERIAL_ISCHEMIC_STROKE = "chkArterialIschemic";
    public static final String AORTIC_ARCH_ATHEROSCLEROSIS = "chkAorticArchAth";
    public static final String LV_THROMBUS = "chkLVt";
    public static final String PFO = "chkPFO";
    public static final String MVP = "chkMVP";
    public static final String MITRAL_ANNULAR_VALCIFICATION = "chkMitralAnnular";
    public static final String CALCIFIC_AORTIC_VALVE_DISEASE = "chkCalcificAortic";

    // Evaluation -> Cardiovascular -> Thromboembolic/VKA -> Miscellaneous:
    public static final String MISCELLANEOUS = "secmiscellaneous";
    public static final String HIT = "chkHeparinIndThrom";
    public static final String HYPERCOAGULABLE_STATE = "chkApoA1";
    public static final String CEREBRAL_VENOUS_THROMBOSIS = "chkCerebralVenous";

    // Evaluation -> Cardiovascular -> Ventricular Tachyarrthymias:
    public static final String VENTRICULAR_TACHYARRTHYMIAS = "secventricular_tachyarrthymias";
    public static final String NSVT = "chkNSVT";
    public static final String MONOMORPHIC_VT = "chkMVT";
    public static final String REPETITIVE_MONOMORPHIC_VT = "chkRMVT";
    public static final String POLYMORPHIC_VT = "chkPVT";
    public static final String TORSADES = "chkTors";
    public static final String INCESSANT_VT = "chkIVT";
    public static final String IDIOPATHIC_VT = "chkidioVT";

    // Evaluation -> Cardiovascular -> Bradyarrthymia/Syncope:
    public static final String BRADYARRTHYMIA_SYNCOPE = "secbradyarrthymia_syncope";
    public static final String SYMPTOMATIC_SINUS_NODE_DYSFUNCTION = "chkSinusNodeDysfunction";
    public static final String HIGH_GRADE_AV_NODE_DISEASE = "chkAVNodeDisease";
    public static final String ISOLATED_NEUROCARDIOGENIC_UNEXPLAINED_SYNCOPE = "chkVasoDepressorSyncope";
    public static final String CAROTID_SINUS_HYPERSENSITIVITY = "chkCarotidSinusHypersensitivity";
    public static final String POTS = "chkPosturalOrthostatisTac";
    public static final String AUTONOMIC_FAILURE_SYNDROME = "chkAutonomicFailureSyndrome";
    public static final String HISTORY_OF_CARDIAC_ARREST = "chkHistCardArrest";
    public static final String BRUGADA_SYNDROME = "chkBrugada";
    public static final String LONG_QT = "chkLongQT";
    public static final String SARCOIDOSIS_GIANT_CELL_CHAGAS = "chksarc";

    // Evaluation -> Cardiovascular -> Valvular Heart Disease:
    public static final String VALVULAR_HEART_DISEASE = "secvalvular_heart_disease";

    // Evaluation -> Cardiovascular -> Pulmonary Hypertension:
    public static final String PULMONARY_HYPERTENSION = "secpulmonary_hypertension";

    // Evaluation -> Cardiovascular -> Vascular Diseases:
    public static final String VASCULAR_DISEASES = "secvascular_diseases";

    // Evaluation -> Cardiovascular -> Vascular Diseases -> Symptomatic Carotid Disease:
    public static final String SYMPTOMATIC_CAROTID_DISEASE = "secsymptomatic_carotid_disease";
    public static final String NONCARDIOEMBOLIC_VCA_TIA = "chkNoncardioCVA";
    public static final String NONCARDIOEMBOLIC_TIA = "chkNoncardioTIA";
    public static final String MORE_50_CAROTID_STENOSIS = "chkCEA";

    // Evaluation -> Cardiovascular -> Vascular Diseases -> Peripheric Vascular Disease:
    public static final String PERIPHERIC_VASCULAR_DISEASE = "secperipheric_vascular_disease";
    public static final String ABI_LESS_09 = "chkABI";
    public static final String CRITICAL_LIMB_ISCHEMIA = "chkcritical";
    public static final String ENDOVASCULAR_REVASCULARIZATION = "chkbypass";
    public static final String PERIPHERAL_ARTERY_BYPASS_GRAFT = "chkBKbypass";

    // Evaluation -> Cardiovascular -> Vascular Diseases -> Aortic Aneurysm:
    public static final String ABDOMINAL_AORTIC_ANEURYSM = "secabdominal_aortic_aneurysm";
    public static final String AA_DIAMETER_MORE_5 = "chkAADiameter";
    public static final String THORACIC = "chkthoracic";
    public static final String THORACIC_ABDOMINAL = "chkthoracoabdominal";


    //
    // Evaluation -> Pulmonary:
    //
    public static final String PULMONARY= "secPULMONARY";

    public static final String PFTS= "chkPFTS";
    public static final String FVC= "txtFVCP";
    public static final String PO2 = "txtPO2";
    public static final String HYPERCAPNIA= "chkhypercapnia";

    // Evaluation -> Pulmonary -> Asthma / Reactive airway disease:
    public static final String ASTHMA= "chkasthma";
    public static final String SYMPTOMS_WEEK = "txtasymptoms";
    public static final String NOCTURNAL = "txtnocturnal";
    public static final String SABA_USE = "txtSABA";

    // Evaluation -> Pulmonary -> Asthma / Reactive airway disease -> Interference with activity:
    public static final String INTERFERENCE= "chkinterference";
    public static final String NONE= "chknone";
    public static final String MINOR= "chkminor";
    public static final String SOME= "chksome";
    public static final String SIGNIFICANT= "chksignificant";

    // Evaluation -> Pulmonary -> Acute exacerbation:
    public static final String LUNG_COPD = "chkCOPD";
    public static final String CKD = "chkCKD";

    public static final String RENALIMAGE = "chkrenalimage";
    public static final String HISTOLOGY = "chkhistology";
    public static final String ACUTE_EXACERBATION= "chkexacerbation";
    public static final String COPDEX= "chkCOPDex";
    public static final String COPDHOS= "chkCOPDhos";

    public static final String ILD= "chkILD";


    //
    // Evaluation -> Renal:
    //
    public static final String RENAL= "secRENAL";
    public static final String CRINC = "txtcr";
    public static final String CR48H = "txtcrinc";
    public static final String URVOL = "txturine";


    //
    // Evaluation -> Major CV Risk Factors:
    //
    public static final String MAJOR_CV_RISK = "secmajor_cv_risk";

    // Evaluation -> Major CV Risk Factors -> Diabetes:
    public static final String DIABETES = "secdiabetes";
    public static final String TYPE_2_DM = "chkDM";
    public static final String TYPE_1_DM = "chkDM1";
    public static final String GESTATIONAL_DM = "chkgestational";
    public static final String RETINOPATHY = "chkRetinopathy";

    // Evaluation -> Major CV Risk Factors -> Diabetes -> Type II DM:
    public static final String DMNP = "chkDMNP";
    public static final String DMCKD = "chkDMCKD";
    public static final String DMOTHER = "chkDMother";
    public static final String DMARTHRO = "chkDMarthro";
    public static final String DMSKIN = "chkDMskin";
    public static final String DMORAL = "chkDMoral";
    public static final String DMHYPO = "chkDMhypo";
    public static final String DMHYPOCOMA = "chkDMhypocoma";
    public static final String DMHYPER = "chkDMhyper";
    public static final String DMMONO = "chkDMmono";
    public static final String DMPOLY = "chkDMpoly";
    public static final String DMAUTONOM = "chkDMautonom";
    public static final String DMANGIO = "chkDMangio";
    public static final String DMOTHERCIRC = "chkDMothercirc";
    public static final String DMGANGRENE = "chkDMgangrene";
    public static final String DMOTHERCOMP= "chkDMothercomp";
    public static final String DMUNSPEC = "chkDMunspec";
    public static final String DMWITHOUT = "chkDMwithout";

    // Evaluation -> Major CV Risk Factors -> Systemic Arterial Hypertension:
    public static final String SYSTEMIC_ARTERIAL_HYPERTENSION = "chkSAH";
    public static final String AMB_SBP = "ASBP";
    public static final String AMB_DBP = "ADBP";
    public static final String CHECK_LVH_ON_EKG = "seccheck_lvh_on_ekg";
    public static final String SBP_TREATED = "chkSBPTreated";
    public static final String AFRICAN_AMERICAN = "chkAA";
    public static final String SECONDARY_HYPERTENSION = "secsecondary_hypertension";
    public static final String PRIMARY_HYPERALDESTERONISM = "chkaldo";
    public static final String RENOVASCULAR_ATHEROSCLEROTIC = "chkrenovas";
    public static final String PHEOCROMOCYTOMA = "chkFMD";
    public static final String ACUTELY_SYMPTOMATIC = "secacutely_symptomatic";
    public static final String HEADACHED_BLURRED_VISION_OR_AMS = "chkhead";
    public static final String EPISTAXIS = "chkepis";
    public static final String CHEST_BACK_PAIN_DYSPNEA = "chkHTNCP";

    // Evaluation -> Major CV Risk Factors:
    public static final String TOBACCO_USE = "chkSmoke";
    public static final String FAMILY_HISTORY = "chkFamily";


    //
    // Evaluation -> Laboratories:
    //
    public static final String LABORATORIES = "seclaboratories";
    public static final String CHEM_BASIC = "secchem_basic";
    public static final String NA_MEQ_L = "txtNameq";
    public static final String NA = "txtNa";
    public static final String URINE_NA_MEQ_L = "txturineNa";
    public static final String SERUM_OSMOLALITY = "txtsosm";
    public static final String URINE_OSMOLALITY = "txtuosm";
    public static final String K_MEQ_L = "txtHomo";
    public static final String CREATININE_MG_DL = "txtcreatinine";
    public static final String BUN_MG_DL = "txtBUN";
    public static final String ALT = "txtALT";
    public static final String AST = "txtAST";
    public static final String FLCA = "txtFLCA";
    public static final String TSAT = "txtTSAT";
    public static final String FERRITIN = "txtferritin";
    public static final String HEMOGLOBIN = "txthemoglobin";
    public static final String FASTING_PLASMA_GLUCOSE = "txtGlucose";
    public static final String GFR_ML_MIN = "txtGFR";
    public static final String WORSENING_RENAL_FX = "ChkWG";
    public static final String LIPID_PROFILE = "seclipid_profile";
    public static final String ALREADY_ON_STATIN = "chkalready";
    public static final String STATIN_INTOLERANCE = "chkstatint";
    public static final String CHOLESTEROL = "txtCholesterol";
    public static final String TRG = "txtTRG";
    public static final String LDL_C = "txtLDL";
    public static final String HDL_C = "txtHDL";
    public static final String APO_B = "txtApoB";
    public static final String LDL_P = "txtLDLP";
    public static final String LPA_MG_DL = "txtLPA";
    public static final String ASCVD_RISK = "txtASCVD";
    public static final String OTHERS = "secothers";
    public static final String HBA1C = "txtHBA1C";
    public static final String CRP_MG_L = "txtCRP";
    public static final String NT_PROBNP_PG_ML = "txtproBNP";
    public static final String BNP_PG_ML = "txtBNP";
    public static final String ALBUMINURIA_MG_GM_OR_MG_24HR = "txtMICRO";

    // Evaluation -> Laboratories -> Abnormal urine sediment:
    public static final String URINE = "chksediment";
    public static final String RBC = "chkRBC";
    public static final String RBCCAST = "chkRBCcast";
    public static final String WBCCAST = "chkWBCcast";
    public static final String GRANULAR = "chkgranular";
    public static final String OVAL = "chkoval";


    //
    // Evaluation -> Diagnostics:
    //
    public static final String DIAGNOSTICS = "secdiagnostics";

    // Evaluation -> Diagnostics -> EKG:
    public static final String EKG = "chkEKG";
    public static final String NSR = "chkNSR";
    public static final String SVT = "chkPSVT";

    // Evaluation -> Diagnostics -> EKG -> Atrial Flutter:
    public static final String ATRIAL_FLUTTER = "chkflutter";
    public static final String TYPICAL_AF = "chktypicalAF";
    public static final String ATYPICAL_AF = "chkatypicalAF";

    // Evaluation -> Diagnostics -> EKG:
    public static final String PR_DURATION = "txtPRduration";
    public static final String QRS_DURATION = "txtQRS";
    public static final String NONSPECIFIC_ST_ABNORMALITY = "chknonspesific";
    public static final String ST_DEVIATION_MORE_05_MM = "chkST";
    public static final String T_WAVE_INVERSION_MORE_1MM = "chkTWI";
    public static final String LVH = "chkLVH";
    public static final String LOW_VOLTAGE_QRS = "chklowv";
    public static final String ABNORMAL_Q_WAVES = "chkabnormq";
    public static final String LBBB = "chkLBBB";
    public static final String BIFASCICULAR = "chkbifascicular";
    public static final String LAHB = "chkLAHB";
    public static final String LPHB = "chkLPHB";
    public static final String WPW = "chkWPW";
    public static final String VPACE= "chkVPace";
    public static final String RBBB = "chkRBBB";
    public static final String INTRAVENTICULAR_BLOCK = "chkIVCD";
    public static final String ATRIAL_PREMATURE_DEPOLARIZATION = "chkAPCs";
    public static final String JUNCTIONAL_PREMATURE_DEPOLARIZATION = "chkJPDs";
    public static final String FREQUENT_VENTRICULAR_PACING_OR_ECTOPY = "chkFreqVentPac";
    public static final String INFREQUENT_VENTRICULAR_PACING_OR_ECTOPY = "chkinfreqvent";
    public static final String FIRST_DEGREE_AV_BLOCK = "chkfirstdegree";
    public static final String SECOND_DEGREE_AV_BLOCK = "chksecondegree";
    public static final String TYPE_1 = "chktype1";
    public static final String TYPE_2 = "chktype2";
    public static final String THIRD_DEGREE_AV_BLOCK = "chkthirdegree";

    // Evaluation -> Diagnostics -> Stress Testing:
    public static final String STRESS_TESTING = "chkDTS";
    public static final String ETT = "seccircumstance";
    public static final String NUCLEAR = "seccircumstance";
    public static final String DSE = "seccircumstance";
    public static final String DUKE_TREADMILL_SCORE = "TxtTTS";
    public static final String SERUM_STRESS_SUMMED_SCORE = "txtStressSummedScore";
    public static final String STRESS_DIFFERENCE_SCORE = "txtreversible";
    public static final String ISCHEMIC_MYOCARDIUM_ON_MPS = "txtMPS";
    public static final String TID_OR_SIGNIFICANT_STRESS_INDUCED_LV_DISFUNCTION = "chkTID";
    public static final String FIXED = "chkfixed";
    public static final String VIABLE = "chkviable";
    public static final String EX_TIME_MIN = "txtExTimeMin";
    public static final String MAX_ST_MM = "txtMaxST";

    // Evaluation -> Diagnostics -> Stress Testing -> Angina Index:
    public static final String ANGINA_INDEX = "rbAnginaIndex";
    public static final String NO_ANGINA_DURING_EXERCISE = "secno_angina_during_exercise";
    public static final String NON_LIMITING_ANGINA = "secnon_limiting_angina";
    public static final String EXERCISE_LIMITING_ANGINA = "secexercise_limiting_angina";

    // Evaluation -> Diagnostics -> Stress Testing:
    public static final String ST_ELEVATION = "chkSTelevation";
    public static final String ABNORMAL_BP_RESPONSE = "chkabnormalBP";
    public static final String VENTRICULAR_TACHYCARDIA = "chkExVT";
    public static final String VENTRICULAR_TACHYCARDIA_PAH = "chkED";
    public static final String PROLONG_ST_DEPRESSION = "chkprolongedST";
    public static final String FIXED_PERFUSION_DEFECTS_OR_AKINETIC_DYSKINETIC = "chkfixedSE";
    public static final String STRESS_INDUCED_IMAGES = "chkviableSE";
    public static final String VIABILITY_PRESENT = "chkTIDSE";
    public static final String DSE_ISCHEMIC_THRESHOLD = "txtDSE";
    public static final String DSE_OR_STRESS_MRI = "txtWMA";
    public static final String ARTIFACTURAL_UNINTERPRETABLE_IMAGES = "chkuninterpret";

    // Evaluation -> Diagnostics -> Echocardiography:
    public static final String ECHOCARDIOGRAPHY = "chkEcho";
    public static final String PERICARDIAL_EFFUSION = "chkpericardial";
    //public static final String HYPERCAPNIA= "chkhypercapnia";
    public static final String RWMA = "chkRWMA";
    public static final String ENLARGED_LA_OR_LVH = "chkEnlargedLA";
    public static final String E_A_LESS_05_AND_DT_MORE_280MS = "chkLVeccenticity";
    public static final String GRADE_MORE_2_DIASTOLIC_DYSFUNCTION = "chkMPI";
    public static final String GRADE_MORE_1_DIASTOLIC_DYSFUNCTION = "chkMPI1";
    public static final String GRADE_MORE_12_DIASTOLIC_DYSFUNCTION = "chkMPI2";
    public static final String RESPIRATORY_IVS_SHIFT = "chkIVSshift";
    public static final String MITRAL_E_VARIATION = "chkmitralE";
    public static final String HEPATIC_VEIN_EXP_DIASTOLIC_REVERSAL = "chkhepatic";
    public static final String ENLARGED_RA = "chkEnlargedRA";
    public static final String ENLARGED_RV = "chkEnlargedRV";
    public static final String MIDSYSTOLIC_NOTCH = "chkmidsystolicn";
    public static final String LV_LATEREAL_ANNULUS_E_E = "txtMP";
    public static final String LV_LATERAL_ANNULUS_E_E = "txtMPL";
    public static final String LV_MEDIAL_ANNULUS_E_E = "txtMPM";
    public static final String LVEF_ECHO = "txtEF";
    public static final String LVEF_ONSET = "txtLVEF";
    public static final String TRJ_VELOCITY = "txtTRJ";
    public static final String TAPSE = "txtTAPSE";
    // Evaluation -> Diagnostics -> Chest x-ray:
    public static final String CHEST_X_RAY = "chkchestxray";
    public static final String RIGHT_PLEURAL_EFFUSION = "chkRPLE";
    public static final String LEFT_PLEURAL_EFFUSION = "chkLPLE";
    public static final String PULMONARY_EDEMA_CHEST = "chkpuledema";
    public static final String ENLARGED_CARDIAC_SOLHOUETTE = "chkenlarcar";
    public static final String WIDENED_MEDIASTENEUM = "chkWidened";
    public static final String PNEUMOTHORAX = "chkpneumothorax";
    public static final String CONSOLIDATION = "chkconsolidation";
    public static final String INFILTRATE= "chkinfiltrate";

    // Evaluation -> Diagnostics -> High resolution CT:
    public static final String HRCT = "chkHRCT";
    public static final String GROUND = "chkground";
    public static final String SEPTAL = "chkseptal";
    public static final String RETICULAR = "chkreticular";
    public static final String NODULAR = "chknodular";
    public static final String CONSOLIDATE = "chkconsolidate";
    public static final String HONEY = "chkhoney";
    public static final String BRONCH= "chkbronch";
    public static final String MEDIAS = "chkmedias";
    public static final String PLEURAL= "chkpleuralthick";

    // Evaluation -> Diagnostics:
    public static final String RHC = "secright_heart_catheterization";

    public static final String CORONARY_CALCIUM_SCORE = "txtCCS";
    public static final String TOTAL_CCS = "txtTotalCCS";


    //
    // Evaluation -> Current Therapies:
    //
    public static final String CURRENT_THERAPIES = "seccurrent_therapies";

    // Evaluation -> Current Therapies -> PO Meds:
    public static final String PO_MEDS = "secpo_meds";

    // Evaluation -> Current Therapies -> PO Meds -> B Blocker:
    public static final String B_BLOCKER = "chkcar";
    public static final String CARVEDILOL_3125BID = "chkBisoprolol25";
    public static final String CARVEDILOL_625BID = "chkCarvedilol625";
    public static final String CARVEDILOL_125BID = "chkCarvedilol125";
    public static final String CARVEDILOL_25BID = "chkCarvedilol25";
    public static final String METOPROLOLER_25_QD = "chkBisoprolol5";
    public static final String METOPROLOLER_50_QD = "chkMetoprololER50";
    public static final String METOPROLOLER_100_QD = "chkMetoprololER100";
    public static final String METOPROLOLER_150_QD = "chkBisoprolol10";
    public static final String METOPROLOLER_200_QD = "chkMetoprololER200";

    // Evaluation -> Current Therapies -> PO Meds -> Ace I/ ARB:
    public static final String ACEL_ARB = "chkace";
    public static final String LISINOPRIL_5QD = "chklisinopril5";
    public static final String LISINOPRIL_10QD = "chklisinopril10";
    public static final String LISINOPRIL_20QD = "chklisinopril20";
    public static final String LOSARTAN_25QD = "chklosartan25";
    public static final String LOSARTAN_50QD = "chklosartan50";
    public static final String LOSARTAN_100QD = "chklosartn100";

    // Evaluation -> Current Therapies -> PO Meds -> PO Diuretic:
    public static final String PO_DIURETIC = "chkdiuretic";
    public static final String FUROSEMIDE_40 = "chkfurosemide40";
    public static final String FUROSEMIDE_80 = "chkfurosemide80";
    public static final String FUROSEMIDE_80_PLUS = "chkfurosemide81";
    public static final String BURNEX_1 = "chkbumex1";
    public static final String BURNEX_2 = "chkbumex2";
    public static final String BURNEX_2_PLUS = "chkbumex3";
    public static final String TORSEMIDE_20 = "chktorsemide20";
    public static final String TORSEMIDE_40 = "chktorsemide40";
    public static final String TORSEMIDE_50_PLUS = "chktorsemide50";
    public static final String HCTZ = "chkHCTZ";
    public static final String INDAPAMIDE = "chkindapamide";
    public static final String CHLORTHALIDONE_METOLAZONE = "chkchlorthalidone";
    public static final String SPIROLACTONE= "chkaldactone";
    // Evaluation -> Current Therapies -> PO Meds:
    public static final String CCB = "chkCCB";
    public static final String VASODILATOR = "chkvasodilator";
    public static final String HYDRALAZINE = "chkhydralazine";
    public static final String NITRATE = "chknitrate";
    public static final String DIHYDROPYRIDINE = "chkdihydropyridine";
    public static final String NONDIHYDROPYRIDINE = "chknondihydropyridine";
    public static final String CURRENT_VKA_THERAPY = "chkVKA";
    public static final String DIRECT_THROMBIN_INHIBITORS = "chkCAC";
    public static final String FACTOR_XA_INHIBITORS = "chkFactorX";

    // Evaluation -> Current Therapies -> In Hospital/IV Therapies:
    public static final String IN_HOSPITAL_THERAPIES = "secin_hospital_therapies";

    // Evaluation -> Current Therapies -> In Hospital/IV Therapies -> IV Antiarrythmic:
    public static final String FOUR_ANTIARRYTHMIC = "chkIVAA";
    public static final String CONTINOUS_IVAA = "chkAAcon";
    public static final String BOLUS_IVAA = "chkAAbolus";
    public static final String TITRATION_IVAA = "chkAAtitr";
    public static final String MONITORING_FREQUENCY_Q_HR_IVAA = "TxtAAmonitor";
    public static final String TRANSITION_TO_PO_ANTIARRYTHMIC = "chkPOAA";

    // Evaluation -> Current Therapies -> In Hospital/IV Therapies:
    public static final String URGENT_CV = "chkurgcv";
    public static final String DEFIBRILLATION_ACLS = "chkdefib";

    // Evaluation -> Current Therapies -> In Hospital/IV Therapies -> IV Antihypertensive:
    public static final String FOUR_ANTIHYPERTENSIVE = "chkIVHT";
    public static final String CONTINOUS_IVHT = "chkHTcon";
    public static final String BOLUS_IVHT = "chkHTbolus";
    public static final String TITRATION_IVHT = "chkHTtitr";
    public static final String MONITORING_FREQUENCY_Q_HR_IVHT = "TxtHTmonitor";

    // Evaluation -> Current Therapies -> In Hospital/IV Therapies -> IV Vasoactive:
    public static final String FOUR_VASOACTIVE = "chkIVVA";
    public static final String CONTINOUS_IVVA = "chkVAcon";
    public static final String BOLUS_IVVA = "chkVAbolus";
    public static final String TITRATION_IVVA = "chkVAtitr";
    public static final String MONITORING_FREQUENCY_Q_HR_IVVA = "TxtVAmonitor";
    public static final String FOUR_NPS = "chkIVNPS";
    public static final String FOUR_NTG = "chkIVNTG";
    public static final String FOUR_MILRINONE = "chkmilrinone";

    // Evaluation -> Current Therapies -> In Hospital/IV Therapies -> IV Diuretic:
    public static final String FOUR_DIURETIC = "chkIVDI";
    public static final String CONTINOUS_IVDI = "chkcon";
    public static final String MONITORING_FREQUENCY_Q_HR_IVDI = "Txtmonitor";
    public static final String INTERMITTENT = "chkPODI";

    // Evaluation -> Current Therapies -> In Hospital/IV Therapies -> Mechanical Ventiallation or NIPPV:
    public static final String MECHANICAL_VENTIALLATION_OR_NIPPV = "chkNIPPV";
    public static final String RESPIRATORY_INTERVENTIONS_Q_HR = "txtRI";

    // Evaluation -> Current Therapies -> In Hospital/IV Therapies:
    public static final String O2_SUPPLEMENT = "txtOsupp";
    public static final String FOUR_VASOPRESSORS = "chkVAD";
    public static final String ULTRAFILTRATION = "chkult";
    public static final String IABP = "chkIABP";
    public static final String TEMPORARY_PM = "chkTPM";


    //
    // Evaluation -> Noncardiac Surgical Risk:
    //
    public static final String NONCARDIAC_SURGICAL_RISK = "secnoncardiac_surgical_risk";
    public static final String EMERGENCY_SURGERY = "chkemergency";
    public static final String INTERMEDIATE_RISK = "chkelective";
    public static final String HIGH_RISK = "chkvascular";
    public static final String LOW_RISK_SURGERY_CATARACT_PLASTIC = "chklowriskelec";
    public static final String UNABLE_TO_EXERCISE_PHYSICALLY_INACTIVE = "chkunab";
    public static final String METS = "TxtMETS";
    public static final String DUKE_ACTIVITY_SCORE_INDEX = "TxtDASI";


    //
    // Evaluation -> Heart Specialist Management:
    //
    public static final String HEART_SPECIALIST_MANAGEMENT = "secheart_specialist_management";

    // Evaluation -> Heart Specialist Management -> 6MWT, CPET:
    public static final String BIO_PAH_MAIN = "secbio_pah_main";
    public static final String SIX_MW_DISTANCE = "txt6MWT";
    public static final String MAX_VO_MG_KG_MIN = "txtVO2";

    // Evaluation -> Heart Specialist Management -> PAH clinics:
    public static final String PAH = "secpah";
    public static final String IDIOPATHIC = "chkIdio";

    // Evaluation -> Heart Specialist Management -> PAH clinics -> Congenital:
    public static final String CONGENITAL = "chkCongenital";
    public static final String ASD_LESS_2CM = "chkASD";
    public static final String VSD_LESS_1CM = "chkVSD";
    public static final String POST_CORRECTIVE_SURGERY = "chkPCS";
    public static final String EISENMENGER = "chkEisen";

    // Evaluation -> Heart Specialist Management -> PAH clinics:
    public static final String SCLERODERMA = "chkSclero";
    public static final String SLE = "chkSLE";
    public static final String HIV = "chkHIV";
    public static final String PORTAL_HYPERTENSION = "chkFF";

    // Evaluation -> Heart Specialist Management -> PAH clinics -> Respiratory Disease/Hypoxia:
    public static final String RESPIRATORY_DISEASE_HYPOXIA = "chkRESP";
    public static final String AHI = "txtAHI";
    public static final String IPF_ILD = "chkILD";
    public static final String COPD = "chkCOPD";

    // Evaluation -> Heart Specialist Management -> PAH clinics:
    public static final String PVOD_PCH = "chkPVOD";
    public static final String SPLENECTOMY_SC = "chkSplen";
    public static final String FAMILIAL = "chkFamilial";
    public static final String CTEP = "chkCTEP";
    public static final String DRUGS_TOXINS = "chkDrugs";
    public static final String FEV1_PERCENT = "txtFEVP";
    public static final String DLCO = "txtDLCO";
    public static final String FEV1_LT = "txtFEV1";
    public static final String IC_TLC = "txtICTLC";
    public static final String TR_JET_VELOCITY = "txtTRJ";
    public static final String EXERCISE_RSVP = "txtERVSP";
    public static final String ADVANCED_ECHOCARDIOGRAPHY = "chkAD";
    public static final String CHECK_IF_LV_TD_DONE = "chkTD";
    public static final String CHECK_IF_RVOT_PW_DONE = "chkRVOT";
    public static final String CHECK_IF_TAPSE_DONE = "chkTPS";
    public static final String E_E_LESS_8 = "chkEsmaller8";
    public static final String SHORT_PAAT = "chkTei";
    public static final String TAPSE_LESS_2 = "chkTapse";
    public static final String E_E_8_16 = "chkE8to16";
    public static final String MIDSYS_NOTCH = "chkMidsystolic";
    public static final String E_E_MORE_16 = "chkEgreater16";

    // Evaluation -> Heart Specialist Management -> Valvular:
    public static final String VALVULAR = "secvalvular";

    // Evaluation -> Heart Specialist Management -> Valvular -> Valvular:

    public static final String LVEF_PAH = "txtLVEF";
    public static final String NEW_ONSET_ATRIAL_FIBRILATION = "chknewonsetAF";

    // Evaluation -> Heart Specialist Management -> Valvular -> Valvular -> Aortic Stenosis:
    public static final String AORTIC_STENOSIS = "chkAorticStenosis";
    public static final String CALCIFIED_AORTIC_VALVE_REDUCED_SYSTOLIC_OPENING = "chkCalcAortValve";
    public static final String RHEUMATIC_AV = "chkreumaticAV";
    public static final String CONGENITALLY_STENOTIC_AORTIC_VALVE = "chkCongenStenAortValve";
    public static final String CALCULATED_AORTIC_VALVE_AREA = "txtCalcAortValveArea";
    public static final String AORTIC_MEAN_PRESSURE_GRADIENT = "txtAortMeanPressGradient";
    public static final String AORTIC_VALVE_VALOCITY = "txtAortValveVel";
    public static final String STROKE_VOLUME_INDEX_SV_SBA = "txtStrokeVolIndex";
    public static final String INDEXED_VALVE_AREA_AVA_BSA = "txtIndexedValveArea";
    public static final String BISCUSPID_AORTIC_ROOT_DIAMETER = "txtAortRootDiameter";

    // Evaluation -> Heart Specialist Management -> Valvular -> Valvular -> Mitral Stenosis:
    public static final String MITRAL_STENOSIS = "chkMitralStenosis";
    public static final String MVA_CM_2 = "txtMVA";
    public static final String PHT_MSEC = "txtPHT";
    public static final String RHEUMATIC_MV_TV = "chkrheumaticMV";
    public static final String FAVORABLE_VALVE_MORPHOLOGY = "chkFavValveMorph";
    public static final String LA_CLOT = "chkLAClot";

    // Evaluation -> Heart Specialist Management -> Valvular -> Valvular -> Pulmonic Stenosis:
    public static final String PULMONIC_STENOSIS = "chkPulmonicStenosis";
    public static final String PULMONIC_VALVE_VELOCITY = "txtPulValveVel";

    // Evaluation -> Heart Specialist Management -> Valvular -> Valvular -> Aortic Regurgitation:
    public static final String AORTIC_REGURGITATION = "chkAorticRegurgitation";
    public static final String HOLODIASTOLIC_FLOW_REVERSAL = "chkHolodiastolicRev";
    public static final String VENA_CONTRACTA_WIDTH = "txtVenaContractaWidth2";
    public static final String VENA_CONTRACTA_WIDTH_TRI = "txtVenaContractaWidth";
    public static final String REGURGITANT_VOLUME_ML_BEAT = "txtRegurVolume";
    public static final String REGURGITANT_FRACTION = "txtRegurFrac";
    public static final String ERO = "txtERO";
    public static final String LVESD_MM = "txtLVESd";
    public static final String LVEDD_MM = "txtLVEDd";
    public static final String AORTIC_ROOT_DIAMETER = "txtAorticRootDiameter";

    // Evaluation -> Heart Specialist Management -> Valvular -> Valvular -> Primary Mitral Regurgitation:
    public static final String PRIMARY_MITRAL_REGURGITATION = "chkMitralRegurgitation";

    // Evaluation -> Heart Specialist Management -> Valvular -> Valvular -> Tricuspid Regurgitation:
    public static final String TRICUSPID_REGURGITATION = "chkTricuspidRegurgitation";
    public static final String ANNULAR_DIAMETER = "txtAnnularDiameter";
    public static final String CENTRAL_JET_AREA_CM_2 = "txtCentralJetArea";
    public static final String HEPATIC_VEIN_FLOW_REVERSAL = "chkHepaticVeinFlowRev";
    public static final String ABNORMAL_TV_LEAFLETS = "chkabTVleaflet";

    // Evaluation -> Heart Specialist Management -> Valvular -> Valvular -> Pulmonic Regurgitation:
    public static final String PULMONIC_REGURGITATION = "chkPulmonicRegurgitation";
    public static final String WIDE_REGURFITANT_JET = "chkWideRegurJet";
    public static final String ABNORMAL_PULMONIC_VALVE_LEAFLETS = "chkabnpulval";

    // Evaluation -> Heart Specialist Management -> Valvular -> Valvular Surgery Risk:
    public static final String VALVULAR_SURGERY_RISK = "secvalvular_surgery_risk";
    public static final String LOW = "chklowrisk";
    public static final String INTERMEDIATE = "chkintermediaterisk";
    public static final String HIGH = "chkhighrisk";
    public static final String PROHIBITIVE = "chkprohibitive";

    // Evaluation -> Heart Specialist Management -> Valvular -> Other Surgical Risk:
    public static final String OTHER_SURGICAL_RISK = "secother_surgical_risk";
    public static final String HIGH_RISK_SUPRA_INGUINAL_VASCULAR_SURGERY = "chkvascular";
    public static final String LOW_RISK_CATARACT_PLASTIC = "chklowriskelec";
    public static final String OTHER_CARDIAC = "chkcardiac";

    // Evaluation -> Heart Specialist Management -> Advanced LHF:
    public static final String ADVANCED_LHF = "secadvanced_lhf";

    // Evaluation -> Heart Specialist Management -> Advanced LHF -> Heart Failure -> Heart Failure Duration:
    public static final String HEART_FAILURE_DURATION = "secheart_failure_duration";
    public static final String HEART_FAILURE_DURATION_WEEK = "txtdur";
    public static final String HFPLVF = "chkHFPLVF";
    public static final String FAILED_OUTPUT_RX = "chkfoutpt";

    // Evaluation -> Heart Specialist Management -> Advanced LHF -> Heart Failure -> Clinics:
    public static final String CLINICS = "secclinics";
    public static final String CARDIO_SHOCK = "chkshock";
    public static final String DYSPNEA_AT_REST_MORE_2_HRS_AFTER_RX = "chkdysp";

    // Evaluation -> Heart Specialist Management -> Advanced LHF -> Heart Failure -> Etiology:
    public static final String ETIOLOGY = "secEtiology";
    public static final String DCM = "chkNonischemicCMP";
    public static final String FAMILY_HISTORY_OF_SUDDEN_DEATH = "chkFamHistSuddenDeath";
    public static final String ISCHEMIC = "chkIschemic";
    public static final String FAMILIAL_CMP_ASSOCIATED_SUDDEN_DEATH = "chkFamHXofCMP";
    public static final String VALVULAR_HEART_DISEASE_SEC = "chkvalvularHD";
    public static final String MI_MORE_45_DAYS = "chkMI";

    // Evaluation -> Heart Specialist Management -> Advanced LHF -> Heart Failure -> Stage/Class:
    public static final String STAGE_CLASS = "secstage_class";
    public static final String FREQUENT_HOSPITAL_ADMISSIONS = "chkfrequent";

    // Evaluation -> Heart Specialist Management -> Advanced LHF -> Heart Failure -> Arrthymias:
    public static final String ARRTHYMIAS = "secarrthymias";
    public static final String AV_NODE_DISEASE = "chkAVNodeDisease";
    public static final String SINUS_NODE_DYSFUNCTION = "chkSinusNodeDysfunction";

    // Evaluation -> Heart Specialist Management -> Advanced LHF -> Heart Failure -> Home Therapeutics:
    public static final String HOME_THERAPEUTICS = "sechome_therapeutics";

    // Evaluation -> Heart Specialist Management -> Advanced LHF -> Heart Failure -> Therapeutics:
    public static final String THERAPEUTICS = "sectherapeutics";
    public static final String ON_MAX_TOLERATED_B_BLOCKER = "chkcara";
    public static final String ON_MAX_TOLERATED_ACE_IARB = "chkacea";
    public static final String CHRONIC_INOTROPE_DEPENDENCE = "chkCID";
    public static final String INTERMITTENT_INOTROPE_DEPENDENCE = "chkIID";

    // Evaluation -> Heart Specialist Management -> Advanced LHF -> Laboratories:
    public static final String NEW_ONSET_HEART_FAILURE_INITIAL_EVALUATION = "chknewHF";
    public static final String INR_PAH = "txtPTINR";
    public static final String PLATELETS_K_ML = "txtplatelet";
    public static final String ALBUMIN_G_DL = "txtalbumin";
    public static final String AST_U_ML = "txtAST";
    public static final String BUN_U_DL = "txtBUN";
    public static final String HEMATOCRIT = "txthematocrit";

    // Evaluation -> Heart Specialist Management -> RHC:
    public static final String MEAN_PAP_MMHG = "txtMPAP";
    public static final String PVR_WU = "txtPVR";
    public static final String LVEDP_MMHG = "txtLVEDP";
    public static final String PCWP_MMGH = "txtPCWP";
    public static final String CL_LT_MIN_SQ = "txtCI";
    public static final String RA_PRESSURE_MMHG = "txtRAP";
    public static final String V_WAVE_AMPLITUDE = "txtVWA";
    public static final String NO_V_WAVE = "chkVWA";
    public static final String PADP_MMHG = "txtPADP";
    public static final String RVEDP_MMGH = "txtRVEDP";
    public static final String SVR_WU = "txtSVR";


    //
    // Main
    //
    public static final String NEXT_SECTION_ID = "secnext_section_id";

    public static final String NEXT_SECTION_HOME_SCREEN = "secnext_section_home";
    public static final String NEXT_SECTION_ABOUT = "secnext_section_about";
    public static final String NEXT_SECTION_HEART_SPECIALIST = "secnext_section_heart_specialist";

    public static final String TAB_SECTION_LIST = "sectab_section_list";
    public static final String ACTION_CHANGE_SIZE = "secaction_change_size";
    public static final String SIZE = "text_size";

    public static final String NEXT_SECTION_EVALUATION_ITEMS = "secnext_section_evaluation_items";

    public static final String SYNCHEST_PAIN = "chkSynProCP";

    public static final String BACKPAIN = "sectionbackpain";

    public static final String EVALUATION = "secevaluation";
    public static final String ABOUT = "secabout";
    public static final String TERMS_OF_USE = "secabout_secterms_of_use";
    public static final String TERMS_OF_USE_TEXT = "secterms_of_use_text";
    public static final String PRIVACY_POLICY = "secabout_secprivacy_policy";
    public static final String HELP_SUPPORT = "secabout_sechelp_support";
    public static final String DEVELOPMENT = "secdevelopment";
    public static final String ENGINEERING = "secengineering";
    public static final String DESIGN = "secdesign";
    public static final String VERSION_CAPS = "secversion_caps";
    public static final String LOGIC = "seclogic";
    public static final String VERSION = "secversion";

    public static final String DURATION = "secduration";

    public static final String ASSESSMENT = "secassessment";

    /*public static final String PERIOPERATIVE = "perioperative";
    public static final String MINOR_PROCEDURE = "minor_procedure";
    public static final String SURGERY_INVASIVE_PROCEDURE = "surgery_invasive_procedure";
    public static final String EMERGENCY_SURGERY_MAJOR_BLEED = "emergency_surgery_major_bleed";*/
    public static final String COMPUTE_EVALUATION = "seccompute_evaluation";
    public static final String PAH_COMPUTE_EVALUATION = "sec_pah_compute_evaluation";
    public static final String OVERVIEW = "secoverview";
    public static final String REFERENCES = "secreferences";
    public static final String NO_INFO_AVAILABLE = "secno_info_available";
    public static final String ACS = "chkACS";
    public static final String CHD = "chkCHD";
    public static final String BMI_KG_M = "txtWaist";
    public static final String SAH = "chkSAH";
    public static final String AF_SVT = "chkAF";
    public static final String DM = "chkDM";
    public static final String TRICUSPID_STENOSIS = "chkTricuspidStenosis";
    public static final String ENLARGED_LA = "chkEnlargedLA";
    public static final String ON_SET_OF_HEART_FAILURE = "date_on_set_of_heart_failure";
    public static final String LABORATORY_EKG = "seclaboratory_ekg";

    public static final String ON_SET_HEART_FAILURE_MONTH = "txtHearthFailureMonth";
    public static final String ON_SET_HEART_FAILURE_YEAR = "txtHearthFailureYear";
    public static final String EVALUATION_ID = "evaluationID";
}
