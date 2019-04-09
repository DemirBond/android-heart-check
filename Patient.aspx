
<%@ Page Language="C#" MasterPageFile="~/MasterPage1.master" AutoEventWireup="false" CodeFile="Patient.aspx.cs" Inherits="Patient" title="Patient Entry" %>
<%@ Register Assembly="AjaxControlToolkit" Namespace="AjaxControlToolkit" TagPrefix="cc1" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">

    <script type="text/javascript">
$(document).ready(function(){
    $("#lblHeartFailure").hover(function() {
        if (tabHF.style.display == "none")
            $("#tempHF").fadeIn(50,"linear");
    }, function() {
        $("#tempHF").fadeOut(50,"linear");
    });
})

function HF() {
    if (tabHF.style.display == "none") {
        $("#tabHF").fadeIn(250, "linear");
        $("#tabSyncope").fadeOut(250, "linear");
        $("#tabChestPain").fadeOut(250, "linear");
        $("#tabedema").fadeOut(250, "linear");
        $("#tabweakness").fadeOut(250, "linear");
        $("#tababdominalpain").fadeOut(250, "linear");
        $("#tabpalpitations").fadeOut(250, "linear");
        $("#tabshock").fadeOut(250, "linear");
       
        lblHeartFailure.className = "flag tabStill"
        lblSyncope.className = "flag tabActive"
        lblChestPain.className = "flag tabActive"
        lbledema.className = "flag tabActive"
        lblweakness.className = "flag tabActive"
        lblabdominalpain.className = "flag tabActive"
        lblpalpitations.className = "flag tabActive"
        lblshock.className = "flag tabActive"
        
    }
}

function Syncope() {
    if (tabSyncope.style.display == "none") {
        $("#tabHF").fadeOut(250, "linear");
        $("#tabSyncope").fadeIn(250, "linear");
        $("#tabChestPain").fadeOut(250, "linear");
        $("#tabedema").fadeOut(250, "linear");
        $("#tabweakness").fadeOut(250, "linear");
        $("#tababdominalpain").fadeOut(250, "linear");
        $("#tabpalpitations").fadeOut(250, "linear");
        $("#tabshock").fadeOut(250, "linear");
    
        lblHeartFailure.className = "flag tabActive"
        lblSyncope.className = "flag tabStill"
        lblChestPain.className = "flag tabActive"
        lbledema.className = "flag tabActive"
        lblweakness.className = "flag tabActive"
        lblabdominalpain.className = "flag tabActive"
        lblpalpitations.className = "flag tabActive"
        lblshock.className = "flag tabActive"
       
    }
}

function ChestPain() {
    if (tabChestPain.style.display == "none") {
        $("#tabHF").fadeOut(250, "linear");
        $("#tabSyncope").fadeOut(250, "linear");
        $("#tabChestPain").fadeIn(250, "linear");
        $("#tabedema").fadeOut(250, "linear");
        $("#tabweakness").fadeOut(250, "linear");
        $("#tababdominalpain").fadeOut(250, "linear");
        $("#tabpalpitations").fadeOut(250, "linear");
        $("#tabshock").fadeOut(250, "linear");
      
        lblHeartFailure.className = "flag tabActive"
        lblSyncope.className = "flag tabActive"
        lblChestPain.className = "flag tabStill"
        lbledema.className = "flag tabActive"
        lblweakness.className = "flag tabActive"
        lblabdominalpain.className = "flag tabActive"
        lblpalpitations.className = "flag tabActive"
        lblshock.className = "flag tabActive"
        
    }
}
function edema() {
    if (tabedema.style.display == "none") {
        $("#tabHF").fadeOut(250, "linear");
        $("#tabSyncope").fadeOut(250, "linear");
        $("#tabChestPain").fadeOut(250, "linear");
        $("#tabedema").fadeIn(250, "linear");
        $("#tabweakness").fadeOut(250, "linear");
        $("#tababdominalpain").fadeOut(250, "linear");
        $("#tabshock").fadeOut(250, "linear");
        $("#tabpalpitations").fadeOut(250, "linear");
       
        lblHeartFailure.className = "flag tabActive"
        lblSyncope.className = "flag tabActive"
        lblChestPain.className = "flag tabActive"
        lbledema.className = "flag tabStill"
        lblweakness.className = "flag tabActive"
        lblabdominalpain.className = "flag tabActive"
        lblpalpitations.className = "flag tabActive"
        lblshock.className = "flag tabActive"
        
    }
}

function weakness() {
    if (tabweakness.style.display == "none") {
        $("#tabHF").fadeOut(250, "linear");
        $("#tabSyncope").fadeOut(250, "linear");
        $("#tabChestPain").fadeOut(250, "linear");
        $("#tabedema").fadeOut(250, "linear");
        $("#tabweakness").fadeIn(250, "linear");
        $("#tababdominalpain").fadeOut(250, "linear");
        $("#tabpalpitations").fadeOut(250, "linear");
        $("#tabshock").fadeOut(250, "linear");
        
        lblHeartFailure.className = "flag tabActive"
        lblSyncope.className = "flag tabActive"
        lblChestPain.className = "flag tabActive"
        lbledema.className = "flag tabActive"
        lblweakness.className = "flag tabStill"
        lblabdominalpain.className = "flag tabActive"
        lblpalpitations.className = "flag tabActive"
        lblshock.className = "flag tabActive"
      
    }
}

function abdominalpain() {
    if (tababdominalpain.style.display == "none") {
        $("#tabHF").fadeOut(250, "linear");
        $("#tabSyncope").fadeOut(250, "linear");
        $("#tabChestPain").fadeOut(250, "linear");
        $("#tabedema").fadeOut(250, "linear");
        $("#tabweakness").fadeOut(250, "linear");
        $("#tababdominalpain").fadeIn(250, "linear");
        $("#tabpalpitations").fadeOut(250, "linear");
        $("#tabshock").fadeOut(250, "linear");
       
        lblHeartFailure.className = "flag tabActive"
        lblSyncope.className = "flag tabActive"
        lblChestPain.className = "flag tabActive"
        lbledema.className = "flag tabActive"
        lblweakness.className = "flag tabActive"
        lblabdominalpain.className = "flag tabStill"
        lblpalpitations.className = "flag tabActive"
        lblshock.className = "flag tabActive"
        
    }
}

function palpitations() {
    if (tabpalpitations.style.display == "none") {
        $("#tabHF").fadeOut(250, "linear");
        $("#tabSyncope").fadeOut(250, "linear");
        $("#tabChestPain").fadeOut(250, "linear");
        $("#tabedema").fadeOut(250, "linear");
        $("#tabweakness").fadeOut(250, "linear");
        $("#tababdominalpain").fadeOut(250, "linear");
        $("#tabpalpitations").fadeIn(250, "linear");
        $("#tabshock").fadeOut(250, "linear");
       
        lblHeartFailure.className = "flag tabActive"
        lblSyncope.className = "flag tabActive"
        lblChestPain.className = "flag tabActive"
        lbledema.className = "flag tabActive"
        lblweakness.className = "flag tabActive"
        lblabdominalpain.className = "flag tabActive"
        lblpalpitations.className = "flag tabStill"
        lblshock.className = "flag tabActive"
       
    }
}

function shock() {
    if (tabshock.style.display == "none") {
        $("#tabHF").fadeOut(250, "linear");
        $("#tabSyncope").fadeOut(250, "linear");
        $("#tabChestPain").fadeOut(250, "linear");
        $("#tabedema").fadeOut(250, "linear");
        $("#tabweakness").fadeOut(250, "linear");
        $("#tababdominalpain").fadeOut(250, "linear");
        $("#tabpalpitations").fadeOut(250, "linear");
        $("#tabshock").fadeIn(250, "linear");
       
        lblHeartFailure.className = "flag tabActive"
        lblSyncope.className = "flag tabActive"
        lblChestPain.className = "flag tabActive"
        lbledema.className = "flag tabActive"
        lblweakness.className = "flag tabActive"
        lblabdominalpain.className = "flag tabActive"
        lblpalpitations.className = "flag tabActive"
        lblshock.className = "flag tabStill"
       
    }
}


function ROS() {
    if (tabROS.style.display == "none") {
        $("#tabHandP").fadeOut(250, "linear");
        $("#tabHomeMeds").fadeOut(250, "linear");
        $("#tabHospitalMeds").fadeOut(250, "linear");
        $("#tabLaboratories").fadeOut(250, "linear");
        $("#tabDiagnostics").fadeOut(250, "linear");
        $("#tabROS").fadeIn(250, "linear");
        lblHandP.className = "flag tabActive"
        lblHometherapeutics.className = "flag tabActive"
        lblHospitaltherapeutics.className = "flag tabActive"
        lblLaboratories.className = "flag tabActive"
        lblDiagnostics.className = "flag tabActive"
        lblROS.className = "flag tabStill"
    }
}
function HandP() {
    if (tabHandP.style.display == "none") {
        $("#tabHandP").fadeIn(250, "linear");
        $("#tabHomeMeds").fadeOut(250, "linear");
        $("#tabHospitalMeds").fadeOut(250, "linear");
        $("#tabLaboratories").fadeOut(250, "linear");
        $("#tabDiagnostics").fadeOut(250, "linear");
        $("#tabROS").fadeOut(250, "linear");
        lblHandP.className = "flag tabStill"
        lblHometherapeutics.className = "flag tabActive"
        lblHospitaltherapeutics.className = "flag tabActive"
        lblLaboratories.className = "flag tabActive"
        lblDiagnostics.className = "flag tabActive"
        lblROS.className = "flag tabActive"
    }
}

function HomeMeds() {
    if (tabHomeMeds.style.display == "none") {
        $("#tabHandP").fadeOut(250, "linear");
        $("#tabHomeMeds").fadeIn(250, "linear");
        $("#tabHospitaltherapeutics").fadeOut(250, "linear");
        $("#tabLaboratories").fadeOut(250, "linear");
        $("#tabDiagnostics").fadeOut(250, "linear");
        $("#tabROS").fadeOut(250, "linear");
        lblHandP.className = "flag tabActive"
        lblHometherapeutics.className = "flag tabStill"
        lblHospitaltherapeutics.className = "flag tabActive"
        lblLaboratories.className = "flag tabActive"
        lblDiagnostics.className = "flag tabActive"
        lblROS.className = "flag tabActive"
    }
}
function Hospitaltherapeutics() {
    if (tabHospitaltherapeutics.style.display == "none") {
        $("#tabHandP").fadeOut(250, "linear");
        $("#tabHomeMeds").fadeOut(250, "linear");
        $("#tabHospitaltherapeutics").fadeIn(250, "linear");
        $("#tabLaboratories").fadeOut(250, "linear");
        $("#tabDiagnostics").fadeOut(250, "linear");
        $("#tabROS").fadeOut(250, "linear");
        lblHandP.className = "flag tabActive"
        lblHometherapeutics.className = "flag tabActive"
        lblHospitaltherapeutics.className = "flag tabStill"
        lblLaboratories.className = "flag tabActive"
        lblDiagnostics.className = "flag tabActive"
        lblROS.className = "flag tabActive"
    }
}
function Laboratories() {
    if (tabLaboratories.style.display == "none") {
        $("#tabHandP").fadeOut(250, "linear");
        $("#tabHomeMeds").fadeOut(250, "linear");
        $("#tabHospitaltherapeutics").fadeOut(250, "linear");
        $("#tabLaboratories").fadeIn(250, "linear");
        $("#tabDiagnostics").fadeOut(250, "linear");
        $("#tabROS").fadeOut(250, "linear");
        lblHandP.className = "flag tabActive"
        lblHometherapeutics.className = "flag tabActive"
        lblHospitaltherapeutics.className = "flag tabActive"
        lblLaboratories.className = "flag tabStill"
        lblDiagnostics.className = "flag tabActive"
        lblROS.className = "flag tabActive"
    }
}

function Diagnostics() {
    if (tabDiagnostics.style.display == "none") {
        $("#tabHandP").fadeOut(250, "linear");
        $("#tabHomeMeds").fadeOut(250, "linear");
        $("#tabHospitaltherapeutics").fadeOut(250, "linear");
        $("#tabLaboratories").fadeOut(250, "linear");
        $("#tabDiagnostics").fadeIn(250, "linear");
        $("#tabROS").fadeOut(250, "linear");
        lblHandP.className = "flag tabActive"
        lblHometherapeutics.className = "flag tabActive"
        lblHospitaltherapeutics.className = "flag tabActive"
        lblLaboratories.className = "flag tabActive"
        lblDiagnostics.className = "flag tabStill"
        lblROS.className = "flag tabActive"
    }
}
function EKG(value) {
    if (value == true)
        $("#<%=pnlEKG.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlEKG.ClientID%>").fadeOut(250, "linear");
}

function Echo(value) {
    if (value == true)
        $("#<%=pnlEcho.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlEcho.ClientID%>").fadeOut(250, "linear");
}

function chestxray(value) {
    if (value == true)
        $("#<%=pnlchestxray.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlchestxray.ClientID%>").fadeOut(250, "linear");
}
function HRCT(value) {
    if (value == true)
        $("#<%=pnlHRCT.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlHRCT.ClientID%>").fadeOut(250, "linear");
}
function LBBB(value) {
    if (value == true)
        $("#<%=pnlLBBB.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlLBBB.ClientID%>").fadeOut(250, "linear");
}

function SwitchToPAH(value) {
    if (value == true) {
        swal({   title: "Refer to Heart Failure Specialist for Advanced Heart Failure Management",   
        text: "",   
        type: "warning",   
        showCancelButton: true,   
        confirmButtonColor: "#DD6B55",   
        confirmButtonText: "Yes",   
        cancelButtonText: "No", 
        closeOnConfirm: false }, 
        function(){ document.getElementById("<%=btnSwitchtoPAH.ClientID%>").click();  });
    } 
}

function DTS(value) {
    if (value == true)
        $("#<%=pnlDTS.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlDTS.ClientID%>").fadeOut(250, "linear");
}


function CHD() {
    if (tabCHD.style.display == "none")
    {
        $("#tabCHD").fadeIn(250, "linear");
        $("#tabHfailure").fadeOut (250, "linear");
        $("#tabAF").fadeOut(250, "linear");
        $("#tabThrombo").fadeOut(250, "linear");
        $("#tabValvular").fadeOut(250, "linear");
        $("#tabVentricular").fadeOut(250, "linear");
        $("#tabBrady").fadeOut(250, "linear");
        $("#tabSurgical").fadeOut(250, "linear");
        lblCHD.className = "flag tabStill"
        lblHfailure.className = "flag tabActive"
        lblAF.className = "flag tabActive"
        lblThrombo.className = "flag tabActive"
        lblValvular.className = "flag tabActive"
        lblVentricular.className = "flag tabActive"
        lblBrady.className = "flag tabActive"
        lblSurgRisk.className = "flag tabActive"
    }
}
function Hfailure() {
    if (tabHfailure.style.display == "none")
    {
        $("#tabCHD").fadeOut(250, "linear");
        $("#tabHfailure").fadeIn(250, "linear");
        $("#tabAF").fadeOut(250, "linear");
        $("#tabThrombo").fadeOut(250, "linear");
        $("#tabValvular").fadeOut(250, "linear");
        $("#tabVentricular").fadeOut(250, "linear");
        $("#tabBrady").fadeOut(250, "linear");
        $("#tabSurgical").fadeOut(250, "linear");
        lblCHD.className = "flag tabActive"
        lblHfailure.className = "flag tabStill"
        lblAF.className = "flag tabActive"
        lblThrombo.className = "flag tabActive"
        lblValvular.className = "flag tabActive"
        lblVentricular.className = "flag tabActive"
        lblBrady.className = "flag tabActive"
        lblSurgRisk.className = "flag tabActive"
    }
}
function AF() {
    if (tabAF.style.display == "none")
    {
        $("#tabCHD").fadeOut(250, "linear");
        $("#tabHfailure").fadeOut(250, "linear");
        $("#tabAF").fadeIn(250, "linear");
        $("#tabThrombo").fadeOut(250, "linear");
        $("#tabValvular").fadeOut(250, "linear");
        $("#tabVentricular").fadeOut(250, "linear");
        $("#tabBrady").fadeOut(250, "linear");
        $("#tabSurgical").fadeOut(250, "linear");
        lblCHD.className = "flag tabActive"
        lblHfailure.className = "flag tabActive"
        lblAF.className = "flag tabStill"
        lblThrombo.className = "flag tabActive"
        lblValvular.className = "flag tabActive"
        lblVentricular.className = "flag tabActive"
        lblBrady.className = "flag tabActive"
        lblSurgRisk.className = "flag tabActive"
    }
}

function Thrombo() {
    if (tabThrombo.style.display == "none")
    {
        $("#tabCHD").fadeOut(250, "linear");
        $("#tabHfailure").fadeOut(250, "linear");
        $("#tabAF").fadeOut(250, "linear");
        $("#tabThrombo").fadeIn(250, "linear");
        $("#tabValvular").fadeOut(250, "linear");
        $("#tabVentricular").fadeOut(250, "linear");
        $("#tabBrady").fadeOut(250, "linear");
        $("#tabSurgical").fadeOut(250, "linear");
        lblCHD.className = "flag tabActive"
        lblHfailure.className = "flag tabActive"
        lblAF.className = "flag tabActive"
        lblThrombo.className = "flag tabStill"
        lblValvular.className = "flag tabActive"
        lblVentricular.className = "flag tabActive"
        lblBrady.className = "flag tabActive"
        lblSurgRisk.className = "flag tabActive"
    }
}

function Valvular() {
    if (tabValvular.style.display == "none") {
        $("#tabCHD").fadeOut(250, "linear");
        $("#tabHfailure").fadeOut(250, "linear");
        $("#tabAF").fadeOut(250, "linear");
        $("#tabThrombo").fadeOut(250, "linear");
        $("#tabValvular").fadeIn(250, "linear");
        $("#tabVentricular").fadeOut(250, "linear");
        $("#tabBrady").fadeOut(250, "linear");
        $("#tabSurgical").fadeOut(250, "linear");
        lblCHD.className = "flag tabActive"
        lblHfailure.className = "flag tabActive"
        lblAF.className = "flag tabActive"
        lblThrombo.className = "flag tabActive"
        lblValvular.className = "flag tabStill"
        lblVentricular.className = "flag tabActive"
        lblBrady.className = "flag tabActive"
        lblSurgRisk.className = "flag tabActive"
    }
}

function Ventricular() {
    if (tabVentricular.style.display == "none")
    {
        $("#tabCHD").fadeOut(250, "linear");
        $("#tabHfailure").fadeOut(250, "linear");
        $("#tabAF").fadeOut(250, "linear");
        $("#tabThrombo").fadeOut(250, "linear");
        $("#tabValvular").fadeOut(250, "linear");
        $("#tabVentricular").fadeIn(250, "linear");
        $("#tabBrady").fadeOut(250, "linear");
        $("#tabSurgical").fadeOut(250, "linear");
        lblCHD.className = "flag tabActive"
        lblHfailure.className = "flag tabActive"
        lblAF.className = "flag tabActive"
        lblThrombo.className = "flag tabActive"
        lblValvular.className = "flag tabActive"
        lblVentricular.className = "flag tabStill"
        lblBrady.className = "flag tabActive"
        lblSurgRisk.className = "flag tabActive"
    }
}
function Brady() {
    if (tabBrady.style.display == "none")
    {
        $("#tabCHD").fadeOut(250, "linear");
        $("#tabHfailure").fadeOut(250, "linear");
        $("#tabAF").fadeOut(250, "linear");
        $("#tabThrombo").fadeOut(250, "linear");
        $("#tabValvular").fadeOut(250, "linear");
        $("#tabVentricular").fadeOut(250, "linear");
        $("#tabBrady").fadeIn(250, "linear");
        $("#tabSurgical").fadeOut(250, "linear");
        lblCHD.className = "flag tabActive"
        lblHfailure.className = "flag tabActive"
        lblAF.className = "flag tabActive"
        lblThrombo.className = "flag tabActive"
        lblValvular.className = "flag tabActive"
        lblVentricular.className = "flag tabActive"
        lblBrady.className = "flag tabStill"
        lblSurgRisk.className = "flag tabActive"
    }
}
function SurgRisk() {
    if (tabSurgical.style.display == "none") {
        $("#tabCHD").fadeOut(250, "linear");
        $("#tabHfailure").fadeOut(250, "linear");
        $("#tabAF").fadeOut(250, "linear");
        $("#tabThrombo").fadeOut(250, "linear");
        $("#tabValvular").fadeOut(250, "linear");
        $("#tabVentricular").fadeOut(250, "linear");
        $("#tabBrady").fadeOut(250, "linear");
        $("#tabSurgical").fadeIn(250, "linear");
        lblCHD.className = "flag tabActive"
        lblHfailure.className = "flag tabActive"
        lblAF.className = "flag tabActive"
        lblThrombo.className = "flag tabActive"
        lblValvular.className = "flag tabActive"
        lblVentricular.className = "flag tabActive"
        lblBrady.className = "flag tabActive"
        lblSurgRisk.className = "flag tabStill"
    }
}

function PostMI(value) {
    if (value == true)
        $("#<%=pnlPostMI.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlPostMI.ClientID%>").fadeOut(250, "linear");
}

function IschemicCMP(value) {
    if (value == true)
        $("#<%=pnlIschemicCMP.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlIschemicCMP.ClientID%>").fadeOut(250, "linear");
}
function DOE(value) {
    if (value == true) {
        $("#<%=PanelDOE.ClientID%>").fadeIn(250, "linear");
        $("label[for='<%=Chkorthopnea.ClientID%>']").addClass("highlighted");
        $("label[for='<%=ChkOSA.ClientID%>']").addClass("highlighted");
        $("label[for='<%=chkweightgain.ClientID%>']").addClass("highlighted");
        $("label[for='<%=ChkJVD.ClientID%>']").addClass("highlighted");
        $("label[for='<%=ChkS3.ClientID%>']").addClass("highlighted");
        $("label[for='<%=ChkS4.ClientID%>']").addClass("highlighted");
    }
    else {
        $("#<%=PanelDOE.ClientID%>").fadeOut(250, "linear");
        $("label[for='<%=Chkorthopnea.ClientID%>']").removeClass("highlighted");
        $("label[for='<%=ChkOSA.ClientID%>']").removeClass("highlighted");
        $("label[for='<%=chkweightgain.ClientID%>']").removeClass("highlighted");
        $("label[for='<%=ChkJVD.ClientID%>']").removeClass("highlighted");
        $("label[for='<%=ChkS3.ClientID%>']").removeClass("highlighted");
        $("label[for='<%=ChkS4.ClientID%>']").removeClass("highlighted");
    }
}
function DAR(value) {
    if (value == true) {
        $("label[for='<%=Chkorthopnea.ClientID%>']").addClass("highlighted");
        $("label[for='<%=ChkOSA.ClientID%>']").addClass("highlighted");
        $("label[for='<%=chkweightgain.ClientID%>']").addClass("highlighted");
        $("label[for='<%=ChkJVD.ClientID%>']").addClass("highlighted");
        $("label[for='<%=ChkS3.ClientID%>']").addClass("highlighted");
        $("label[for='<%=ChkS4.ClientID%>']").addClass("highlighted");
    }
    else {
        $("label[for='<%=Chkorthopnea.ClientID%>']").removeClass("highlighted");
        $("label[for='<%=ChkOSA.ClientID%>']").removeClass("highlighted");
        $("label[for='<%=chkweightgain.ClientID%>']").removeClass("highlighted");
        $("label[for='<%=ChkJVD.ClientID%>']").removeClass("highlighted");
        $("label[for='<%=ChkS3.ClientID%>']").removeClass("highlighted");
        $("label[for='<%=ChkS4.ClientID%>']").removeClass("highlighted");
    }
}
 function tachycardic(value) {
    if (value == true)
        $("#<%=Paneltachycardic.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=Paneltachycardic.ClientID%>").fadeOut(250, "linear");
}
function skin(value) {
    if (value == true)
        $("#<%=Panelskin.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=Panelskin.ClientID%>").fadeOut(250, "linear");
}
function vomiting(value) {
    if (value == true)
        $("#<%=Panelvomiting.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=Panelvomiting.ClientID%>").fadeOut(250, "linear");
}
function chkD(value) {
    if (value == true) {
        SwitchToPAH(true);
        $("#<%=pnlD.ClientID%>").fadeIn(250, "linear");
    }
    else
        $("#<%=pnlD.ClientID%>").fadeOut(250, "linear");
}

function IVAA(value) {
    if (value == true)
        $("#<%=pnlIVAA.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlIVAA.ClientID%>").fadeOut(250, "linear");
}

function IVHT(value) {
    if (value == true)
        $("#<%=pnlIVHT.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlIVHT.ClientID%>").fadeOut(250, "linear");
}

function IVVA(value) {
    if (value == true)
        $("#<%=pnlIVVA.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlIVVA.ClientID%>").fadeOut(250, "linear");
}

function IVDI(value) {
    if (value == true)
        $("#<%=pnlIVDI.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlIVDI.ClientID%>").fadeOut(250, "linear");
}

function NIPPV(value) {
    if (value == true)
        $("#<%=pnlNIPPV.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlNIPPV.ClientID%>").fadeOut(250, "linear");

}

function CHKCAR(value) {
    if (value == true)
        $("#<%=pnlCar.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlCar.ClientID%>").fadeOut(250, "linear");
}
function CHKace(value) {
    if (value == true)
        $("#<%=pnlace.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlace.ClientID%>").fadeOut(250, "linear");
}

function CHKdiuretic(value) {
    if (value == true)
        $("#<%=pnldiuretic.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnldiuretic.ClientID%>").fadeOut(250, "linear");   
}

function ACS(value) {
    if (value == true)
        $("#<%=pnlACS.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlACS.ClientID%>").fadeOut(250, "linear");
}

function STEMI(value) {
    if (value == true)
        $("#<%=pnlSTEMI.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlSTEMI.ClientID%>").fadeOut(250, "linear");
}

function PCI(value) {
    if (value == true)
        $("#<%=pnlPCI.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlPCI.ClientID%>").fadeOut(250, "linear");
}
function Previous(value) {
    if (value == true)
        $("#<%=pnlPrevious.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlPrevious.ClientID%>").fadeOut(250, "linear");
}
function CABG(value) {
    if (value == true)
        $("#<%=pnlCABG.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlCABG.ClientID%>").fadeOut(250, "linear");
}

function StableAng(value) {
    if (value == true)
        $("#<%=pnlStableAng.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlStableAng.ClientID%>").fadeOut(250, "linear");
}

function acuteCVA(value) {
    if (value == true)
        $("#<%=pnlAcuteCVA.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlAcuteCVA.ClientID%>").fadeOut(250, "linear");
}

function DVTPrevention(value) {
    if (value == true)
        $("#<%=pnlDVTPrevention.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlDVTPrevention.ClientID%>").fadeOut(250, "linear");
}
function PE(value) {
    if (value == true)
        $("#<%=pnlPE.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlPE.ClientID%>").fadeOut(250, "linear");
}
function bleed(value) {
    if (value == true)
        $("#<%=pnlBleed.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlBleed.ClientID%>").fadeOut(250, "linear");
}

function MedicalIllness(value) {
    if (value == true)
        $("#<%=pnlMedicalIllness.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlMedicalIllness.ClientID%>").fadeOut(250, "linear");
}

function RMVD(value) {
    if (value == true)
        $("#<%=pnlRMVD.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlRMVD.ClientID%>").fadeOut(250, "linear");
}

function TA(value) {
    if (value == true)
        $("#<%=pnlTA.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=chkTA.ClientID%>").is(':checked') == false && $("#<%=chkPA.ClientID%>").is(':checked') == false)
            $("#<%=pnlTA.ClientID%>").fadeOut(250, "linear");
    }
}
function asthma(value) {
    if (value == true)
        $("#<%=pnlasthma.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlasthma.ClientID%>").fadeOut(250, "linear");
       
}
function NaChanged() {
    var n = document.getElementById('<%= txtNameq.ClientID %>').value;

    if (n>129) {
        $("#<%=pnlNameq.ClientID%>").fadeOut(250, "linear");
    }
    else {
        $("#<%=pnlNameq.ClientID%>").fadeIn(250, "linear");
    }
}

function SCD() {
    if (tabSCD.style.display == "none")
    {
        $("#tabSCD").fadeIn(250, "linear");
        $("#tabPVD").fadeOut(250, "linear");
        $("#tabAAA").fadeOut(250, "linear");
        $("#tabDiabetes").fadeOut(250, "linear");
        $("#tabRiskFactors").fadeOut(250, "linear");
        lblSCD.className = "flag tabStill";
        lblPVD.className = "flag tabActive"
        lblAAA.className = "flag tabActive"
        lblDiabetes.className = "flag tabActive";
        lblRiskFactors.className = "flag tabActive";
    }
}

function PVD() {
    if (tabPVD.style.display == "none")
    {
        $("#tabSCD").fadeOut(250, "linear");
        $("#tabPVD").fadeIn(250, "linear");
        $("#tabAAA").fadeOut(250, "linear");
        $("#tabDiabetes").fadeOut(250, "linear");
        $("#tabRiskFactors").fadeOut(250, "linear");
        lblSCD.className = "flag tabActive";
        lblPVD.className = "flag tabStill"
        lblAAA.className = "flag tabActive"
        lblDiabetes.className = "flag tabActive";
        lblRiskFactors.className = "flag tabActive";
    }
}

function AAA() {
    if (tabAAA.style.display == "none")
    {
        $("#tabSCD").fadeOut(250, "linear");
        $("#tabPVD").fadeOut(250, "linear");
        $("#tabAAA").fadeIn(250, "linear");
        $("#tabDiabetes").fadeOut(250, "linear");
        $("#tabRiskFactors").fadeOut(250, "linear");
        lblSCD.className = "flag tabActive";
        lblPVD.className = "flag tabActive"
        lblAAA.className = "flag tabStill"
        lblDiabetes.className = "flag tabActive";
        lblRiskFactors.className = "flag tabActive";
    }
}

function Diabetes() {
    if (tabDiabetes.style.display == "none")
    {
        $("#tabSCD").fadeOut(250, "linear");
        $("#tabPVD").fadeOut(250, "linear");
        $("#tabAAA").fadeOut(250, "linear");
        $("#tabDiabetes").fadeIn(250, "linear");
        $("#tabRiskFactors").fadeOut(250, "linear");
        lblSCD.className = "flag tabActive";
        lblPVD.className = "flag tabActive"
        lblAAA.className = "flag tabActive"
        lblDiabetes.className = "flag tabStill";
        lblRiskFactors.className = "flag tabActive";
    }
}

function RiskFactors() {
    if (tabRiskFactors.style.display == "none")
    {
        $("#tabSCD").fadeOut(250, "linear");
        $("#tabPVD").fadeOut(250, "linear");
        $("#tabAAA").fadeOut(250, "linear");
        $("#tabDiabetes").fadeOut(250, "linear");
        $("#tabRiskFactors").fadeIn(250, "linear");
        lblSCD.className = "flag tabActive";
        lblPVD.className = "flag tabActive"
        lblAAA.className = "flag tabActive"
        lblDiabetes.className = "flag tabActive";
        lblRiskFactors.className = "flag tabStill";
    }
}
function Renal() {
    if (tabRenal.style.display == "none") {
        $("#tabRenal").fadeIn(250, "linear");
        $("#tabPulmonary").fadeOut(250, "linear");
        $("#tabHem").fadeOut(250, "linear");
        lblRenal.className = "flag tabStill";
        lblPulmonary.className = "flag tabActive"
        lblHem.className = "flag tabActive";
    }
}

function Pulmonary() {
    if (tabPulmonary.style.display == "none") {
        $("#tabRenal").fadeOut(250, "linear");
        $("#tabPulmonary").fadeIn(250, "linear");
        $("#tabHem").fadeOut(250, "linear");
        lblRenal.className = "flag tabActive";
        lblPulmonary.className = "flag tabStill"
        lblHem.className = "flag tabActive";
    }
}


function Hem() {
    if (tabHem.style.display == "none") {
        $("#tabRenal").fadeOut(250, "linear");
        $("#tabPulmonary").fadeOut(250, "linear");
        $("#tabHem").fadeIn(250, "linear");
        lblRenal.className = "flag tabActive";
        lblPulmonary.className = "flag tabActive"
        lblHem.className = "flag tabStill";
    }
}
function PAH() {
    SwitchToPAH(true);
}

function SAH(value) {
    if (value == true)
        $("#<%=pnlSAH.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlSAH.ClientID%>").fadeOut(250, "linear");
}

function VHD(value) {
    if (value == true)
        $("#<%=pnlVHD.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlVHD.ClientID%>").fadeOut(250, "linear");
}

function CAA(value) {
    if (value == true)
        $("#<%=pnlCAA.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlCAA.ClientID%>").fadeOut(250, "linear");
}

function flutter(value) {
    if (value == true)
        $("#<%=pnlflutter.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlflutter.ClientID%>").fadeOut(250, "linear");
}

function secondegree(value) {
    if (value == true)
        $("#<%=pnlsecondegree.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlsecondegree.ClientID%>").fadeOut(250, "linear");
}

function NCP(value) {
    if (value == true)
        $("#<%=pnlNCP.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlNCP.ClientID%>").fadeOut(250, "linear");
}

function ER(value) {
    if (value == true)
        $("#<%=pnlER.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlER.ClientID%>").fadeOut(250, "linear");
}
function positivetrop(value) {
    if (value == true)
        $("#<%=pnlpositivetrop.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlpositivetrop.ClientID%>").fadeOut(250, "linear");
}
function fixed(value) {
    if (value == true)
        $("#<%=pnlfixed.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlfixed.ClientID%>").fadeOut(250, "linear");
}

function Murmur(value) {
    if (value == true)
        $("#<%=pnlMurmur.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlMurmur.ClientID%>").fadeOut(250, "linear");
}

function S1Mitral(value) {
    if (value == true)
        $("#<%=pnlS1Mitral.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlS1Mitral.ClientID%>").fadeOut(250, "linear");
}
 function S1Tricuspid(value) {
    if (value == true)
        $("#<%=pnlS1Tricuspid.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlS1Tricuspid.ClientID%>").fadeOut(250, "linear");
}

function S2Aortic(value) {
    if (value == true)
        $("#<%=pnlS2Aortic.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlS2Aortic.ClientID%>").fadeOut(250, "linear");
}

function P2Pulmonic(value) {
    if (value == true)
        $("#<%=pnlP2Pulmonic.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlP2Pulmonic.ClientID%>").fadeOut(250, "linear");
}

function SystolicMurmur(value) {
    if (value == true)
        $("#<%=pnlSystolicMurmur.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlSystolicMurmur.ClientID%>").fadeOut(250, "linear");
}

function CresDecres(value) {
    if (value == true)
        $("#<%=pnlCresDecres.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlCresDecres.ClientID%>").fadeOut(250, "linear");
}

function PlateuShaped(value) {
    if (value == true)
        $("#<%=pnlPlateuShaped.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlPlateuShaped.ClientID%>").fadeOut(250, "linear");
}

function DiastolicMurmur(value) {
    if (value == true)
        $("#<%=pnlDiastolicMurmur.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlDiastolicMurmur.ClientID%>").fadeOut(250, "linear");
}

function PleCP(value) {
    if (value == true)
        $("#<%=pnlSubCP.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=chkCPbreath.ClientID%>").is(':checked') == false && $("#<%=chkPrecordial.ClientID%>").is(':checked') == false)
            $("#<%=pnlSubCP.ClientID%>").fadeOut(250, "linear");
    }
}

function IntCP(value) {
    if (value == true)
        $("#<%=pnlSubCP.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=chkpleur.ClientID%>").is(':checked') == false && $("#<%=chkPrecordial.ClientID%>").is(':checked') == false)
            $("#<%=pnlSubCP.ClientID%>").fadeOut(250, "linear");
    }
}

function PreCP(value) {
    if (value == true)
        $("#<%=pnlSubCP.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=chkpleur.ClientID%>").is(':checked') == false && $("#<%=chkCPbreath.ClientID%>").is(':checked') == false)
            $("#<%=pnlSubCP.ClientID%>").fadeOut(250, "linear");
    }
}
function Proban(value) {
    if (value == true)
        $("#<%=pnlSubCP.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=chkpleur.ClientID%>").is(':checked') == false && $("#<%=chkCPbreath.ClientID%>").is(':checked') == false&& $("#<%=chkPrecordial.ClientID%>").is(':checked') == false)
            $("#<%=pnlSubCP.ClientID%>").fadeOut(250, "linear");
    }
}

function Syncopechk(value) {
    if (value == true)
        $("#<%=pnlSyncope.ClientID%>").fadeIn(250, "linear");
    else
        $("#<%=pnlSyncope.ClientID%>").fadeOut(250, "linear");
}
function DM(value) {
    if (value == true)
        $("#<%=pnlDM.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=chkDM1.ClientID%>").is(':checked') == false )
            $("#<%=pnlDM.ClientID%>").fadeOut(250, "linear");
    }
}

function DM1(value) {
    if (value == true)
        $("#<%=pnlDM.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=pnlDM.ClientID%>").is(':checked') == false )
            $("#<%=pnlDM.ClientID%>").fadeOut(250, "linear");
    }
}

function WG(value) {
    if (value == true)
        $("#<%=pnlWG.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=pnlWG.ClientID%>").is(':checked') == false )
            $("#<%=pnlWG.ClientID%>").fadeOut(250, "linear");
    }
}
function Cyanosis(value) {
    if (value == true)
        $("#<%=pnlCyanosis.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=pnlCyanosis.ClientID%>").is(':checked') == false )
            $("#<%=pnlCyanosis.ClientID%>").fadeOut(250, "linear");
    }
}
function CKD(value) {
    if (value == true)
        $("#<%=pnlCKD.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=pnlCKD.ClientID%>").is(':checked') == false )
            $("#<%=pnlCKD.ClientID%>").fadeOut(250, "linear");
    }
}

function sediment(value) {
    if (value == true)
        $("#<%=pnlsediment.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=pnlsediment.ClientID%>").is(':checked') == false )
            $("#<%=pnlsediment.ClientID%>").fadeOut(250, "linear");
    }
}

 function interference(value) {
    if (value == true)
        $("#<%=pnlinterference.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=pnlinterference.ClientID%>").is(':checked') == false )
            $("#<%=pnlinterference.ClientID%>").fadeOut(250, "linear");
    }
}
function COPD(value) {
    if (value == true)
        $("#<%=pnlCOPD.ClientID%>").fadeIn(250, "linear");
    else {
        if ($("#<%=pnlCOPD.ClientID%>").is(':checked') == false )
            $("#<%=pnlCOPD.ClientID%>").fadeOut(250, "linear");
    }
}




</script>
<asp:Label runat="server" ID="lblMessage" EnableViewState="false" Visible="false" Width="100%" style="text-align:center;" Font-Bold="true" ></asp:Label>
<table width="100%">
    <tr>
        <td style="height:10px;">
            <asp:ValidationSummary runat="server" ID="ValidationSummary1" />
        </td>
    </tr>
    <tr>
        <td>
            <table width="100%">
                <tr>
                    <td>
                        <table class="tbltable" width="100%" border="1">
                            <tr>
                                <td width="10%">Name
                                    <asp:RequiredFieldValidator text="*" ErrorMessage="Please Enter NAME" runat="server" ID="RequiredFieldValidator1" ControlToValidate="txtFirstName"></asp:RequiredFieldValidator><br />
                                    <asp:TextBox runat="server" ID="txtFirstName" Columns="30" MaxLength="50" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td width="10%">Age
                                    <asp:RequiredFieldValidator  text="*" ErrorMessage="Please Enter AGE" runat="server" ID="RequiredFieldValidator3" ControlToValidate="txtAge"></asp:RequiredFieldValidator>
                                    <asp:RangeValidator runat="server" ID="RangeValidator1" ControlToValidate="txtAge" MinimumValue="19" MaximumValue="100" Type="Integer" ></asp:RangeValidator><br />
                                    <asp:TextBox runat="server" ID="txtAge" MaxLength="2" Columns="5" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td width="10%">&nbsp;&nbsp;&nbsp;&nbsp;Gender
                                    <asp:RequiredFieldValidator text="*" ErrorMessage="Please Enter GENDER" runat="server" ID="RequiredFieldValidator4" ControlToValidate="rblGender"></asp:RequiredFieldValidator><br />
                                    <asp:RadioButtonList runat="server" ID="rblGender" RepeatDirection="Horizontal">
                                        <asp:ListItem Selected="False" Text="M" Value="1"></asp:ListItem>
                                        <asp:ListItem Selected="False" Text="F" Value="2"></asp:ListItem>
                                    </asp:RadioButtonList>
                                </td>
                                <td>Weight/kg <br />
                                    <asp:TextBox runat="server" ID="txtWeight" MaxLength="3" Columns="5" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>Waist Circ/inch<br />
                                    <asp:TextBox runat="server" ID="txtWaist" MaxLength="2" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>BMI<br />
                                    <asp:TextBox runat="server" ID="txtBMI" MaxLength="2" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td nowrap><asp:CheckBox runat="server" ID="chkAsianCode" Text="AA"/></td>
                                <td nowrap><asp:CheckBox runat="server" ID="chkpreg" Text="Pregnancy"/></td>
                                <td>&nbsp;O2sat% <br /><asp:TextBox runat="server" ID="txtO2sat" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox></td>
                            </tr>
                        </table>                            
                    </td>
                </tr>
                <tr>
                    <td>
                       <table class="tbltable" width="100%" border="1">
                            <tr>
                                <td width="110px">SBP
                                    <asp:RequiredFieldValidator text="*" ErrorMessage="Please Enter SBP" runat="server" ID="RequiredFieldValidator2" ControlToValidate="txtSBP"></asp:RequiredFieldValidator><br />
                                    <asp:TextBox runat="server" ID="txtSBP" ToolTip="Systolic Blood Pressure mmHg" Columns="5" MaxLength="5" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td width="110px">DBP
                                    <asp:RequiredFieldValidator text="*" ErrorMessage="Please Enter DBP" runat="server" ID="RequiredFieldValidator5" ControlToValidate="txtDBP"></asp:RequiredFieldValidator><br />
                                    <asp:TextBox runat="server" ID="txtDBP" ToolTip="Diastolic Blood Pressure mmHg" Columns="5" MaxLength="5" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td width="120px">Orthostatic SBP<br />
                                    <asp:TextBox runat="server" ID="txtOrthostaticSBP" Columns="5" MaxLength="5" BackColor="AntiqueWhite"></asp:TextBox>  
                                </td>
                                <td width="180px">
                                    <asp:CheckBox runat="server" ID="chkSymptomatic" Text="Orthostatic Symptoms"/>
                                </td>
                                <td width="120px">Difference in SBP<br />
                                    <asp:TextBox runat="server" ID="txtDiffInSBP" Columns="5" MaxLength="5" BackColor="AntiqueWhite"></asp:TextBox></td>
                                <td width="100px">Heart Rate<br />
                                    <asp:TextBox runat="server" ID="txtHR" MaxLength="3" Columns="5" BackColor="AntiqueWhite"/>
                                </td>
                                <td width="100px">Amb SBP<br />
                                    <asp:TextBox runat="server" ID="txtASBP" MaxLength="3" Columns="5" BackColor="AntiqueWhite"/>
                                </td>
                                <td width="100px">Amb DBP<br />
                                    <asp:TextBox runat="server" ID="txtADBP" MaxLength="3" Columns="5" BackColor="AntiqueWhite"/>
                                </td>
                            </tr>
                        </table>                    
                    </td>
                </tr>
            </table>
        </td>
    </tr>
   
    <tr>
        <td style="height:20px;"></td>
    </tr>
    <tr>
        <td>
            <table>
                <tr>
                    <td><label id="lblHeartFailure" class="flag tabActive" onclick="return HF()">Dyspnea/HF</label></td>
                    <td><label id="lblChestPain" class="flag tabActive" onclick="return ChestPain()">Chest Pain</label></td>
                    <td><label id="lblSyncope" class="flag tabActive" onclick="return Syncope()">Syncope/Presyncope</label></td>
                    <td><label id="lbledema" class="flag tabActive" onclick="return edema()">Edema</label></td>
                    <td><label id="lblweakness" class="flag tabActive" onclick="return weakness()">Weakness</label></td>
                    <td><label id="lblshock" class="flag tabActive" onclick="return shock()">Shock</label></td>
                    <td><label id="lblabdominalpain" class="flag tabActive" onclick="return abdominalpain()">Abdominal Pain</label></td>
                    <td><label id="lblpalpitations" class="flag tabActive" onclick="return palpitations()">Palpitations</label></td>
                   
                </tr>
            </table>
        </td>
    </tr>
     
     <tr id="tempHF" style="display:none;height:0px;">
        <td>
            <table width="210px" class="flag tabPopup" frame="box">
                <tr>
                    <td align="left">New Onset or Known </td>
                </tr>
                <tr>
                    <td align="left">Stage B, Stage C</td>
                </tr>
                <tr>
                    <td align="left">Stage D, Advanced Heart Failure</td>
                </tr>
                <tr>
                    <td align="left">Hemodynamics/Catheterization</td>
                </tr>
                <tr>
                    <td align="left">Pulmonary Hypertension</td>
                </tr>
            </table>
        </td>        
    </tr>
    
    <tr id="tabHF" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td colspan="3">
                        <table width="100%" class="tbltable" style="border-collapse:collapse;border-style:hidden;">
                            <tr style="border:1px solid black;">
                                <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">  Clinical Profile, must enter if heart failure is known or suspected!</td>
                            </tr>  
                            <tr>
                                <td>
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr style="border:1px solid black;">
                                           <td><asp:CheckBox runat="server" ID="ChknewHF" Text=" Dyspnea unknown or < 6 weeks" /></td>
                                           <td><asp:CheckBox runat="server" ID="ChKHFPLVF" Text="Known HF, click Heart Failure tab" /></td>
                                           <td><asp:CheckBox runat="server" ID="Chklung" Text="Known lung disease, click Pulmonary tab" /></td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkD5" Text="Ambulatory / Outpatient" /></td>
                                            <td><asp:CheckBox runat="server" ID="ChkD4" Text="Escalating / Emergency Room" /></td>
                                            <td>&nbsp;Decompensated / Hospitalized &nbsp;&nbsp;&nbsp;
                                                <asp:CheckBox runat="server" ID="ChkD1" Text="Day 1" />
                                                <asp:CheckBox runat="server" ID="ChkD2" Text="Day 2" />
                                                <asp:CheckBox runat="server" ID="ChkD3" Text="Day 3" />
                                                <%--<asp:CheckBox runat="server" ID="ChkD6" Text="Day 6" />--%>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr style="border:1px solid black;">
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> History - Please assess for Weight Gain, Dyspnea at Rest/Orthopnea at each encounter</td>
                                        </tr>
                                        
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkDOE" Text="Dyspnea on Exertion, not at Rest" style="font-family:Arial Black" onClick="return DOE(this.checked)"/></td>
                                            <td><asp:CheckBox runat="server" ID="Chkdysp" Text="Dyspnea at Rest / Orthopnea" /></td>
                                            <td><asp:CheckBox runat="server" ID="ChkWeight" Text="Weight Gain" /></td> 
                                        </tr>

                                        <tr runat="server" id="PanelDOE" style="display:none;background-color:#CCFFEE">
                                            <td colspan="3">
                                                <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                    <tr>
                                                        <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Dyspnea on Exertion </td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="chkclass1" Text="Strenous Exertion" /></td>
                                                        <td><asp:CheckBox runat="server" ID="chkclass2" Text="More than Daily Routine" /></td>
                                                        <td><asp:CheckBox runat="server" ID="chkclass3" Text="Daily Routine/Minimal Activities" /></td>
                                                    </tr>
                                                 </table>
                                            </td>
                                        </tr>
                                        
                                     </table>
                                </td>
                            </tr>

                           
                        </table>
                     </td>       
                </tr>            
            </table>
        </td>
    </tr>

    <tr id="tabSyncope" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr style="border:0">
                    <td style="border:0;">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                             <tr>
                                <td><asp:CheckBox runat="server" ID="ChkTestSyncope" style="font-family:Arial Black" Text="Clinical Syncope / Presyncope" onClick="return Syncopechk(this.checked)"/></td>
                            </tr>

                            <tr runat="server" id="pnlSyncope" style="display:none;background-color:#CCFFEE">
                                <td colspan="2">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Clinical Syncope / Presyncope</td>
                                        </tr>
                                        <tr style="border:1px solid black;">
                                            <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Circumstance</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkSynStanding" Text="Upright Position, Post Exertion"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynOther" Text="Sudden Noise or Emotion"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynneck" Text="Neck Movement, Manipulation"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynProSitting" Text="Exertional"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynsporadic" Text="Sporadic"/></td>
                                        </tr>
                                        <tr style="border:1px solid black;">
                                            <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Prodromal Symptoms</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkSynNausea" Text="Nausea"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynDizziness" Text="Dizziness"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynPalpitations" Text="Palpitations"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynProCP" Text="Chest Pain"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynaura" Text="Aura"/></td>
                                        </tr>
                                        <tr style="border:1px solid black;">
                                            <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Syncope Duration/During Syncope</td>
                                        </tr>
                                        <tr>
                                            <td>&nbsp;Minutes&nbsp;&nbsp;<asp:TextBox runat="server" ID="txtSynMin" MaxLength="3" Columns="5" BackColor="AntiqueWhite"></asp:TextBox></td>
                                            <td>&nbsp;Seconds&nbsp;&nbsp;<asp:TextBox runat="server" ID="txtSynSec" MaxLength="3" Columns="5" BackColor="AntiqueWhite"></asp:TextBox></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynNone" Text="Cyanosis"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynpallor" Text="Pallor, Diaphoresis"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynposture" Text="Unusual Posture"/></td>
                                        </tr>
                                        <tr style="border:1px solid black;">
                                            <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Postictal Symptoms</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkSynDisor" Text="Disorientation"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynPara" Text="Paralysis"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynPosCP" Text="Chest Pain"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSynfatigue" Text="Prolonged Fatigue"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkSyntrauma" Text="Traumatic Injury"/></td>
                                        </tr>
                                     </table>
                                </td>
                            </tr>
                            
                        </table>
                    </td>
                </tr>
             </table>
         </td>   
    </tr>  
       
    <tr id="tabChestPain" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td>
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                             <tr>
                                <td><asp:CheckBox runat="server" ID="chkTA" Text="Typical Angina, New" style="font-family:Arial Black" onClick="return TA(this.checked)"/></td>
                                <td><asp:CheckBox runat="server" ID="chkPA" Text="Probable Angina, New" style="font-family:Arial Black" onClick="return TA(this.checked)"/></td>
                                <td><asp:CheckBox runat="server" ID="chkNCP" Text="Undetermined CP, New" style="font-family:Arial Black" onClick="return NCP(this.checked)"/></td>
                                <td><asp:CheckBox runat="server" ID="chkER" style="font-family:Arial Black" Text="Emergency Room" onClick="return ER(this.checked)"/></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkunable" Text="Unable to Exercise"/></td>
                            </tr>

                            <tr runat="server" id="pnlTA" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Typical/Probable Angina, New
                                            </td>
                                        </tr>
                                        <tr> 
                                             <td><asp:CheckBox runat="server" ID="chkescTA" Text="Escalating in Frequency, Duration or Severity" /></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr> 

                            <tr runat="server" id="pnlNCP" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Undetermined CP, New
                                            </td>
                                        </tr>
                                        <tr> 
                                             <td width="33%"><asp:CheckBox runat="server" ID="chkpleur" Text="Side/Hemithorax" style="font-family:Arial Black" onClick="return PleCP(this.checked)"/></td>
                                             <td width="33%"><asp:CheckBox runat="server" ID="chkCPbreath" Text="Intercostal CP, Noncardiac CP" style="font-family:Arial Black" onClick="return IntCP(this.checked)"/></td>
                                             <td width="33%"><asp:CheckBox runat="server" ID="chkPrecordial" Text="Central/Precordial CP" style="font-family:Arial Black" onClick="return PreCP(this.checked)"/></td>
                                        </tr>

                                        <tr runat="server" id="pnlSubCP" style="display:none;background-color:#72E6BF">
                                            <td colspan="3">
                                                <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                    <tr>
                                                        <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; Side/Hemithorax / Intercostal / Central/Precordial CP</td>
                                                    </tr>
                                                    <tr style="border:1px solid black;">
                                                        <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Quality</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="chkCPSharp" Text="Sharp"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPPressure" Text="Pressure"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPTightness" Text="Tightness"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPSoreness" Text="Soreness"/></td>
                                                        <td><asp:CheckBox runat="server" ID="Chktearing" Text="Heaviness"/></td>
                                                    </tr>
                                                    <tr style="border:1px solid black;">
                                                        <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Aggravated By</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="chkCPLying" Text="Lying"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPBreathing" Text="Breathing"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPCoughing" Text="Coughing"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPExertion" Text="Exertion"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPPalpation" Text="Palpation"/></td>
                                                    </tr>
                                                    <tr style="border:1px solid black;">
                                                        <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Relieved By</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="chkCPNTG" Text="NTG"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPRest" Text="Rest"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPSitting" Text="Sitting-Up"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPlyingside" Text="Lying On-Side"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPAnalgesics" Text="Analgesics"/></td>
                                                    </tr>
                                                    <tr style="border:1px solid black;">
                                                        <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Radiation</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="chkCPJaw" Text="Jaw"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPBack" Text="Back"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPArm" Text="Arm"/></td>
                                                    </tr>
                                                    <tr style="border:1px solid black;">
                                                        <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Associated With</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="chkCPDyspnea" Text="Dyspnea"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPNausea" Text="Nausea"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPDiaph" Text="Diaphoresis"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPFaint" Text="Faintness"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPpalpitations" Text="Palpitations"/></td>
                                                    </tr>
                                                    <tr style="border:1px solid black;">
                                                        <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Duration</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="chkCPseconds" Text="Seconds"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPminutes" Text="Minutes"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPhours" Text="Hours"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkCPconstant" Text="Constant"/></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr> 

                            <tr runat="server" id="pnlER" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="2" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Emergency Room
                                            </td>
                                        </tr>
                                        <tr> 
                                             <td><asp:CheckBox runat="server" ID="chkangina" Text=">=2 Typical or Probable Angina / 24hr" /></td>
                                             <td><asp:CheckBox runat="server" ID="chkangina20" Text="Typical or Probable Angina > 20min" /></td>
                                        </tr>
                                        <tr> 
                                           <td><asp:CheckBox runat="server" ID="chkASAuse" Text="ASA Use in Past 1 Week" /></td>
                                           <td><asp:CheckBox runat="server" ID="chkpositivetrop" style="font-family:Arial Black" Text="Positive Troponin" onClick="return positivetrop(this.checked)"/></td>
                                        </tr>

                                        <tr runat="server" id="pnlpositivetrop" style="display:none;background-color:#72E6BF">
                                            <td colspan="2">
                                                <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                    <tr>
                                                        <td colspan="2" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; Positive Troponin</td>
                                                    </tr>                                        
                                                    <tr> 
                                                        <td><asp:CheckBox runat="server" ID="Chktrop2" Text="Troponin X >=3 Above Normal " /></td>
                                                        <td><asp:CheckBox runat="server" ID="Chktrop3" Text="Troponin X 1-3 Above Normal" /></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr> 

                                    </table>
                                </td>
                             </tr>                             
  
                        </table>
                    </td>
                </tr> 
            </table>
        </td>   
    </tr>
    <tr id="tabedema" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr >
                    <td >
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                             <tr>
                                <td width="50%"><asp:CheckBox runat="server" ID="chklocaledema" Text="Localized Edema" /></td>
                                <td><asp:CheckBox runat="server" ID="chkdiffusedema" Text="Diffuse Edema" /></td>                                            
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkpitting" Text="Pitting Edema" /></td>
                                <td><asp:CheckBox runat="server" ID="chknonpitting" Text="Nonpitting Edema" /></td>
                            </tr>
                        </table>
                    </td>
                </tr>
             </table>
         </td>   
    </tr>  
    
    <tr id="tabweakness" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td >
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                             <tr>
                                <td><asp:CheckBox runat="server" ID="chkmalaise"  Text="Fatigue / Malaise / Weakness"/></td>
                            </tr>
                        </table>
                    </td>
                 </tr>
             </table>
         </td>   
    </tr>

    <tr id="tabshock" style="display:none;">
        <td>
             <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td >
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkhypovolemia" Text="Signs of IV Volume Depletion"/></td>
                                <td><asp:CheckBox runat="server" ID="chkinfectious" Text="Signs of Infection"/></td>
                                <td><asp:CheckBox runat="server" ID="chkspinalcord" Text="Spinal Cord Insult"/></td>
                                <td><asp:CheckBox runat="server" ID="chkallergen" Text="Allergen Exposure"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpharmacologic" Text="Pharmacological"/></td>
                            </tr>
                        </table>  
                    </td>
                </tr>
             </table>
         </td>   
    </tr>  
          
    <tr id="tababdominalpain" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr >
                    <td >
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr style="border:1px solid black;">
                                <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Quality</td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkAbsharp" Text="Sharp"/></td>
                                <td><asp:CheckBox runat="server" ID="chkAbcolic" Text="Colicky"/></td>
                                <td><asp:CheckBox runat="server" ID="chkAbaching" Text="Aching or Spasm"/></td>           
                            </tr>
                            <tr style="border:1px solid black;">
                                <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Location &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<asp:CheckBox runat="server" ID="chklocalized" Text="Localized Pain "/>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<asp:CheckBox runat="server" ID="chkdiffuse" Text="Diffuse Pain"/></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkepigastric" Text="Epigastric"/></td>
                                <td><asp:CheckBox runat="server" ID="chkperiumbilical" Text="Periumbilical"/></td>
                                <td><asp:CheckBox runat="server" ID="chksuprapubic" Text="Supra Pubic"/></td>
                                <td><asp:CheckBox runat="server" ID="chkAbspasm" Text="Referred Shoulder Pain"/></td>
                            </tr>
                            <tr style="border:1px solid black;">
                                <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Associated Findings</td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkdistention" Text="Abdominal Distention"/></td>
                                <td><asp:CheckBox runat="server" ID="chkrebound" Text="Rebound Tenderness"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpulsatile" Text="Pulsatile Mass"/></td>
                                <td><asp:CheckBox runat="server" ID="chkbowelsounds" Text="Abnormal Bowel Sounds"/></td>
                            </tr>
                            <tr>    
                                <td><asp:CheckBox runat="server" ID="chkpsaos" Text="Psoas Sign "/></td>
                                <td><asp:CheckBox runat="server" ID="chkMcburney" Text="McBurney"/></td>
                                <td><asp:CheckBox runat="server" ID="chkRovsing" Text="Rovsing Sign"/></td>
                                <td><asp:CheckBox runat="server" ID="chkMurphy" Text="Murphy Sign"/></td>        
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkobturator" Text="Obturator Sign "/></td>
                                <td><asp:CheckBox runat="server" ID="chkcarnett" Text="Carnett Sign "/></td>
                                <td><asp:CheckBox runat="server" ID="chkcostovertebral" Text="Costovertebral Tenderness "/></td>
                                <td width="33%"><asp:CheckBox runat="server" ID="chkskin" Text="Skin Findings" style="font-family:Arial Black" onClick="return skin(this.checked)"/></td>
                            </tr>
                            <tr runat="server" id="Panelskin" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Skin Findings</td>
                                        </tr>                                                  
                                        <tr>
                                            <td width="33%"><asp:CheckBox runat="server" ID="chkechymosis" Text="Abdominal wall echymosis" /></td>
                                            <td width="33%"><asp:CheckBox runat="server" ID="chkherpes" Text="Herpes" /></td>
                                            <td width="33%"><asp:CheckBox runat="server" ID="chkhenoch" Text="Rash " /></td> 
                                        </tr>
                                        <tr>
                                            <td width="33%"><asp:CheckBox runat="server" ID="chkcelulitis" Text="Celulitis" /></td>
                                            <td width="33%"><asp:CheckBox runat="server" ID="chkcaput" Text="Caput Medusa" /></td> 
                                        </tr>
                                    </table>
                                </td>
                            </tr>

                            <tr style="border:1px solid black;">
                                <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Associated Symtoms</td>
                            </tr>
                            <tr>
                                <td width="25%"><asp:CheckBox runat="server" ID="chkvomiting" Text="Vomiting" style="font-family:Arial Black" onClick="return vomiting(this.checked)"/></td>
                                <td><asp:CheckBox runat="server" ID="chkanorexia" Text="Anorexia"/></td>
                                <td><asp:CheckBox runat="server" ID="chkbowel" Text="Change in Bowel Habit"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpostoperative" Text="Post Operative"/></td>
                            </tr>
                            <tr runat="server" id="Panelvomiting" style="display:none;background-color:#72E6BF">
                                <td colspan="4">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="2" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Skin Findings</td>
                                        </tr>                  
                                        <tr>
                                            <td width="50%"><asp:CheckBox runat="server" ID="chkvomitfirst" Text="Vomiting Precedes Abdominal Pain" /></td>
                                            <td width="50%"><asp:CheckBox runat="server" ID="chkpainfirst" Text="Abdominal Pain Precedes Vomiting" /></td>                    
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr> 
                                <td><asp:CheckBox runat="server" ID="chkfamilyhistoryAA" Text="Family History of AAA"/></td>
                                <td><asp:CheckBox runat="server" ID="chkhematuria" Text="Hematuria"/></td>
                                <td><asp:CheckBox runat="server" ID="chkurinary" Text="Change in Urinary Habit"/></td>
                                <td><asp:CheckBox runat="server" ID="chkobgyn" Text="Ob&gyn History"/></td>
                            </tr>       
                    </table>
                    </td>
                </tr>
             </table>
         </td>   
    </tr>  

    <tr id="tabpalpitations" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr style="border:0">
                    <td style="border:0;">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr style="border:1px solid black;">
                                <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Frequency</td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkpalday" Text="Daily"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpalweek" Text="Weekly"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpalmonth" Text="Monthly"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpalyear" Text="Yearly"/></td>
                            </tr>
                            <tr style="border:1px solid black;">
                                <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Type</td>
                            </tr>
                            <tr>     
                                <td><asp:CheckBox runat="server" ID="chkextrasys" Text="Extrasystolic "/></td>
                                <td><asp:CheckBox runat="server" ID="chktachycardic" Text="Tachycardic" style="font-family:Arial Black" onClick="return tachycardic(this.checked)"/></td>
                                <td><asp:CheckBox runat="server" ID="chkanxiety" Text="Anxiety (Preceded by Anxiety)"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpulsation" Text="Pulsation (Strong Regular Heart Beats)"/></td>
                            </tr>

                            <tr runat="server" id="Paneltachycardic" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Tachycardic - Response to Vagal Maneuver </td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkvagalabrupt" Text="Strenous Exertion" /></td>
                                            <td><asp:CheckBox runat="server" ID="chkvagalgradual" Text="More than Daily Routine" /></td>
                                            <td><asp:CheckBox runat="server" ID="chkvagalnoresponse" Text="Daily Routine/Minimal Activities" /></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>

                            <tr style="border:1px solid black;">
                                <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Duration </td>
                            </tr>
                            <tr>
                                <td>&nbsp;Duration/ Seconds&nbsp;&nbsp<asp:TextBox runat="server" ID="txtpalseconds" Text="" MaxLength="3" Columns="3" BackColor="AntiqueWhite"/></td>
                                <td>&nbsp;Duration/ Minutes&nbsp;&nbsp<asp:TextBox runat="server" ID="txtpalminutes" Text="" MaxLength="3" Columns="3" BackColor="AntiqueWhite"/></td>
                                <td>&nbsp;Duration/ Hours&nbsp;&nbsp<asp:TextBox runat="server" ID="txtpalhours" Text="" MaxLength="3" Columns="3" BackColor="AntiqueWhite"/></td>
                            </tr>
                            <tr style="border:1px solid black;">
                                <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;">  Symptoms During Syncope </td></tr>
                            <tr>       
                                <td><asp:CheckBox runat="server" ID="chkpalsyncope" Text="Syncope"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpalangina" Text="Angina or Dyspnea"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpalneck" Text="Pulsations in Neck"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpalpolyuria" Text="Polyuria"/></td>
                            </tr>
                            <tr style="border:1px solid black;">
                                <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> EKG Findings During Palpitations</td>
                            </tr>
                            <tr>         
                                <td><asp:CheckBox runat="server" ID="chkpalNSR" Text="NSR"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpalregRR" Text="Other Rhtym, Regular RR"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpalirregRR" Text="Other Rhtym, Irregular RR"/></td>     
                            </tr>
                            <tr style="border:1px solid black;">
                                <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Onset, Trigger</td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkpalsudden" Text="Sudden Onset"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpalposition" Text="Position Change"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpalexertion" Text="Exertional"/></td>
                                <td><asp:CheckBox runat="server" ID="chkpalpostexertion" Text="Post Exertion"/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
             </table>
         </td>   
    </tr>  

    
    
    <tr>
        <td style="height:20px;"></td>
    </tr>    
      
    <tr>
        <td>
            <table>
                <tr>
                    <td><label id="lblROS" class="flag tabActive" onclick="return ROS()">Review of Systems</label></td>
                    <td><label id="lblHandP" class="flag tabActive" onclick="return HandP()">Physical Exam</label></td>
                    <td><label id="lblHometherapeutics" class="flag tabActive" onclick="return HomeMeds()">Home Meds</label></td>
                     <td><label id="lblHospitaltherapeutics" class="flag tabActive" onclick="return Hospitaltherapeutics()">Hospital Therapeutics</label></td>
                    <td><label id="lblLaboratories" class="flag tabActive" onclick="return Laboratories()">Laboratories</label></td>
                    <td><label id="lblDiagnostics" class="flag tabActive" onclick="return Diagnostics()">Diagnostics</label></td>
                </tr>
            </table>
        </td>
    </tr>
    
    <tr id="tabROS" style="display:none;">
        <td>
            <table  class="tbltable2" width="100%" border="1" >
                <tr>
                    <td width="33%"><asp:CheckBox runat="server" ID="chkweightgain" Text="Weight Gain"/></td>
                    <td width="33%"><asp:CheckBox runat="server" ID="chkThyro" Text="Thyrotoxicosis"/></td>
                    <td width="33%"><asp:CheckBox runat="server" ID="chkHypoThyro" Text="Hypothyroidism"/></td>
                </tr>
                <tr>
                     <td><asp:CheckBox runat="server" ID="ChkDVTE" Text="Previous PE"/></td>
                    <td><asp:CheckBox runat="server" ID="ChkOSA" Text="OSA"/></td>
                     <td><asp:CheckBox runat="server" ID="Chksinus" Text="Sinusitis"/></td>
                   
                   
                </tr>
                <tr>
                    <td><asp:CheckBox runat="server" ID="Chkcough" Text="Cough"/></td>
                    <td><asp:CheckBox runat="server" ID="Chksputum" Text="Sputum production"/></td>
                     <td><asp:CheckBox runat="server" ID="Chkhemoptysis" Text="Hemoptysis"/></td>
                   
                </tr>
                <tr>
                    <td><asp:CheckBox runat="server" ID="ChkPND" Text="Paroxysmal Nocturnal Dyspnea" /></td>
                    <td><asp:CheckBox runat="server" ID="Chkorthopnea" Text="Orthopnea"/></td>
                    <td><asp:CheckBox runat="server" ID="Chkpalpitations" Text="Palpitations"/></td>
                </tr>
                <tr>       
                    <td><asp:CheckBox runat="server" ID="ChkPUD" Text="Active Gastroduodenal Ulcer"/></td>
                    <td><asp:CheckBox runat="server" ID="Chkliver" Text="Liver Disease"/></td>
                    <td><asp:CheckBox runat="server" ID="Chkbleed" Text="Bleed in the Past 3 months"/></td>
                </tr>
                <tr>
                    <td><asp:CheckBox runat="server" ID="ChkTIA" Text="Transient Ischemic Attack"/></td>
                    <td><asp:CheckBox runat="server" ID="Chkclaudication" Text="Claudication"/></td>
                    <td><asp:CheckBox runat="server" ID="chkulcer" Text="Lower Extremity Ulceration"/></td>
                </tr>
                <tr>
                    <td><asp:CheckBox runat="server" ID="Chkunilateral" Text="Unilateral Lower Limb Pain or Swelling"/></td>
                    <td><asp:CheckBox runat="server" ID="ChkPVTE" Text="Previous DVT"/></td>
                    <td><asp:CheckBox runat="server" ID="Chkrheum" Text="Rheumatic Disease"/></td>
                </tr>
            </table>
        </td>
    </tr>

    <tr id="tabHandP" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                 <tr style="border:1px solid black;">
                    <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;"> Physical Exam  - Please assess for gallop, JVD, HJR, Edema at each encounter</td>
                </tr>
                <tr>
                    <td colspan="3">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">

                                         <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkHJR" Text="Neck Veins not Assesable"/></td>
                                            <td><asp:CheckBox runat="server" ID="ChkJVD" Text="Jugular Venous Distention"/>&nbsp;&nbsp;(<a href="http://wn.com/jugular_venous_distension_example" target="_blank">Example</a>)</td>
                                            <td><asp:CheckBox runat="server" ID="Chkbruit" Text="Carotid Bruit"/></td>
                                        </tr>
                                         <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkPMI" Text="Displaced PMI"/> </td>
                                            <td><asp:CheckBox runat="server" ID="ChkS3" Text="Left Sided S3 Gallop"/> </td>
                                            <td><asp:CheckBox runat="server" ID="ChkS4" Text="Left Sided S4 Gallop"/> </td>
                                            
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkrub" Text="Friction Rub"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkHeartMurmur" Text="Murmur, Other Abnormal Sounds" style="font-family:Arial Black" onClick="return Murmur(this.checked)"/></td>
                                            <td><asp:CheckBox runat="server" ID="Chkdistant" Text="Distant Heart Sounds"/></td>
                                        </tr>

                                         <tr runat="server" id="pnlMurmur" style="display:none;background-color:#CCFFEE">
                                            <td colspan="3">
                                                <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                    <tr>
                                                        <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Murmur, Pathological Heart Sounds 
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;"> Please enter the charecteristics and the area murmur is most prominent</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="chkS1Mitral" Text="Mitral Area" style="font-family:Arial Black" onClick="return S1Mitral(this.checked)"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkS2Aortic" Text="Aortic Area" style="font-family:Arial Black" onClick="return S2Aortic(this.checked)"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkP2Pulmonic" Text="Pulmonic Area" style="font-family:Arial Black" onClick="return P2Pulmonic(this.checked)"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkS1Tricuspid" Text="Tricuspid Area" style="font-family:Arial Black" onClick="return S1Tricuspid(this.checked)"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="chkSystolicMurmur" Text="Systolic Murmur" style="font-family:Arial Black" onClick="return SystolicMurmur(this.checked)"/></td>
                                                        <td><asp:CheckBox runat="server" ID="chkDiastolicMurmur" Text="Diastolic Murmur" style="font-family:Arial Black" onClick="return DiastolicMurmur(this.checked)"/></td>
                                                        
                                                    </tr>

                                                    <tr runat="server" id="pnlS1Mitral" style="display:none;background-color:#72E6BF">
                                                        <td colspan="6">
                                                            <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                                <tr>
                                                                    <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; Mitral Area</td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkS1MitralLoud" Text="Loud" /></td>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkS1MitralNormal" Text="Normal" /></td>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkS1MitralSoft" Text="Soft" /></td> 
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>

                                                    <tr runat="server" id="pnlS2Aortic" style="display:none;background-color:#72E6BF">
                                                        <td colspan="6">
                                                            <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                                <tr>
                                                                    <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; Aortic Area</td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkS2MitralLoud" Text="Loud" /></td>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkS2MitralNormal" Text="Normal" /></td>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkS2MitralSoft" Text="Soft" /></td> 
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>

                                                    <tr runat="server" id="pnlP2Pulmonic" style="display:none;background-color:#72E6BF">
                                                        <td colspan="6">
                                                            <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                                <tr>
                                                                    <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; Pulmonic Area</td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkP2PulmonicLoud" Text="Loud" /></td>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkP2PulmonicNormal" Text="Normal" /></td>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkP2PulmonicSoft" Text="Soft" /></td> 
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                    <tr runat="server" id="pnlS1Tricuspid" style="display:none;background-color:#72E6BF">
                                                        <td colspan="6">
                                                            <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                                <tr>
                                                                    <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; Tricuspid Area</td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkS1TricuspidLoud" Text="Loud" /></td>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkS1TricuspidNormal" Text="Normal" /></td>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkS1TricuspidSoft" Text="Soft" /></td> 
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                    <tr runat="server" id="pnlSystolicMurmur" style="display:none;background-color:#72E6BF">
                                                        <td colspan="6">
                                                            <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                                <tr>
                                                                    <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; Systolic Murmur</td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkCresDecres" Text="Crescendo-Decrescendo" style="font-family:Arial Black" onClick="return CresDecres(this.checked)"/></td>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkPlateuShaped" Text="Plateu Shaped" style="font-family:Arial Black" onClick="return PlateuShaped(this.checked)"/></td>
                                                                    <td width="33%"></td>
                                                                </tr>
                                                                 <tr>
                                                                     <td><asp:CheckBox runat="server" ID="chksquat" Text="Softer with Squat"/></td>
                                                                     <td><asp:CheckBox runat="server" ID="chksystolicclick" Text="Systolic Click"/></td>
                                                                     <td><asp:CheckBox runat="server" ID="chkejectionsound" Text="Ejection Sound"/></td>
                                                                </tr>

                                                                <tr runat="server" id="pnlCresDecres" style="display:none;background-color:#77C1A9">
                                                                    <td colspan="3">
                                                                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                                            <tr>
                                                                                <td colspan="2" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; &#10152; Crescendo-Decrescendo</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="50%"><asp:CheckBox runat="server" ID="chkEarlyMidPeak" Text="Early-Mid Systolic Peaking" /></td>
                                                                                <td width="50%"><asp:CheckBox runat="server" ID="chkLatePeak" Text="Late Systolic Peaking" /></td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>

                                                                <tr runat="server" id="pnlPlateuShaped" style="display:none;background-color:#77C1A9">
                                                                    <td colspan="3">
                                                                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                                            <tr>
                                                                                <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; &#10152; Plateu Shaped</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td width="33%"><asp:CheckBox runat="server" ID="chkHalosystolic" Text="Halosystolic" /></td>
                                                                                <td width="33%"><asp:CheckBox runat="server" ID="chkPansystolic" Text="Pansystolic" /></td>
                                                                                <td width="33%"><asp:CheckBox runat="server" ID="chkMidsystolic" Text="Midsystolic" /></td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>

                                                            </table>
                                                        </td>
                                                    </tr>

                                                    <tr runat="server" id="pnlDiastolicMurmur" style="display:none;background-color:#72E6BF">
                                                        <td colspan="6">
                                                            <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                                <tr>
                                                                    <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; Diastolic Murmur</td>
                                                                </tr>
                                                                <tr>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkDecrescendo" Text="Decrescendo"/></td>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkRumble" Text="Rumble"/></td>
                                                                    <td width="33%"><asp:CheckBox runat="server" ID="chkMitralOpeningSnap" Text="Mitral Opening Snap"/></td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>

                                                </table>
                                            </td>
                                        </tr>

                                         <tr>
                                                <td><asp:CheckBox runat="server" ID="chkbreath" Text="Diminished Breath Sounds"/></td>
                                                <td><asp:CheckBox runat="server" ID="ChkMR" Text="New Rales"/></td>

                                                <td><asp:CheckBox runat="server" ID="ChkPEd" Text="Moist and dry rales"/></td>
                                        </tr>
                                        <tr>
                                                <td><asp:CheckBox runat="server" ID="chkrhonchi" Text="Dry rales,rhonchi"/></td>
                                                <td><asp:CheckBox runat="server" ID="chkthorax" Text="Increased thorax AP diameter"/></td>

                                                <td><asp:CheckBox runat="server" ID="chkpercussion" Text="Abnormal resonance to percussion"/></td>
                                        </tr>
                                         <tr>
                                            <td><asp:CheckBox runat="server" ID="chkabdominal" Text="Abdominal Tenderness"/></td>
                                            <td><asp:CheckBox runat="server" ID="Chkhepato" Text="Hepato Juguler Reflux"/></td>
                                            <td><asp:CheckBox runat="server" ID="Chkascites" Text="Ascites"/></td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="Chkedema" Text="Edema"/></td>
                                            <td><asp:CheckBox runat="server" ID="Chkshock" Text="Cold Clammy Extremities" /> </td>
                                            <td><asp:CheckBox runat="server" ID="Chkskinwarm" Text="Clubbing" /> </td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkAMS" Text="Any CNS Findings"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkCyanosis" Text="Cyanosis" style="font-family:Arial Black" onClick="return Cyanosis(this.checked)"/></td>
                                            <td ><asp:CheckBox runat="server" ID="chkicterus" Text="Jaundice" /></td>
                                        </tr>
                                        <tr runat="server" id="pnlCyanosis" style="display:none;background-color:#72E6BF">
                                                        <td colspan="6">
                                                            <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                               
                                                                <tr>
                                                                     <td><asp:CheckBox runat="server" ID="chkcentral" Text="Central Cyanosis"/></td>
                                                                     <td><asp:CheckBox runat="server" ID="chkperipheral" Text="Peripheral Cyanosis"/></td>          
                                                                  
                                                                </tr>
                                                            </table>
                                                        </td>
                                       </tr>
                        </table>
                    </td>
                </tr>          
            </table>
        </td>   
    </tr>
    
    <tr id="tabHomeMeds" style="display:none;">
        <td>
            <table  class="tbltable2" width="100%" border="1" >
                <tr>
                    <td><asp:CheckBox runat="server" ID="Chkcar" style="font-family:Arial Black"  Text="B Blocker" onClick="return CHKCAR(this.checked)" /></td>
                    <td><asp:CheckBox runat="server" ID="Chkace" style="font-family:Arial Black"  Text="AceI/ARB" onClick="return CHKace(this.checked)" /> </td>
                    <td><asp:CheckBox runat="server" ID="Chkdiuretic" style="font-family:Arial Black" Text="PO Diuretic" onClick="return CHKdiuretic(this.checked)"  /></td>
                    <td><asp:CheckBox runat="server" ID="ChkCCB" Text="CCB"/></td>
                </tr>
                 <tr>
                    <td><asp:CheckBox runat="server" ID="ChkVKA" Text="Current VKA Therapy" /></td>
                    <td><asp:CheckBox runat="server" ID="ChkCAC" Text="Direct Thrombin Inhibitors (Dabigatran)"/></td>
                    <td><asp:CheckBox runat="server" ID="chkFactorX" Text="Factor Xa Inhibitors (Apixaban, Rivaroxaban, Edoxaban)" /></td>
                    <td><asp:CheckBox runat="server" ID="Chkvasodilator" Text="Other Vasodilators"/></td>
                </tr> 
                <tr runat="server" id="pnlCar" style="display:none;background-color:#CCFFEE">
                    <td colspan="4">
                        <table  width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152;  B Blocker</td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkBisoprolol25" Text="Carvedilol 3.125bid"/></td>
                                <td><asp:CheckBox runat="server" ID="chkCarvedilol625" Text="Carvedilol 6.25bid"/></td>
                                <td><asp:CheckBox runat="server" ID="chkCarvedilol125" Text="Carvedilol 12.5 bid"/></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkCarvedilol25" Text="Carvedilol 25 bid"/></td>
                                <td><asp:CheckBox runat="server" ID="chkBisoprolol5" Text="MetoprololER 25 qd"/></td>
                                <td><asp:CheckBox runat="server" ID="chkMetoprololER50" Text="MetoprololER 50 qd"/></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkMetoprololER100" Text="MetoprololER 100 qd"/></td>
                                <td><asp:CheckBox runat="server" ID="chkBisoprolol10" Text="MetoprololER 150 qd"/></td>
                                <td><asp:CheckBox runat="server" ID="chkMetoprololER200" Text="MetoprololER 200 qd"/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                         <tr runat="server" id="pnlace" style="display:none;background-color:#CCFFEE">
                    <td colspan="4">
                        <table  width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152;  Ace I</td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chklisinopril5" Text="Lisinopril<10mg qd"/></td>
                                <td><asp:CheckBox runat="server" ID="chklisinopril10" Text="Lisinopril10-20mg qd"/></td>
                                <td><asp:CheckBox runat="server" ID="chklisinopril20" Text="Lisinopril20mg qd" /></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chklosartan25" Text="Losartan 25mg qd"/></td>
                                <td><asp:CheckBox runat="server" ID="chklosartan50" Text="Losartan 50mg qd"/></td>
                                <td><asp:CheckBox runat="server" ID="chklosartan100" Text="Losartan 1000mg qd" /></td>
                            </tr>
                            
                        </table>
                    </td>
                </tr>                
                <tr id="pnldiuretic" runat="server" style="display:none;background-color:#CCFFEE">
                    <td colspan="4">
                        <table  width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; PO Diuretic</td>
                            </tr>
                            <tr>
                                <td width="33%"><asp:CheckBox runat="server" ID="chkfurosemide40" Text="Furosemide 40"/></td>
                                <td width="33%"><asp:CheckBox runat="server" ID="chkfurosemide80" Text="Furosemide 80"/></td>
                                <td width="33%"><asp:CheckBox runat="server" ID="chkfurosemide81" Text="Furosemide 80+"/></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkbumex1" Text="Bumex 1"/></td>
                                <td><asp:CheckBox runat="server" ID="chkbumex2" Text="Bumex 2"/></td>
                                <td><asp:CheckBox runat="server" ID="chkbumex3" Text="Bumex 2+"/></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chktorsemide20" Text="Torsemide20"/></td>
                                <td><asp:CheckBox runat="server" ID="chktorsemide40" Text="Torsemide40"/></td>
                                <td><asp:CheckBox runat="server" ID="chktorsemide50" Text="Torsemide50+"/></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="ChkHCTZ" Text="HCTZ"/></td>
                                <td><asp:CheckBox runat="server" ID="Chkindapamide" Text="Indapamide"/></td>
                                <td><asp:CheckBox runat="server" ID="Chkchlorthalidone" Text="Chlorthalidone, Metolazone "/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <tr id="tabHospitaltherapeutics" style="display:none;">
        <td>
            <table  class="tbltable2" width="100%" border="1" >
                
               <tr>
                                <td>
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">

                                        <tr style="border:1px solid black;">
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;">In Hospital Therapeutics including already done and/or contemplated </td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkIVAA" style="font-family:Arial Black" Text="IV Antiarryhtmic" onClick="return IVAA(this.checked)"/></td>
                                            <td><asp:CheckBox runat="server" ID="Chkurgcv" Text="Urgent CV" /></td>
                                            <td><asp:CheckBox runat="server" ID="Chkdefib" Text="Defibrillation/ACLS" /></td>
                                        </tr>
                                        
                                        <tr runat="server" id="pnlIVAA" style="display:none;background-color:#CCFFEE">
                                            <td colspan="3">
                                                <table width="100%">
                                                    <tr>
                                                        <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; IV Antiarrythmic</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="ChkAAcon" Text="Continuous" /></td>
                                                        <td><asp:CheckBox runat="server" ID="ChkAAbolus" Text="Bolus" /></td>
                                                        <td><asp:CheckBox runat="server" ID="ChkAAtitr" Text="Titration" /></td>
                                                        <td>Monitoring Frequency Q <asp:TextBox runat="server" ID="TxtAAmonitor" MaxLength="2" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>hr</td>
                                                        <td><asp:CheckBox runat="server" ID="ChkPOAA" Text="Transition to PO Antiarryhtmic" /></td>
                                                    </tr>
                                                 </table>
                                            </td>
                                        </tr>
                                                                       
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkIVHT" style="font-family:Arial Black" Text="IV Antihypertensive" onClick="return IVHT(this.checked)"/></td>
                                            <td><asp:CheckBox runat="server" ID="ChkIVVA" style="font-family:Arial Black" Text="IV Vasoactive" onClick="return IVVA(this.checked)"/></td>
                                            <td><asp:CheckBox runat="server" ID="ChkIVDI" style="font-family:Arial Black" Text="IV Diuretic" onClick="return IVDI(this.checked)" /></td>
                                        </tr>
                                         
                                        <tr runat="server" id="pnlIVHT" style="display:none;background-color:#CCFFEE">
                                            <td colspan="3">
                                                <table width="100%">
                                                    <tr>
                                                        <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; IV Antihypertensive</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="ChkHTcon" Text="Continuous" /></td>
                                                        <td><asp:CheckBox runat="server" ID="ChkHTbolus" Text="Bolus" /></td>
                                                        <td><asp:CheckBox runat="server" ID="ChkHTtitr" Text="Titration" /></td>
                                                        <td>Monitoring Frequency Q <asp:TextBox runat="server" ID="TxtHTmonitor" MaxLength="2" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>hr</td>
                                                    </tr>
                                                 </table>
                                            </td>
                                        </tr>                       

                                        <tr runat="server" id="pnlIVVA" style="display:none;background-color:#CCFFEE">
                                            <td colspan="3">
                                                <table width="100%">
                                                    <tr>
                                                        <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; IV Vasoactive</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="ChkVAcon" Text="Continuous" /></td>
                                                        <td><asp:CheckBox runat="server" ID="ChkVAbolus" Text="Bolus" /></td>
                                                        <td><asp:CheckBox runat="server" ID="ChkVAtitr" Text="Titration" /></td>
                                                        <td>Monitoring Frequency Q <asp:TextBox runat="server" ID="TxtVAmonitor" MaxLength="2" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>hr</td>
                                                    </tr>
                                                    <tr>    
                                                        <td><asp:CheckBox runat="server" ID="ChkIVNPS" Text="IV NPS" /></td>
                                                        <td><asp:CheckBox runat="server" ID="ChkIVNTG" Text="IV NTG" /></td>
                                                        <td><asp:CheckBox runat="server" ID="Chkmilrinone" Text="IV Milrinone" /></td>
                                                    </tr>
                                                 </table>
                                            </td>
                                        </tr>
                                        
                                        <tr runat="server" id="pnlIVDI" style="display:none;background-color:#CCFFEE">
                                            <td colspan="3">
                                                <table width="100%">
                                                    <tr>
                                                        <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; IV Diuretic</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="Chkcon" Text="Continuous" /></td>
                                                        <td><asp:CheckBox runat="server" ID="ChkPODI" Text="Intermittent" /></td> 
                                                        <td>Monitoring Frequency Q <asp:TextBox runat="server" ID="Txtmonitor" MaxLength="2" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>hr</td>
                                                                         
                                                    </tr>
                                                 </table>
                                            </td>
                                        </tr>
                                           
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkNIPPV" style="font-family:Arial Black" Text="Mechanical Ventilation or NIPPV" onClick="return NIPPV(this.checked)" ToolTip="Mechanical Ventilation or Nasal Intermittent Positive Pressure Ventilation"/></td>
                                            <td>&nbsp;O2 supplement% <asp:TextBox runat="server" ID="txtOsupp" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox></td>
                                            <td><asp:CheckBox runat="server" ID="ChkVAD" Text="IV Vasopressors" ToolTip="Ventricular Assist Device"/></td>
                                        </tr>
                                        
                                        <tr runat="server" id="pnlNIPPV" style="display:none;background-color:#CCFFEE">
                                            <td colspan="3">
                                                <table width="100%">
                                                    <tr>
                                                        <td style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Mechanical Ventilation or NIPPV</td>
                                                    </tr>
                                                    <tr>
                                                        <td>Respratory Interventions Q <asp:TextBox runat="server" ID="txtRI" MaxLength="2" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>hr</td>
                                                    </tr>
                                                 </table>
                                            </td>
                                        </tr>
                                         
                                         <tr>
                                            <td><asp:CheckBox runat="server" ID="chkult" Text="Ultrafiltration" /></td>
                                            <td><asp:CheckBox runat="server" ID="ChkIABP" Text="IABP" ToolTip="Intraaortic Baloon Pump"/></td>
                                            <td><asp:CheckBox runat="server" ID="ChkTPM" Text="Temporary PM" ToolTip="Temporary Pacemaker"/></td>
                                         </tr>

                                    </table>
                                </td>
                            </tr>
               
            </table>
        </td>
    </tr>

    <tr id="tabLaboratories" style="display:none;">
        <td>
            <table class="tbltable3" width="100%" frame="box">
                <tr>
                    <td>
                        <table class="tbltable2" width="100%">
                            <tr>
                                <td colspan="9" style="background-color:#D3D3D3;font-weight:bold;color:Red">Chem Basic
                                </td>
                            </tr>
                            <tr>
                                <td>Na meq/l<br />
                                    <asp:TextBox runat="server" ID="txtNameq" Columns="5" MaxLength="4" BackColor="AntiqueWhite" onchange="javascript: NaChanged();"></asp:TextBox>
                                </td>
                                <td>K meq/l<br />
                                    <asp:TextBox runat="server" ID="txtHomo" Columns="5" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>Creatinine mg/dl<br />
                                    <asp:TextBox runat="server" ID="txtcreatinine" Columns="5" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td> 
                                <td>BUN mg/dl<br />
                                    <asp:TextBox runat="server" ID="txtBUN" Columns="5" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>GFR ml/min/1.73 M2<br />
                                    <asp:TextBox runat="server" ID="txtGFR" MaxLength="3" Columns="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>  
                               
                            </tr>
                            
                             <tr runat="server" id="pnlNameq" style="display:none;">
                                <td>Urine Na meq/l<br />
                                    <asp:TextBox runat="server" ID="txturineNa" Columns="5" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>Serum Osmolality<br />
                                    <asp:TextBox runat="server" ID="txtsosm" Columns="5" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>Urine Osmolality<br />
                                    <asp:TextBox runat="server" ID="txtuosm" Columns="5" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td> 
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table class="tbltable2" width="100%">
                            <tr>
                                <td colspan="9" style="background-color:#D3D3D3;font-weight:bold;color:Red">Lipid Profile  <asp:CheckBox runat="server" ID="chkstatint" Text= "Statin Intolerance"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Total Cholesterol mg/dl
                                    <br />
                                    <asp:TextBox runat="server" ID="txtCholesterol" ToolTip="Total Cholesterol mg/dl" Columns="5" MaxLength="5" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>Tryglyceride mg/dl
                                    <br />
                                    <asp:TextBox runat="server" ID="txtTRG" ToolTip="Tryglyceride mg/dl" Columns="5" MaxLength="5" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>LDL-C
                                    <br />
                                    <asp:TextBox runat="server" ID="txtLDL" ToolTip="LDL-Cholesterol mg/dl" Columns="5" MaxLength="5" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>HDL-C
                                    <br />
                                    <asp:TextBox runat="server" ID="txtHDL" ToolTip="HDL-Cholesterol mg/dl" Columns="5" MaxLength="5" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>Apo B<br />
                                    <asp:TextBox runat="server" ID="txtApoB" Columns="4" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>LDL-P<br />
                                    <asp:TextBox runat="server" ID="txtLDLP" Columns="4" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>LPa mg/dl<br />
                                    <asp:TextBox runat="server" ID="txtLPA" Columns="4" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td><asp:CheckBox runat="server" ID="chkalready" Text="Already on Statin" /></td>
                                <td>10 Year ASCVD Risk<br />
                                    <asp:TextBox runat="server" ID="txtASCVD" Columns="5" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                &nbsp;<a href="http://clincalc.com/Cardiology/ASCVD/PooledCohort.aspx" target="_blank" title="Calculate">?</a>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <table class="tbltable2" width="100%">
                            <tr>
                                <td colspan="7" style="background-color:#D3D3D3;font-weight:bold;color:Red">Others
                                </td>
                            </tr>
                            <tr>
                                <td>Glucose<br />
                                    <asp:TextBox runat="server" ID="txtGlucose" MaxLength="3" Columns="5" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>HBA1C<br />
                                    <asp:TextBox runat="server" ID="txtHBA1C" MaxLength="5" Columns="5" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>CRP mg/l<br />
                                    <asp:TextBox runat="server" ID="txtCRP" Columns="5" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                 <td>NT-proBNP pg/ml<br />
                                    <asp:TextBox runat="server" ID="txtproBNP" Columns="6" MaxLength="6" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>BNP pg/ml<br />
                                    <asp:TextBox runat="server" ID="txtBNP" Columns="6" MaxLength="6" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>Albuminuria  mg/24 Hr<br />
                                    <asp:TextBox runat="server" ID="txtMICRO" Columns="5" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>Abnormal urinary sediment<br />
                                    <asp:CheckBox runat="server" ID="chksediment" style="font-family:Arial Black"  onClick="return sediment(this.checked)"/></td>

                            </tr>
                            </tr>   
                                  <tr runat="server" id="pnlsediment" style="display:none;background-color:#CCFFEE">
                                <td colspan="7">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr style="border:1px solid black;">
                                            <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Abnormal urine sediment</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkRBC" Text="Isolated RBC" ToolTip="Isolated RBC"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkRBCcast" Text="RBC cast" ToolTip="RBC cast"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkWBCcast" Text="WBC cast" ToolTip="WBC cast"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkgranular" Text="Granular cast" ToolTip="Granular cast"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkoval" Text="Oval fat bodies" ToolTip="Oval cell bodies"/></td>
                                            
                                       </tr>
                                                                                
                                    </table>    
                                </td>
                            </tr>     
                            
                        </table>
                    </td>
                </tr>
            </table>
                        
        </td>
    </tr>

    <tr id="tabDiagnostics" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td><asp:CheckBox runat="server" ID="chkEKG" style="font-family:Arial Black" Text="EKG" onClick="return EKG(this.checked)"/></td>
                    <td><asp:CheckBox runat="server" ID="chkDTS" style="font-family:Arial Black" Text="Stress Testing" ToolTip="Exercise Treadmill Testing" onClick="return DTS(this.checked)"/></td>
                    <td><asp:CheckBox runat="server" ID="chkEcho" style="font-family:Arial Black" Text="Echocardiography" class="confirm" onClick="return Echo(this.checked)"/></td>
                    <td><asp:CheckBox runat="server" ID="chkchestxray" style="font-family:Arial Black" Text="Chest X-Ray" onClick="return chestxray(this.checked)"/></td>
                      <td><asp:CheckBox runat="server" ID="chkHRCT" style="font-family:Arial Black" Text="HRCT" onClick="return HRCT(this.checked)"/></td>
                    <td><asp:CheckBox runat="server" ID="ChkHC" style="font-family:Arial Black" Text="RHC" onClick="return SwitchToPAH(this.checked)"/></td>
                    <td>Coronary Calcium Score (percentile)<br />
                        <asp:TextBox runat="server" ID="txtCCS" Columns="5" MaxLength="2" BackColor="AntiqueWhite"></asp:TextBox>
                    </td>
                    <td>Total<br />
                        <asp:TextBox runat="server" ID="txtTotalCCS" Columns="5" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                    </td>
                </tr>

                <tr runat="server" id="pnlEKG" style="display:none;background-color:#CCFFEE">
                    <td colspan="8">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr style="border:1px solid black;">
                                <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; EKG</td>
                            </tr>
                            <tr>
                                <td>
                                    <asp:Label runat="server" ID="Label4">PR Duration /msec</asp:Label>
                                    <asp:TextBox runat="server" ID="txtPRduration" BackColor="AntiqueWhite"></asp:TextBox> 
                                </td>
                                <td>
                                    <asp:Label runat="server" ID="Label1">QRS Duration /msec</asp:Label>
                                    <asp:TextBox runat="server" ID="txtQRS" BackColor="AntiqueWhite"></asp:TextBox> 
                                </td>
                                <td>
                                    <asp:Label runat="server" ID="Label5">QRS Axis/degree</asp:Label>
                                    <asp:TextBox runat="server" ID="txtQRSAx" BackColor="AntiqueWhite"></asp:TextBox> 
                                </td>
                                <td>
                                    <asp:Label runat="server" ID="Label6">QTc msec</asp:Label>
                                    <asp:TextBox runat="server" ID="txtQTc" BackColor="AntiqueWhite"></asp:TextBox> 
                                </td>
                            </tr>
                             <tr>
                                <td><asp:CheckBox runat="server" ID="ChkNSR" Text="NSR"/></td>
                                <td><asp:CheckBox runat="server" ID="Chkfirstdegree" Text="1st Degree AV Block"/></td>
                                <td><asp:CheckBox runat="server" ID="Chksecondegree" Text="2nd Degree AV Block" style="font-family:Arial Black" onClick="return secondegree(this.checked)" /></td>
                                <td><asp:CheckBox runat="server" ID="Chkthirdegree" Text="3rd Degree AV Block"/></td>
                            </tr>
                            <tr runat="server" id="pnlsecondegree" style="display:none;background-color:#72E6BF">
                                <td colspan="4">
                                    <table width="100%">
                                        <tr>
                                            <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; 2nd Degree AV Block</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="Chktype1" Text="Type 1"/></td>
                                            <td><asp:CheckBox runat="server" ID="Chktype2" Text="Type 2"/></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="Chklowv" Text="Low Voltage QRS" /></td>
                                <td><asp:CheckBox runat="server" ID="Chkabnormq" Text="Abnormal Q Waves"/></td>
                                <td><asp:CheckBox runat="server" ID="ChkLBBB" Text="LBBB" style="font-family:Arial Black" onClick="return LBBB(this.checked)"/></td>
                                <td><asp:CheckBox runat="server" ID="ChKRBBB" Text="RBBB"/></td>
                            </tr>

                            <tr runat="server" id="pnlLBBB" style="display:none;background-color:#72E6BF">
                                <td colspan="4">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; LBBB</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkbifascicular" Text="Bifascicular" /></td>
                                            <td><asp:CheckBox runat="server" ID="chkLAHB" Text="LAHB" /></td>
                                            <td><asp:CheckBox runat="server" ID="chkLPHB" Text="LPHB" /></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>

                             <tr>
                                <td><asp:CheckBox runat="server" ID="ChkAPCs" Text="APCs"/></td>    
                                <td><asp:CheckBox runat="server" ID="ChkJPDs" Text="Junctional Premature Depolarization" /></td>
                                <td><asp:CheckBox runat="server" ID="ChkFreqVentPac" Text="Frequent PVCs" /></td>
                                <td><asp:CheckBox runat="server" ID="Chkinfreqvent" Text="Infrequent PVCs" /></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="ChkWPW" Text="WPW"/></td>
                                <td><asp:CheckBox runat="server" ID="ChkVPace" Text="Ventricular Pacing"/></td>
                                <td><asp:CheckBox runat="server" ID="ChkLVH" Text="LVH"/></td>
                                <td><asp:CheckBox runat="server" ID="ChkIVCD" Text="Intraventicular Block" /></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="Chkatrialfib" Text="Atrial Fibrillation" /></td>
                                <td><asp:CheckBox runat="server" ID="Chkflutter" Text="Atrial Flutter" style="font-family:Arial Black" onClick="return flutter(this.checked)" /></td>
                                <td><asp:CheckBox runat="server" ID="ChkPSVT" Text="SVT"/></td>
                            </tr>
                            <tr runat="server" id="pnlflutter" style="display:none;background-color:#72E6BF">
                                <td colspan="4">
                                    <table width="100%">
                                        <tr>
                                            <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; Atrial Flutter</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chktypicalAF" Text="Typical AF" /></td>
                                            <td><asp:CheckBox runat="server" ID="chkatypicalAF" Text="Atypical AF" /></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="ChkST" Text="ST Deviation >= 0.5mm"/></td>
                                <td><asp:CheckBox runat="server" ID="ChkTWI" Text="T Wave Inversion > 1mm"/></td>
                                <td><asp:CheckBox runat="server" ID="Chknonspesific" Text="Nonspesific ST Abnormality"/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
                
                <tr runat="server" id="pnlDTS" style="display:none;background-color:#CCFFEE">
                    <td colspan="8">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Stress Testing
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="border: 1px solid black;">&nbsp;&nbsp;Duke Treadmill Score (DTS)&nbsp;&nbsp;<asp:TextBox runat="server" ID="TxtTTS" Text="" BackColor="AntiqueWhite"/>
                                </td>
                                <td colspan="2" style="border: 1px solid black;">&nbsp;&nbsp;Stress Summed Score&nbsp;&nbsp;<asp:TextBox runat="server" ID="txtStressSummedScore" Text="" BackColor="AntiqueWhite"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="border: 1px solid black;">&nbsp;&nbsp;DSE Ishemic Threshold, %MPHR at the Onset of Ischemia &nbsp;&nbsp;<asp:TextBox runat="server" ID="txtDSE" Text="" BackColor="AntiqueWhite"/>
                                </td>
                                <td colspan="2" style="border: 1px solid black;">&nbsp;&nbsp;Stress Difference Score &nbsp;&nbsp;<asp:TextBox runat="server" ID="txtreversible" Text="" BackColor="AntiqueWhite"/>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" style="border: 1px solid black;">&nbsp;&nbsp;DSE or Stress MRI, Number of Segments with New WMA  &nbsp;&nbsp;<asp:TextBox runat="server" ID="txtWMA" Text="" BackColor="AntiqueWhite"/>
                                </td>
                                <td colspan="2" style="border: 1px solid black;">&nbsp;&nbsp;% Ischemic Myocardium on MPS &nbsp;&nbsp;<asp:TextBox runat="server" ID="txtMPS" Text="" BackColor="AntiqueWhite"/>
                                </td>
                            </tr>
                            <tr>
                                <td style="border: 1px solid black;">
                                    <table width="100%">
                                        <tr>
                                            <td><asp:Label ID="Label3" runat="server"> Ex Time&nbsp;&nbsp;</asp:Label></td>
                                            <td><asp:TextBox runat="server" ID="txtExTimeMin" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox> min&nbsp;&nbsp;</td>
                                        </tr>
                                        <tr>
                                            <td><asp:Label ID="Label2" runat="server"> Max ST&nbsp;&nbsp;&nbsp;</asp:Label></td>
                                            <td><asp:TextBox runat="server" ID="txtMaxST" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox> mm</td>
                                        </tr>
                                    </table>  
                                </td>
                                
                                <td style="border: 1px solid black;"> Angina Index
                                    <asp:RadioButtonList ID="rbAnginaIndex" runat="server">
                                        <asp:ListItem Text="0. No Angina During Exercise" Value="0"></asp:ListItem>
                                        <asp:ListItem Text="1. Non-Limiting Angina" Value="1"></asp:ListItem>
                                        <asp:ListItem Text="2. Exercise Limiting Angina" Value="2"></asp:ListItem>
                                    </asp:RadioButtonList> 
                                </td>
                                 <td style="border: 1px solid black;">
                                    <table width="100%">
                                         <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkSTelevation"  Text="ST Elevation"/></td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkabnormalBP"  Text="Abnormal BP Response"/></td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkExVT"  Text="Ventricular Tachycardia"/></td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkprolongedST"  Text="Prolonged ST Depression"/></td>
                                        </tr>
                                    </table>
                                 </td>  
                            </tr>
                            <tr>
                                <td>
                                    <asp:CheckBox runat="server" ID="chkTID" Text="TID or Significant Stress-Induced LV Dysfunction" />
                                </td>
                                <td>
                                    <asp:CheckBox runat="server" ID="Chkfixed" style="font-family:Arial Black" onClick="return fixed(this.checked)"  Text="Fixed Perfusion Defects or Akinetic/Dyskinetic WMA on DSE" />
                                </td>
                                <td>
                                    <asp:CheckBox runat="server" ID="Chkuninterpret" Text="Artifactual, Uninterpretable Images" />
                                </td>
                            </tr> 

                            <tr runat="server" id="pnlfixed" style="display:none;background-color:#72E6BF">
                                <td colspan="3">
                                    <table width="100%">
                                        <tr>
                                            <td style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; Fixed Perfusion Defects or Akinetic/Dyskinetic WMA on DSE</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="Chkviable" Text="Viability Present" /></td>      
                                        </tr>     
                                    </table>
                                </td>
                            </tr>
                                        
                        </table>
                    </td>
                </tr>
                
                <tr runat="server" id="pnlEcho" style="display:none;background-color:#CCFFEE">
                    <td colspan="8">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr style="border:1px solid black;">
                                <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Echocardiography (Nonvalvular)&nbsp;&nbsp;&nbsp;&nbsp; <asp:CheckBox runat="server" ID="chkpericardial" Text="Pericardial Effusion"/>&nbsp;&nbsp;&nbsp;&nbsp; <asp:CheckBox runat="server" ID="chkRWMA" Text="RWMA"/></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkEnlargedLA" Text="Enlarged LA "/></td>
                                <td><asp:CheckBox runat="server" ID="chkLVeccenticity" Text="E/A < 1 and DT > 280ms"/></td>
                                <td><asp:CheckBox runat="server" ID="chkMPI" Text="Grade =>2 Diastolic Dysfunction"/></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="ChkIVSshift" Text="Respratory IVS Shift"/></td>
                                <td><asp:CheckBox runat="server" ID="ChkmitralE" Text="Mitral E Variation"/></td>
                                <td><asp:CheckBox runat="server" ID="Chkhepatic" Text="Hepatic Vein Exp Diastolic Reversal"/></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="ChkEnlargedRA" Text="Enlarged RA"/></td>
                                <td><asp:CheckBox runat="server" ID="ChkEnlargedRV" Text="Enlarged RV"/></td>
                                <td><asp:CheckBox runat="server" ID="Chkmidsystolicn" Text="Midsystolic Notch"/></td>
                            </tr>
                            <tr>
                                <td>&nbsp;LV Lateral Annulus E/E'&nbsp;&nbsp;<asp:TextBox runat="server" ID="txtMP" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox></td>
                                <td>&nbsp;LVEF&nbsp;&nbsp;<asp:TextBox runat="server" ID="txtEF" MaxLength="3" Columns="3"  BackColor="AntiqueWhite"></asp:TextBox></td>
                                <td>&nbsp;TRJ Velocity m/sec&nbsp;&nbsp;<asp:TextBox runat="server" ID="txtTRJ" MaxLength="3" Columns="3"  BackColor="AntiqueWhite"></asp:TextBox></td>
                            </tr>
                        </table>
                    </td>
                </tr> 
                               
                <tr runat="server" id="pnlchestxray" style="display:none;background-color:#CCFFEE">
                    <td colspan="8">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr style="border:1px solid black;">
                                <td colspan="2" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Chest X-Ray</td>
                            </tr>
                            <tr>
                                 <td><asp:CheckBox runat="server" ID="chkRPLE" Text="Right Pleural Effusion" /></td>
                                 <td><asp:CheckBox runat="server" ID="chkLPLE" Text="Left Pleural Effusion" /></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkpuledema" Text="Pulmonary Edema" /></td>
                                <td><asp:CheckBox runat="server" ID="chkenlarcar" Text="Enlarged Cardiac Sillhouette" /></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkWidened" Text="Widened Mediasteneum"></asp:CheckBox></td>
                                <td><asp:CheckBox runat="server" ID="chkpneumothorax" Text="Pneumothorax"></asp:CheckBox></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkinfiltrate" Text="Infiltrate(s)"></asp:CheckBox></td>
                                <td><asp:CheckBox runat="server" ID="chkconsolidation" Text="Consolidation"></asp:CheckBox></td>
                            </tr>
                        </table>
                    </td>
                </tr>        
                 <tr runat="server" id="pnlHRCT" style="display:none;background-color:#CCFFEE">
                    <td colspan="8">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr style="border:1px solid black;">
                                <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Chest X-Ray</td>
                            </tr>
                            <tr>
                                 <td><asp:CheckBox runat="server" ID="chkground" Text="Ground glass" /></td>
                                 <td><asp:CheckBox runat="server" ID="chkseptal" Text="Septal thickening" /></td>
                                 <td><asp:CheckBox runat="server" ID="chkreticular" Text="Reticular opasities" /></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chknodular" Text="Nodules" /></td>
                                <td><asp:CheckBox runat="server" ID="chkhoney" Text="Honeycombing"></asp:CheckBox></td>
                                 <td><asp:CheckBox runat="server" ID="chkconsolidate" Text="Consolidation"></asp:CheckBox></td>
                               
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkbronch" Text="Bronchiectasis"></asp:CheckBox></td>
                                 <td><asp:CheckBox runat="server" ID="chkmedias" Text="Mediastinal lymphadenpathies"></asp:CheckBox></td>
                                <td><asp:CheckBox runat="server" ID="chkpleuralthick" Text="Pleural thickening"></asp:CheckBox></td>
                            </tr>
                            
                        </table>
                    </td>
                </tr>        
            </table>
        </td>
    </tr>


          
    <tr>
        <td style="height:20px;"></td>
    </tr>

    <tr>
        <td>
            <table>
                <tr>
                    <td><label id="lblCHD" class="flag tabActive" onclick="return CHD()">Coronary Heart Disease</label></td>
                    <td><label id="lblHfailure" class="flag tabActive" onclick="return Hfailure()">Heart Failure</label></td>
                    <td><label id="lblAF" class="flag tabActive" onclick="return AF()">Atrial Fibrillation</label></td>
                    <td><label id="lblThrombo" class="flag tabActive" onclick="return Thrombo()">Thromboembolic/VKA</label></td>
                    <td><label id="lblValvular" class="flag tabActive" onclick="return Valvular()">Valvular</label></td>
                    <td><label id="lblPAH" class="flag tabActive" onclick="return PAH()">PAH</label></td>
                    <td><label id="lblVentricular" class="flag tabActive" onclick="return Ventricular()">Ventricular Tachycardia</label></td>
                    <td><label id="lblBrady" class="flag tabActive" onclick="return Brady()">Other syncope</label></td>
                    <td><label id="lblSurgRisk" class="flag tabActive" onclick="return SurgRisk()">Surgical Risk</label></td>
                </tr>
            </table>
        </td>
    </tr> 

    <tr id="tabCHD" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td colspan="3">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td>&nbsp;# Vessel>50% &nbsp;<asp:TextBox runat="server" ID="txtNumVessel" ToolTip="Number of Vessels with >50% Stenosis" MaxLength="3" Columns="2" BackColor="AntiqueWhite"/></td>
                                <td nowrap><asp:CheckBox runat="server" ID="chkLM" Text="LM" ToolTip="Left Main" /><asp:CheckBox runat="server" ID="chkLAD" Text="LAD" ToolTip="Left Anterior Descending" /><asp:CheckBox runat="server" ID="ChkRCA" Text="RCA"/><asp:CheckBox runat="server" ID="ChkLCX" Text="LCX"/>&nbsp;</td>
                                <td><asp:CheckBox runat="server" ID="chkACS" style="font-family:Arial Black" Text="ACS" onClick="return ACS(this.checked)" ToolTip="Acute Coronary Syndrome"/></td>
                                <td><asp:CheckBox runat="server" ID="chkPCI" style="font-family:Arial Black" Text="PCI, CABG" onClick="return PCI(this.checked)" ToolTip="PCI, CABG"/></td>
                                <td><asp:CheckBox runat="server" ID="chkSTENUSIS" Text="STABLE ANG" style="font-family:Arial Black" onClick="return StableAng(this.checked)" ToolTip="Stable Angina"/></td>
                                <td>&nbsp;LVEF &nbsp;<asp:TextBox runat="server" ID="TxtHF" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox></td>
                            </tr>

                            <tr runat="server" id="pnlACS" style="display:none;background-color:#CCFFEE">
                                <td colspan="6">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Acute Coronary Syndrome
                                            </td>
                                        </tr>
                                        <tr>
                                             <td><asp:CheckBox runat="server" ID="Chkang24" Text=">=2 Angina/24hr" /></td>
                                             <td><asp:CheckBox runat="server" ID="ChkAn20" Text="Angina>20min" /></td>
                                             <td><asp:CheckBox runat="server" ID="ChkASA" Text="ASA Use in Past 1 Week" /></td>
                                             <td><asp:CheckBox runat="server" ID="Chktrop" Text="Positive Trop I or T" /></td>
                                             <td><asp:CheckBox runat="server" ID="ChkAnAn" Text=">=2 Antanginal" /></td>
                                        </tr>
                                        <tr>
                                             <td><asp:CheckBox runat="server" ID="chkSTEMI" Text="STEMI" style="font-family:Arial Black" onClick="return STEMI(this.checked)"/></td>
                                              
                                            <td><asp:CheckBox runat="server" ID="chkrefractory" Text="Refractory Angina" /></td>
                                             <td><asp:CheckBox runat="server" ID="chkchangetrop" Text="Changing Trop I" /></td>
                                        </tr>

                                        <tr runat="server" id="pnlSTEMI" style="display:none;background-color:#72E6BF">
                                            <td colspan="5">
                                                <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                    <tr>
                                                        <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; STEMI&nbsp;&nbsp;&nbsp;&nbsp; Time to Intervention/hours &nbsp;&nbsp;<asp:TextBox runat="server" ID="TxtSTEMIdur" Text="" MaxLength="3" Columns="3" BackColor="AntiqueWhite"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="chkanterior" Text="Anterior" /></td>
                                                        <td><asp:CheckBox runat="server" ID="chkinferior" Text="Inferior" /></td>
                                                        <td><asp:CheckBox runat="server" ID="chkother" Text="Other" /></td> 
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>

                                    </table>
                                </td>
                            </tr>

                            <tr runat="server" id="pnlPCI" style="display:none;background-color:#CCFFEE">
                                <td colspan="6">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; PCI / CABG &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            </td>
                                        </tr>
                                        <tr>
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">Last procedure  &nbsp;<asp:TextBox runat="server" ID="Txtprocedure" MaxLength="3" Columns="2" BackColor="AntiqueWhite"></asp:TextBox> week(s) ago, leave blank if there has been less than 1 week since last revascularization procedure or revascularization planned but not performed yet</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkBMS" Text="BMS" /></td>
                                            <td><asp:CheckBox runat="server" ID="ChkDES" Text="DES" /></td>
                                            <td><asp:CheckBox runat="server" ID="ChkCABG" Text="CABG" style="font-family:Arial Black" onClick="return CABG(this.checked)" ToolTip="Coronary Artery Bypass Graft"/></td>                  
                                        </tr>

                                        <tr runat="server" id="pnlCABG" style="display:none;background-color:#72E6BF">
                                            <td colspan="3">
                                                <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                    <tr>
                                                        <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; Coronary Artery Bypass Graft</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="chkautovein" Text="Auto Vein" /></td>
                                                        <td><asp:CheckBox runat="server" ID="chkautoartery" Text="Auto Artery" /></td>
                                                        <td><asp:CheckBox runat="server" ID="chknonauto" Text="Non Auto" /></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>

                                     </table>
                                </td>
                            </tr>

                            <tr runat="server" id="pnlStableAng" style="display:none;background-color:#CCFFEE">
                                <td colspan="6">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Stable Angina
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkNYHA1_2" Text="NYHA/CCVS CLASS 1" /></td>
                                            <td><asp:CheckBox runat="server" ID="ChkNYHA2_2" Text="NYHA/CCVS CLASS 2" /></td>
                                            <td><asp:CheckBox runat="server" ID="ChkNYHA3_2" Text="NYHA/CCVS CLASS 3" /></td>
                                            <td><asp:CheckBox runat="server" ID="ChkNYHA4_2" Text="NYHA/CCVS CLASS 4" /></td>                
                                        </tr>
                                     </table>
                                </td>
                            </tr>

                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkCTO" Text="Chronic Total Occlusion"/></td>
                                <td><asp:CheckBox runat="server" ID="Chkcoraneurysm" Text="Coronary Aneurysm"/></td>
                                <td><asp:CheckBox runat="server" ID="Chkcordissection" Text="Coronary Dissection"/></td>
                                <td><asp:CheckBox runat="server" ID="Chkcalcified" Text="Calcified Coronary Lesion"/></td>
                                <td><asp:CheckBox runat="server" ID="Chklipidrich" Text="Lipid Rich Plaque"/></td>
                                <td><asp:CheckBox runat="server" ID="Chkvasospasm" Text="Documented Vasospasm"/></td>
                            </tr>
                        </table>
                    </td>
                </tr>
 
            </table>
         </td>
     </tr> 

    <tr id="tabHfailure" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td colspan="3">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td>
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                         <tr style="border:1px solid black;">
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;">Heart Failure History&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LVEF  <asp:TextBox runat="server" ID="txtCHF" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox></td>
                                        </tr>   
                                      <tr>
                                          <tr>
                                        
                                          <td>&nbsp;<asp:Label runat="server">If known, HF Duration / week(s)</asp:Label><asp:TextBox runat="server" ID="txtdur" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox></td>
                                          <td><asp:CheckBox runat="server" ID="Chkfoutpt" Text="Previous HF Hospitalization" /> </td>
                                          <td><asp:CheckBox runat="server" ID="chkICD" Text="S/P ICD" /> </td>
                                          </tr>       
                                       </tr>   
                                        <tr style="border:1px solid black;">
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;">Etiology - Please checkmark Hypertension(SAH), Coronary Heart Disease (CHD), DM, OSA as applicable</td>
                                        </tr>   
                                      
                                        <tr>
                                            <td width="38%">
                                                <asp:CheckBox runat="server" ID="ChkNonischemicCMP" Text="Idiopathic/DCM/Nonischemic/Unknown" />
                                            </td>
                                            <td width="38%"><asp:CheckBox runat="server" ID="chkMI" Text="Post MI > 45 days" ToolTip="Myocardial Infarction > 45 days old" style="font-family:Arial Black" onClick="return PostMI(this.checked)"/></td>
                                            <td width="24%" style="border-bottom:none;"><asp:CheckBox runat="server" ID="ChkIschemic" Text="Ischemic/Post MI < 45 days" /></td>
                                        </tr>

                                        <tr runat="server" id="pnlPostMI" style="display:none;background-color:#CCFFEE">
                                            <td colspan="3">
                                                <table width="100%">
                                                    <tr>
                                                        <td style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Post MI > 45 days</td>
                                                    </tr>
                                                    <tr>
                                                        <td><asp:CheckBox runat="server" ID="chkLVaneurysm" Text="LV Aneurysm" /></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>

                                        <tr>
                                            <td>
                                                <asp:CheckBox runat="server" ID="ChkCardiotoxins" Text="Cardiotoxins" />
                                            </td>
                                            <td>
                                                <asp:CheckBox runat="server" ID="ChkFamHXofCMP" Text="Familial CMP Associated with Sudden Death" ToolTip="Familial Cardiomyopathy associated with Sudden Death"/>
                                            </td>
                                           <td>
                                                <asp:CheckBox runat="server" ID="Chkmyocarditis" Text="Myocarditis"/>
                                            </td>
                                        </tr> 
                                        <tr>
                                            <td>
                                                <asp:CheckBox runat="server" ID="ChkSuspectedRVDysplasia" Text="RV Dysplasia" />
                                            </td>
                                            <td><asp:CheckBox runat="server" ID="ChkIschemicCMP" style="font-family:Arial Black" Text="HOCM" onClick="return IschemicCMP(this.checked)"/>
                                            </td>
                                            <td><asp:CheckBox runat="server" ID="Chkrestrictive"  Text="Peripartum CMP" /></td>
                                        </tr>

                                        <tr runat="server" id="pnlIschemicCMP" style="display:none;background-color:#CCFFEE">
                                            <td colspan="3">
                                                <table width="100%">
                                                    <tr>
                                                        <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; HCMP Sudden Death Risk Factors</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="33%"><asp:CheckBox runat="server" ID="ChkLVHGreater30" Text="LVH >= 30mm" /></td>
                                                        <td><asp:CheckBox runat="server" ID="ChkAbnormBP" Text="Abnormal BP Response to Exercise" /></td>
                                                        <td><asp:CheckBox runat="server" ID="ChkFamHistSuddenDeath" Text="Family History of Sudden Death" /></td>
                                                    </tr>
                                                    <tr>
                                                         <td colspan="3"><asp:CheckBox runat="server" ID="ChkLVOT" Text="Rest or Dynamic Peak LVOT Gradient > 50mmHg" /></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                            
                                    </table>
                                </td>
                            </tr>
                            
                             <tr>
                                <td>
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr style="border:1px solid black;">
                                            <td colspan="2" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;">Stage / Class, applicable if Heart Failure diagnosis is certain</td>
                                        </tr>
                                        <tr>
                                            <td width="50%">
                                                <asp:CheckBox runat="server" ID="chkA" Text="High Risk for HF, but without Structural Heart Disease" />
                                            </td>
                                            <td width="50%">
                                                <asp:CheckBox runat="server" ID="chkB" Text="Structural Heart Disease, but without Signs and Symptoms of HF" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <asp:CheckBox runat="server" ID="chkC" Text="Structural Heart Disease with Prior or Current Symptoms of HF" />
                                            </td>
                                            <td>
                                                <asp:CheckBox runat="server" ID="chkD" style="font-family:Arial Black" Text="Refractory HF Requiring Specialized Interventions" onClick="return chkD(this.checked)"/>
                                            </td>
                                        </tr>
                                        
                                        <tr runat="server" id="pnlD" style="display:none;background-color:#CCFFEE">
                                            <td colspan="2">
                                                <table width="100%">
                                                    <tr>
                                                        <td colspan="2" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Refactory HF Requiring Specialized Interventions</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2">Calculate HFSS, enter NAmeq, VO2max, Heart Rate, and ECG QRS Duration</td>
                                                    </tr>
                                                    <tr>
                                                        <td width="50%">            
                                                            <asp:CheckBox runat="server" ID="Chkcom" Text="No Significant Comorbidities"></asp:CheckBox>
                                                        </td>
                                                        <td>             
                                                             &nbsp;VO2 max kg/<asp:TextBox runat="server" ID="TxtVO2" MaxLength="2" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>
                                                        </td>
                                                    </tr>
                                                 </table>
                                            </td>
                                        </tr>

                                         <tr>
                                            <td>
                                                <asp:CheckBox runat="server" ID="ChkNYHA1" Text="NYHA/CCVS CLASS 1" />
                                            </td>
                                            <td>
                                                <asp:CheckBox runat="server" ID="ChkNYHA2" Text="NYHA/CCVS CLASS 2" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <asp:CheckBox runat="server" ID="ChkNYHA3" Text="NYHA/CCVS CLASS 3" />
                                            </td>
                                            <td>
                                                <asp:CheckBox runat="server" ID="ChkNYHA4" Text="NYHA/CCVS CLASS 4" />
                                            </td>
                                        </tr>
                                                                                    
                                    </table>                    
                                </td>
                            </tr>
                
                            
                        </table>
                    </td>
                </tr>
 
            </table>
         </td>
     </tr> 
     
     <tr id="tabAF" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td colspan="4">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td><asp:CheckBox runat="server" ID="Chkparoxysmal" Text="Paroxysmal AF"/></td>
                                <td><asp:CheckBox runat="server" ID="Chkpersistent" Text="Persistent AF"/></td>
                                <td><asp:CheckBox runat="server" ID="ChkchronicAF" Text="Chronic AF"/></td>
                                <td><asp:CheckBox runat="server" ID="Chkablation" Text="S/P Successful Ablation"  /></td>
                             </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="Chkpharm" Text="Ventricular Rate Control" /></td>
                                <td>&nbsp;Heart Rate with Activity &nbsp;<asp:TextBox runat="server" ID="TxtCMP" Text="" MaxLength="3" Columns="3" BackColor="AntiqueWhite"/></td>
                                <td><asp:CheckBox runat="server" ID="ChkVHD" Text="Symptomatic" style="font-family:Arial Black" onClick="return VHD(this.checked)" /></td>
                                <td></td>
                            </tr>

                            <tr runat="server" id="pnlVHD" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%">
                                        <tr>
                                            <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Symptomatic </td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="Chkacutely" Text="Acutely"/></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            
                             <tr>
                                <td><asp:CheckBox runat="server" ID="ChkCV" Text="Rhtym Control, CV/Antiarrthymic Planned"/></td>
                                <td><asp:CheckBox runat="server" ID="chkCAA" Text="Current Antiarrythmic Therapy" style="font-family:Arial Black" onClick="return CAA(this.checked)" /></td>
                                <td>&nbsp;Duration/Days&nbsp;<asp:TextBox runat="server" ID="Txtafd" Text="" MaxLength="3" Columns="3" BackColor="AntiqueWhite"/></td>
                                <td></td>
                             </tr>

                             <tr runat="server" id="pnlCAA" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%">
                                        <tr>
                                            <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Current Antiarrythmic Therapy</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkclass1AA" Text="Propafonone, Flecanide" /></td>
                                            <td><asp:CheckBox runat="server" ID="chkclass3AA" Text="Sotalol, Amiodarone, Multaq, Dofetilide" /></td>
                                        </tr>
                                    </table>
                                </td>
                             </tr>

                            <tr>
                                  <td><asp:CheckBox runat="server" ID="chkPrevious" Text="Previous Thromboembolic Event" style="font-family:Arial Black" onClick="return Previous(this.checked)" /></td>
                             </tr>


                            <tr runat="server" id="pnlPrevious" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%">
                                        <tr>
                                            <td style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Previous Thromboembolic Event </td>
                                        </tr>
                                        <tr>
                                            <td>Last Thromboembolic Event&nbsp;&nbsp;<asp:TextBox runat="server" ID="TxtPrevious" MaxLength="3" Columns="2" BackColor="AntiqueWhite"></asp:TextBox> month(s) ago</td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
         </td>
     </tr> 
   
     <tr id="tabThrombo" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr style="border:0">
                    <td style="border:0;">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">Thromboembolic/Thromboembolic Prevention/VKA Therapy &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp
                                <asp:CheckBox runat="server" ID="chkbldrisk" style="font-family:Arial Black" Text="Bleeding Risk" onClick="return bleed(this.checked)"/>&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp INR <asp:TextBox runat="server" ID="txtINR" MaxLength="4" Columns="5" BackColor="AntiqueWhite"></asp:TextBox></td>
                            </tr>

                            <tr runat="server" id="pnlBleed" style="display:none;background-color:#72E6BF">
                                <td colspan="3">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Patient Related Bleed Risk</td>
                                        </tr>
                                        
                                        <tr>    
                                            <td><asp:CheckBox runat="server" ID="ChkICU" Text="ICU or CCU Admission" /></td>
                                            <td><asp:CheckBox runat="server" ID="ChkCVC" Text="Central Venous Catheter" /></td>
                                            <td><asp:CheckBox runat="server" ID="Chkplt" Text="Platelet Count < 50 × 109/L" /></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>


                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkDeepVenousThrombosis" Text="Deep Venous Thrombosis, RLE"/></td>
                                <td><asp:CheckBox runat="server" ID="chkDeepVenous" Text="Deep Venous Thrombosis, LLE"/></td>
                                <td><asp:CheckBox runat="server" ID="chkDVTprevention" style="font-family:Arial Black" Text="DVT/PE Diagnosis/Prevention" onClick="return DVTPrevention(this.checked)"/></td>
                            </tr>

                            <tr runat="server" id="pnlDVTPrevention" style="display:none;background-color:#CCFFEE">
                                <td colspan="3">
                                    <table width="100%">
                                        <tr>
                                            <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; DVT/PE Diagnosis/Prevention</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="Chkgeneral" Text="Majorsurgery/Trauma" /></td>
                                            <td><asp:CheckBox runat="server" ID="Chkurology" Text="Major Gyn/Urology" /></td>
                                            <td><asp:CheckBox runat="server" ID="Chkknee" Text="TKR" /></td>
                                            <td><asp:CheckBox runat="server" ID="Chkhip" Text="THR" /></td>
                                        </tr>
                                        <tr>    
                                            <td><asp:CheckBox runat="server" ID="ChkHPS" Text="Hip Fracture" /></td>
                                            <td><asp:CheckBox runat="server" ID="Chkcancer" Text="Spine Surgery" /></td>
                                            <td><asp:CheckBox runat="server" ID="Chkspinal" Text="Spinal Cord Injury" /></td>
                                            <td colspan="2"><asp:CheckBox runat="server" ID="Chkacute" style="font-family:Arial Black" Text="Medical Illness" onClick="return MedicalIllness(this.checked)"/></td>
                                        </tr>
                                        
                                        <tr runat="server" id="pnlMedicalIllness" style="display:none;background-color:#72E6BF">
                                            <td colspan="5">
                                                <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                                     <tr>
                                                        <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; &#10152; Medical Illness</td>
                                                     </tr>
                                                     <tr>
                                                        <td ><asp:CheckBox runat="server" ID="Chkswelling" Text="Painful Deep Venous Palpation and Edema" /></td>
                                                        <td><asp:CheckBox runat="server" ID="Chkactivecancer" Text="Active Cancer" /></td>
                                                        <td><asp:CheckBox runat="server" ID="ChkRF" Text="Respiratory Failure" /></td>
                                                        <td><asp:CheckBox runat="server" ID="Chkthrombo" Text="Already Known Thrombophilic Condition" /></td>
                                                     </tr>
                                                     <tr>   
                                                        <td><asp:CheckBox runat="server" ID="ChkRecent" Text="Recent (≤1mo) Trauma and/or Surgery" /></td>
                                                        <td><asp:CheckBox runat="server" ID="ChkReduced" Text="Reduced Mobility, Anticipated >= 3 days" /></td>
                                                        <td><asp:CheckBox runat="server" ID="Chkhormone" Text="Ongoing Hormonal Treatment" /></td>
                                                        <td><asp:CheckBox runat="server" ID="Chkinfection" Text="Acute Infection and/or Rheumatologic Disorder" /></td>  
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        
                                    </table>
                                </td>
                            </tr>

                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkPE" style="font-family:Arial Black" Text="Pulmonary Embolism" onClick="return PE(this.checked)" /></td>
                               <td><asp:CheckBox runat="server" ID="chkacutecva" style="font-family:Arial Black" Text="Acute CVA" onClick="return acuteCVA(this.checked)"/></td>
                            </tr>
                            
                            <tr runat="server" id="pnlPE" style="display:none;background-color:#CCFFEE">
                                <td colspan="3">
                                    <table width="100%">
                                        <tr>
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Pulmonary Embolism </td>
                                        </tr>
                                        <tr>
                                            
                                            <td><asp:CheckBox runat="server" ID="chksaddle" Text="Saddle"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkseptic" Text="Septic"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkotherPE" Text="Other"/></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>

                            <tr runat="server" id="pnlAcuteCVA" style="display:none;background-color:#CCFFEE">
                                <td colspan="3">
                                    <table width="100%">
                                        <tr>
                                            <td colspan="5" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Acute CVA</td>
                                        </tr>
                                        <tr>
                                            <td>NIHSS <asp:TextBox runat="server" ID="txtNIHSS" MaxLength="3" Columns="5" BackColor="AntiqueWhite"></asp:TextBox></td>
                                            <td><asp:CheckBox runat="server" ID="CheckBox1" Text="Unilateral Weakness" /></td>
                                            <td><asp:CheckBox runat="server" ID="CheckBox2" Text="Speech Disturbance" /></td>
                                            <td>&nbsp;&nbsp;Duration of Symptoms  <asp:TextBox runat="server" ID="ssdur" MaxLength="2" Columns="3" BackColor="AntiqueWhite"></asp:TextBox></td>
                                            <td><asp:CheckBox runat="server" ID="chkpreh" Text="Pre Hospital Care"/></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>

                            <tr>
                                <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">Valvular Heart Disease&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp<asp:CheckBox runat="server" ID="Chksysemb" Text="Systemic Embolism"/></td>
                            </tr>                            
                            <tr>
                                <td><asp:CheckBox runat="server" ID="Chkcage" Text="Mechanical Cageball" /></td>
                                <td><asp:CheckBox runat="server" ID="chkmech" Text="Mechanical Disk/Bileaflet Mitral" /></td>
                                <td><asp:CheckBox runat="server" ID="chkMdav" Text="Mechanical Disk/Bileaflet Aortic" /></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkRMVD" style="font-family:Arial Black" Text="Rheumatic Mitral Valve Disease" onClick="return RMVD(this.checked)"/></td>
                                <td><asp:CheckBox runat="server" ID="chkbiop" Text="Bioprosthetic Valve" /></td>
                                <td></td>
                            </tr>
                            
                            <tr runat="server" id="pnlRMVD" style="display:none;background-color:#CCFFEE">
                                <td colspan="3">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="2" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Rheumatic Mitral Valve Disease</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="ChkLAthr" Text="LA Thrombus" /></td>
                                            <td>&nbsp;LA Diameter&nbsp;&nbsp;<asp:TextBox runat="server" ID="txtLAd" MaxLength="3" Columns="5" BackColor="AntiqueWhite"></asp:TextBox></td>
                                        </tr>
                                     </table>
                                </td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkIE" Text="Infective Endocarditis" /></td>
                                <td><asp:CheckBox runat="server" ID="chkLPVT" Text="Left Sided PV Thrombosis" /></td>
                                <td><asp:CheckBox runat="server" ID="chkRPVT" Text="Right Sided PV Thrombosis" /></td>
                            </tr>    
                            <tr>
                                <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">Cardiac Source of Embolism / Miscellaneous&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <asp:CheckBox runat="server" ID="chkArterialIschemic" Text="Non Acute Arterial Ischemic Stroke" /></td>
                            </tr>                                
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkAorticArchAth" Text="Aortic Arch Atherosclerosis" /></td>
                                <td><asp:CheckBox runat="server" ID="ChkLVt" Text="LV Thrombus" /></td>
                                <td><asp:CheckBox runat="server" ID="chkPFO" Text="PFO" /></td>
                            </tr>                                     
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkMVP" Text="MVP" /></td>
                                <td><asp:CheckBox runat="server" ID="chkMitralAnnular" Text="Mitral Annular Calcification" /></td>
                                <td><asp:CheckBox runat="server" ID="chkCalcificAortic" Text="Calcific Aortic Valve Disease" /></td>
                            </tr>         
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkHeparinIndThrom" Text="HIT" /></td>
                                <td><asp:CheckBox runat="server" ID="ChkApoA1" Text="Hypercoagulable State"></asp:CheckBox></td>
                                <td><asp:CheckBox runat="server" ID="chkCerebralVenous" Text="Cerebral Venous Thrombosis" /></td>
                            </tr>  
                               <tr>
                                <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">Procedural Bleed Risk  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:CheckBox runat="server" ID="chkprior"  Text="Prior Bleed During Bridging or Similar Procedure"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:CheckBox runat="server" ID="chkpriorASA"  Text="Prior ASA Use"/></td>
                            </tr>                                
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkminorpro" Text="Procedural Bleed Risk not Clinically Important or Low" /></td>
                                <td><asp:CheckBox runat="server" ID="chksurgery" Text="Procedural Bleed Risk Uncertain" /></td>
                                <td><asp:CheckBox runat="server" ID="chkemergencysurgery" Text="Procedural Bleed Risk Intermediate or High" /></td>
                            </tr>             
                        </table>
                    </td>
                </tr>
             </table>
         </td>   
    </tr>
    
    <tr id="tabValvular" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td>
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td><asp:CheckBox runat="server" ID="Chkvalvular" Text="Valvular Heart Disease" style="font-family:Arial Black" onClick="return SwitchToPAH(this.checked)"/></td>
                            </tr>
                        </table>                    
                    </td>
                </tr>  
            </table>
        </td>   
    </tr>

     <tr id="tabVentricular" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td colspan="3">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td><asp:CheckBox runat="server" ID="ChkNSVT" Text="NSVT" ToolTip="Nonsustained Ventricular Tachycardia"/></td>
                                <td><asp:CheckBox runat="server" ID="chkMVT" Text="Monomorphic VT" /></td>
                                <td><asp:CheckBox runat="server" ID="chkRMVT" Text=" Repetetive Monomorphic VT" /></td>
                                <td><asp:CheckBox runat="server" ID="chkPVT" Text="Polymorphic VT" /></td>
                                <td><asp:CheckBox runat="server" ID="chkTors" Text="Torsades" /></td>
                                <td><asp:CheckBox runat="server" ID="chkIVT" Text="Incessant VT" /></td>
                                <td><asp:CheckBox runat="server" ID="chkidioVT" Text="Idiopathic VT" /></td>
                            </tr>
                        </table>
                    </td>
                </tr>          
            </table>
        </td>   
    </tr>

    <tr id="tabBrady" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td colspan="3">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td width="50%"><asp:CheckBox runat="server" ID="ChkSinusNodeDysfunction" Text="Symtomatic Sinus Node Dysfunction" /></td>
                                <td><asp:CheckBox runat="server" ID="ChkAVNodeDisease" Text="High Grade AV Node Disease" /></td>                                            
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="ChkVasoDepressorSyncope" Text="Isolated Neurocardiogenic Syncope / Unexplained Syncope" /></td>
                                <td><asp:CheckBox runat="server" ID="ChkCarotidSinusHypersensitivity" Text="Carotid Sinus Hypersensitivity" /></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="ChkPosturalOrthostatisTac" Text="POTS (Enter Standing Heart Rate Above)" /></td>
                                <td><asp:CheckBox runat="server" ID="ChkAutonomicFailureSyndrome" Text="Autonomic Failure Syndrome" /></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="ChkHistCardArrest" Text="History of Cardiac Arrest" /></td>
                                <td><asp:CheckBox runat="server" ID="ChkBrugada" Text="Brugada Syndrome" /></td>                                             
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="ChkLongQT" Text="LongQT" /></td>
                                <td><asp:CheckBox runat="server" ID="Chksarc" Text="Sarcoidosis/Giant Cell/Chagas" /></td>                                             
                            </tr>
                        </table>
                    </td>
                </tr>          
            </table>
        </td>   
    </tr>

    <tr id="tabSurgical" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td colspan="2">
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td><asp:CheckBox runat="server" ID="Chkemergency" Text="Emergency Surgery" /></td>
                                <td><asp:CheckBox runat="server" ID="Chkelective" Text="Intermediate Risk (Intraperiteneal, Symptomatic CEA, Major Orthopedic, Head and Neck, Endovascular, Major GYN-Uoloical)"/></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="Chkvascular" Text="High Risk (Aorta, Major Vascular, Duedeno-Pancreas, Biliary, Adrenal Resection, Pneumectomy, Total Cystectomy)" /></td>
                                <td><asp:CheckBox runat="server" ID="Chklowriskelec" Text="Low Risk Surgery (Cataract, Plastic, TURP, Asymptomatic CEA, Thyroid, Reconstructive, Minor GYN)" /></td>  
                            </tr>
                            <tr>
                                <td>METS <asp:TextBox runat="server" ID="TxtMETS" MaxLength="3" Columns="5" BackColor="AntiqueWhite"/></td>
                                <td>Duke Activity Status Index <asp:TextBox runat="server" ID="TxtDASI" MaxLength="3" Columns="5" BackColor="AntiqueWhite"/></td>
                            </tr>
                            <tr>
                                <td style="border: 1px solid black;"><asp:CheckBox runat="server" ID="Chkunab" Text="Unable to Exercise, Physically Inactive" /></td>
                            </tr>
                           </table>
                    </td>
                </tr>          
            </table>
        </td>   
    </tr>

     <tr>
        <td style="height:20px;"></td>
    </tr>
    <tr>
        <td>
            <table>
                <tr>
                    <td><label id="lblSCD" class="flag tabActive" onclick="return SCD()">Symptomatic Carotid Disease</label></td>
                    <td><label id="lblPVD" class="flag tabActive" onclick="return PVD()">Peripheric Vascular Disease</label></td>
                    <td><label id="lblAAA" class="flag tabActive" onclick="return AAA()">Aortic Aneurysm</label></td>
                    <td><label id="lblDiabetes" class="flag tabActive" onclick="return Diabetes()">Diabetes</label></td>
                    <td><label id="lblRiskFactors" class="flag tabActive" onclick="return RiskFactors()">Major CV Risk Factors</label></td>
                </tr>
            </table>
        </td>
    </tr>

    <tr id="tabSCD" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td>
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkNoncardioCVA" Text="Noncardioembolic CVA Assocaiated with Carotid Plaque"/></td>
                                <td><asp:CheckBox runat="server" ID="chkNoncardioTIA" Text="Noncardioembolic TIA Assocaiated with Carotid Plaque"/></td>
                                <td><asp:CheckBox runat="server" ID="chkCEA" Text=">= 50% Carotid Stenosis / S/P CEA " /></td>
                            </tr>
                        </table>                    
                    </td>
                </tr>       
            </table>
        </td>   
    </tr>

    <tr id="tabPVD" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td>
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkABI" Text="ABI < 0.9" /></td>
                                <td><asp:CheckBox runat="server" ID="Chkbypass" Text="Endovascular Revascularization" /></td>
                                <td><asp:CheckBox runat="server" ID="ChkBKbypass" Text="Peripheral Artery Bypass Graft" /></td>
                            </tr>
                            <tr>
                                <td><asp:CheckBox runat="server" ID="Chkcritical" Text="Critical Limb Ischemia" /></td>
                            </tr>
                        </table>                    
                    </td>
                </tr>       
            </table>
        </td>   
    </tr>

    <tr id="tabAAA" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td>
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkAADiameter" Text="AAA, Diameter > 5cm"/></td>
                                <td><asp:CheckBox runat="server" ID="chkthoracic" Text="Thoracic Aortic Aneurysm"/></td>
                                <td><asp:CheckBox runat="server" ID="chkthoracoabdominal" Text="Thoracoabdominal Aortic Aneurysm"/></td>
                            </tr>
                        </table>                    
                    </td>
                </tr>       
            </table>
        </td>   
    </tr>

    <tr id="tabDiabetes" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td>
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkDM" Text="Type II DM" ToolTip="Type 2 Diabetes Mellitus" style="font-family:Arial Black" onClick="return DM(this.checked)"/></td>
                                <td><asp:CheckBox runat="server" ID="chkDM1" Text="Type I DM" ToolTip="Type 1 Diabetes Mellitus" style="font-family:Arial Black" onClick="return DM1(this.checked)"/></td>
                                <td><asp:CheckBox runat="server" ID="chkgestational" Text="Gestational DM" ToolTip="Type 1 Diabetes Mellitus"/></td>
                                <td><asp:CheckBox runat="server" ID="ChkRetinopathy" Text="Retinopathy"/></td>
                            </tr>

                            <tr id="pnlDM" runat="server" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table  width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr>
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Diabetes Complications</td>
                                        </tr>
                                        <tr>
                                            <td width="33%"><asp:CheckBox runat="server" ID="chkDMNP" Text="Diabetic Nephropathy"/></td>
                                            <td width="33%"><asp:CheckBox runat="server" ID="chkDMCKD" Text="Diabetic CKD"/></td>
                                            <td width="33%"><asp:CheckBox runat="server" ID="chkDMother" Text="Other Kidney Complication"/></td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkDMmono" Text="Mononeuropathy"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkDMpoly" Text="Polyneuropathy"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkDMautonom" Text="Autonom Neuropathy"/></td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkDMangio" Text="Peripheral Angiopathy"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkDMgangrene" Text="Angiopathy with Gangrene"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkDMothercirc" Text="Other Circulatory "/></td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkDMarthro" Text="Diabetic Arthropathy"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkDMskin" Text="Skin Complications"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkDMoral" Text="Oral Complications "/></td>
                                
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkDMhypo" Text="Hypoglycemia"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkDMhypocoma" Text="Hypoglycemia without Coma"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkDMhyper" Text="Hyperglycemia"/></td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkDMothercomp" Text="Other Spec Complication"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkDMunspec" Text="Unspecified Complication"/></td>
                                            <td><asp:CheckBox runat="server" ID="chkDMwithout" Text="Without Complication"/></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>    
                    </td>
                </tr>
            </table>
        </td>   
    </tr>

    <tr id="tabRiskFactors" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td>
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td width="20%"><asp:CheckBox runat="server" ID="chkSAH" style="font-family:Arial Black" Text="Hypertension" onClick="return SAH(this.checked)"/></td>
                                <td width="20%"><asp:CheckBox runat="server" ID="chkSmoke" Text="Tobacco Use" ToolTip="Smoking"/></td>
                                <td width="20%"><asp:CheckBox runat="server" ID="chkFamily" Text="Family History" ToolTip="Family history of premature coronary heart disease defined as 1s"/></td>
                                
                            </tr>

                            <tr runat="server" id="pnlSAH" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr style="border:1px solid black;">
                                            <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Systemic Arterial Hypertension - Please checkmark LVH on ECG if applicable</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="chkSBPTreated" Text="SBP Treated" ToolTip="Systemic Hypertension Treated"/></td>
                                            <td colspan="3"><asp:CheckBox runat="server" ID="chkAA" Text="African American"/></td>
                                        </tr>
                                        <tr style="border:1px solid black;">
                                            <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Secondary Hypertension</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="Chkaldo" Text="Primary Hyperaldesteronism" /></td>
                                            <td><asp:CheckBox runat="server" ID="Chkrenovas" Text="Renovascular, Atheroscleotic" /></td>
                                            <td><asp:CheckBox runat="server" ID="ChkFMD" Text="Pheocromocytoma" /></td>
                                        </tr>
                                        <tr style="border:1px solid black;">
                                            <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Acutely Symptomatic</td>
                                        </tr>
                                        <tr>
                                            <td><asp:CheckBox runat="server" ID="Chkhead" Text="Headache, Blurred Vision or AMS" /></td>
                                            <td><asp:CheckBox runat="server" ID="Chkepis" Text="Epistaxis" /></td>
                                            <td colspan="2"><asp:CheckBox runat="server" ID="ChkCP" Text="Chest Back Pain/Dyspnea" /></td>
                                        </tr>                                            
                                    </table>    
                                </td>
                            </tr>  
                           
                            
                        </table>    
                    </td>
                </tr>
            </table>
        </td>   
    </tr>
   
     <tr>
        <td style="height:20px;"></td>
    </tr>
    <tr>
        <td>
            <table>
                <tr>
                    <td><label id="lblRenal" class="flag tabActive" onclick="return Renal()">Renal</label></td>
                    <td><label id="lblPulmonary" class="flag tabActive" onclick="return Pulmonary()">Pulmonary</label></td>
                    
                    <td><label id="lblHem" class="flag tabActive" onclick="return Hem()">Hematology</label></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td style="height:10px;"></td>
    </tr>
    <tr id="tabPulmonary" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                     <tr style="border:1px solid black;">
                                            <td colspan="3" style="background-color:#D3D3D3;font-weight:bold;color:red;border:1px solid black;">Pulmonary History&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FEV/lt <asp:TextBox runat="server" ID="txtFEV1" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>&nbsp;&nbsp;%FEV1 <asp:TextBox runat="server" ID="txtFEVP" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>&nbsp;&nbsp%FVC <asp:TextBox runat="server" ID="txtFVCP" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>&nbsp;&nbsp;%DLCO <asp:TextBox runat="server" ID="txtDLCO" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>&nbsp;&nbsp;PO2mmHg <asp:TextBox runat="server" ID="txtPO2" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:CheckBox runat="server" ID="chkhypercapnia" Text="Severe chronic hypercapnia"/></td>
                                        </tr>  
                    <td>
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                            <tr>
                                <td><asp:CheckBox runat="server" ID="chkasthma" Text=" Asthma " onClick="return asthma(this.checked)"/></td>
                                <td><asp:CheckBox runat="server" ID="chkILD" Text=" Interstitial lung disease "/></td>
                                <td><asp:CheckBox runat="server" ID="chkCOPD" Text="COPD" onClick="return COPD(this.checked)"/></td>
                            </tr>
                        </table>                    
                    </td>
                </tr> 
                 <tr runat="server" id="pnlasthma" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr style="border:1px solid black;">
                                            <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; Reactive airway disease</td>
                                        </tr>
                                        <tr>
                                            
                                             <td>&nbsp;Symptoms/week <asp:TextBox runat="server" ID="txtasymptoms" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox></td>
                                              <td>&nbsp;Nocturnal awakening/ week <asp:TextBox runat="server" ID="txtnocturnal" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox></td>
                                              <td>&nbsp;SABA use/ week <asp:TextBox runat="server" ID="txtSABA" MaxLength="3" Columns="3" BackColor="AntiqueWhite"></asp:TextBox></td>
                                             <td><asp:CheckBox runat="server" ID="chkinterference" Text="Interference with activity" onClick="return interference(this.checked)" /></td>

                                            
                                        </tr>
                                                                                
                                    </table>    
                                </td>
                      </tr>   
                <tr runat="server" id="pnlinterference" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr style="border:1px solid black;">
                                            <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; </td>
                                        </tr>
                                        <tr>
                                            
                                             <td><asp:CheckBox runat="server" ID="chknone" Text="None" /></td>
                                             <td><asp:CheckBox runat="server" ID="chkminor" Text=" Minor "/></td>
                                             <td><asp:CheckBox runat="server" ID="chksome" Text=" Some " /></td>
                                             <td><asp:CheckBox runat="server" ID="chksignificant" Text=" Significant " /></td>

                                            
                                        </tr>
                                                                                
                                    </table>    
                                </td>
                      </tr>  
                 <tr runat="server" id="pnlCOPD" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr style="border:1px solid black;">
                                            <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; COPD&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<asp:CheckBox runat="server" ID="chkexacerbation" Text="COPD exacerbation ( change in dyspnea or cough or sputum volume or character) "/></td>
                                        </tr>
                                        <tr>
                                            
                                             <td><asp:CheckBox runat="server" ID="chkCOPDex" Text=" More than one exacerbation/year " /></td>
                                             <td><asp:CheckBox runat="server" ID="chkCOPDhos" Text=" One or more hospital admission/year " /></td>
                                              
                                            
                                        </tr>
                                                                                
                                    </table>    
                                </td>
                      </tr>   
            </table>
        </td>   
    </tr>
    <tr id="tabRenal" style="display:none;">
        <td>
            <table class="tbltable2" width="100%" border="1" >
                <tr>
                    <td>
                        <table width="100%" style="border-collapse:collapse;border-style:hidden;">

                            <td width="20%"><asp:CheckBox runat="server" ID="chkCKD" style="font-family:Arial Black" Text="CKD " ToolTip="CKD" onClick="return CKD(this.checked)"/></td>
                            <td><asp:CheckBox runat="server" ID="ChkWG" Text="Acute renal failure" style="font-family:Arial Black" onClick="return WG(this.checked)"/></td>
                        </table>                    
                    </td>
                     <tr runat="server" id="pnlWG" style="display:none;">
                                
                                <td>Increase in SCr X baseline<br />
                                    <asp:TextBox runat="server" ID="txtcr" Columns="3" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>Increase in SCr by mg/dl in 48 hours<br />
                                    <asp:TextBox runat="server" ID="txtcrinc" Columns="5" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td>
                                <td>Urine volume ml/kg/h  <br />
                                    <asp:TextBox runat="server" ID="txturine" Columns="5" MaxLength="4" BackColor="AntiqueWhite"></asp:TextBox>
                                </td> 

                     </tr>
                    <tr runat="server" id="pnlCKD" style="display:none;background-color:#CCFFEE">
                                <td colspan="4">
                                    <table width="100%" style="border-collapse:collapse;border-style:hidden;">
                                        <tr style="border:1px solid black;">
                                            <td colspan="4" style="background-color:#D3D3D3;font-weight:bold;color:Red;border:1px solid black;">&#10152; CKD</td>
                                             
                                        </tr>
                                        <tr>
                                            
                                            <td><asp:CheckBox runat="server" ID="chkrenalimage" Text="Abnormal imaging" /></td>
                                             <td><asp:CheckBox runat="server" ID="chkhistology" Text="Abnormal histology" /></td>

                                            
                                        </tr>
                                                                                
                                    </table>    
                                </td>
                            </tr>   
                </tr>       
            </table>
        </td>   
    </tr>
    
    <tr>
        <td>
            <asp:Button runat="server" ID="btnCompute" Text="Compute" OnClick="btnCompute_Click" />&nbsp;
            <asp:Button runat="server" ID="btnSave" Text="Save Evaluation" OnClick="btnSave_Click" />
            <asp:Button runat="server" ID="btnSwitchtoPAH" style="display: none;" CausesValidation="False" OnClick="btnSwitchtoPAH_Click"/>
        </td>
    </tr>
</table>
</asp:Content>

