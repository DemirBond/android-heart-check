package com.szg_tech.heartcheck.entities.evaluation_items;

import android.content.Context;

import com.szg_tech.heartcheck.R;
import static com.szg_tech.heartcheck.core.ConfigurationParams.*;
import com.szg_tech.heartcheck.entities.EvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.BooleanEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionCheckboxEvaluationItem;
import com.szg_tech.heartcheck.entities.evaluation_item_elements.SectionEvaluationItem;

import java.util.ArrayList;

class POMeds extends SectionEvaluationItem {
    POMeds(Context context) {
        super(context, PO_MEDS, null);
        name = getString(R.string.po_meds);
        this.evaluationItemList = createEvaluationItemElementsList();
        sectionElementState = SectionElementState.OPENED;
    }

    private ArrayList<EvaluationItem> createEvaluationItemElementsList() {
        return new ArrayList<EvaluationItem>() {
            {
                add(new SectionCheckboxEvaluationItem(B_BLOCKER, getString(R.string.b_blocker), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(CARVEDILOL_3125BID, getString(R.string.carvedilol_3125bid)));
                        add(new BooleanEvaluationItem(CARVEDILOL_625BID, "chkCarvedilol625"));
                        add(new BooleanEvaluationItem(CARVEDILOL_125BID, getString(R.string.carvedilol_125bid)));
                        add(new BooleanEvaluationItem(CARVEDILOL_25BID, getString(R.string.carvedilol_25bid)));
                        add(new BooleanEvaluationItem(METOPROLOLER_25_QD, getString(R.string.metoprololer_25_qd)));
                        add(new BooleanEvaluationItem(METOPROLOLER_50_QD, getString(R.string.metoprololer_50_qd)));
                        add(new BooleanEvaluationItem(METOPROLOLER_100_QD, getString(R.string.metoprololer_100_qd)));
                        add(new BooleanEvaluationItem(METOPROLOLER_150_QD, getString(R.string.metoprololer_150_qd)));
                        add(new BooleanEvaluationItem(METOPROLOLER_200_QD, getString(R.string.metoprololer_200_qd)));
                    }
                }));

                add(new SectionCheckboxEvaluationItem(ACEL_ARB, "Ace I/ ARB", new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(LISINOPRIL_5QD, "Lisinopril 5 qd"));
                        add(new BooleanEvaluationItem(LISINOPRIL_10QD, "Lisinopril 10-20 qd"));
                        add(new BooleanEvaluationItem(LISINOPRIL_20QD, "Lisinopril 30-40 qd"));
                        add(new BooleanEvaluationItem(LOSARTAN_25QD,  "Losartan 25 qd"));
                        add(new BooleanEvaluationItem(LOSARTAN_50QD,  "Losartan 50 qd"));
                        add(new BooleanEvaluationItem(LOSARTAN_100QD, "Losartan 100 qd"));
                    }
                }));
                add(new SectionCheckboxEvaluationItem(PO_DIURETIC, getString(R.string.po_diuretic), new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(FUROSEMIDE_40, getString(R.string.furosemide_40)));
                        add(new BooleanEvaluationItem(FUROSEMIDE_80, getString(R.string.furosemide_80)));
                        add(new BooleanEvaluationItem(FUROSEMIDE_80_PLUS, getString(R.string.furosemide_80_plus)));
                        add(new BooleanEvaluationItem(BURNEX_1, getString(R.string.burnex_1)));
                        add(new BooleanEvaluationItem(BURNEX_2, getString(R.string.burnex_2)));
                        add(new BooleanEvaluationItem(BURNEX_2_PLUS, getString(R.string.burnex_2_plus)));
                        add(new BooleanEvaluationItem(TORSEMIDE_20, getString(R.string.torsemide_20)));
                        add(new BooleanEvaluationItem(TORSEMIDE_40, getString(R.string.torsemide_40)));
                        add(new BooleanEvaluationItem(TORSEMIDE_50_PLUS, getString(R.string.torsemide_50_plus)));
                        add(new BooleanEvaluationItem(HCTZ, getString(R.string.hctz)));
                        add(new BooleanEvaluationItem(INDAPAMIDE, getString(R.string.indapamide)));
                        add(new BooleanEvaluationItem(CHLORTHALIDONE_METOLAZONE, getString(R.string.chlorthalidone_metolazone)));
                        add(new BooleanEvaluationItem(SPIROLACTONE, "Spirolactone"));
                    }
                }));

                add(new SectionCheckboxEvaluationItem(CCB, "CCB", new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(DIHYDROPYRIDINE, "Dihydropyridine"));
                        add(new BooleanEvaluationItem(NONDIHYDROPYRIDINE, "Nitrates"));

                    }
                }));
                add(new SectionCheckboxEvaluationItem(VASODILATOR, "Vasodilators", new ArrayList<EvaluationItem>() {
                    {
                        add(new BooleanEvaluationItem(HYDRALAZINE, "Hydralazine"));
                        add(new BooleanEvaluationItem(NITRATE, "Nitrates"));

                    }
                }));
                add(new BooleanEvaluationItem(CURRENT_VKA_THERAPY, getString(R.string.current_vka_therapy)));
                add(new BooleanEvaluationItem(DIRECT_THROMBIN_INHIBITORS, getString(R.string.direct_thrombin_inhibitors)));
                add(new BooleanEvaluationItem(FACTOR_XA_INHIBITORS, getString(R.string.factor_xa_inhibitors)));
            }
        };
    }
}
