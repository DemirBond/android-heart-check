<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Outputs.aspx.cs" Inherits="Outputs" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <script type="text/javascript">
    


  function Assessment() {
      if (tabAssessment.style.display == "none")
      {
                $("#tabAssessment").fadeIn(250, "linear");
                $("#tabTheraupetics").fadeOut(250, "linear");
                $("#tabICD").fadeOut(250, "linear");
                $("#tabReferences").fadeOut(250, "linear");
                $("#tabDiagnostics").fadeOut(250, "linear");
                lblAssessment.className = "flag tabStill"
                lblDiagnostics.className = "flag tabActive"
                lblTherapeutics.className = "flag tabActive"
                lblICD.className = "flag tabActive"
                lblReferences.className = "flag tabActive"
            }
        }
function Diagnostics() {
    if (tabDiagnostics.style.display == "none")
    {
       $("#tabAssessment").fadeOut(250, "linear");
       $("#tabTheraupetics").fadeOut(250,"linear");
       $("#tabICD").fadeOut(250,"linear");
       $("#tabReferences").fadeOut(250,"linear");
       $("#tabDiagnostics").fadeIn(250, "linear");
       lblAssessment.className = "flag tabActive"
       lblDiagnostics.className = "flag tabStill"
       lblTherapeutics.className = "flag tabActive"
       lblICD.className = "flag tabActive"
       lblReferences.className = "flag tabActive"
    }
}

function Therapeutics() {
    if (tabTheraupetics.style.display == "none")
    {
       $("#tabAssessment").fadeOut(250, "linear");
       $("#tabICD").fadeOut(250,"linear");
       $("#tabReferences").fadeOut(250,"linear");
       $("#tabDiagnostics").fadeOut(250,"linear");
       $("#tabTheraupetics").fadeIn(250, "linear");
       lblAssessment.className = "flag tabActive"
       lblTherapeutics.className = "flag tabStill"
       lblDiagnostics.className = "flag tabActive"
       lblICD.className = "flag tabActive"
       lblReferences.className = "flag tabActive"
    }
}

function ICD() {
    if (tabICD.style.display == "none")
    {
       $("#tabAssessment").fadeOut(250, "linear");
       $("#tabReferences").fadeOut(250,"linear");
       $("#tabDiagnostics").fadeOut(250,"linear");
       $("#tabTheraupetics").fadeOut(250,"linear");
       $("#tabICD").fadeIn(250, "linear");
       lblAssessment.className = "flag tabActive"
       lblICD.className = "flag tabStill"
       lblTherapeutics.className = "flag tabActive"
       lblDiagnostics.className = "flag tabActive"
       lblReferences.className = "flag tabActive"
    }
}

function References() {
    if (tabReferences.style.display == "none")
    {
       $("#tabAssessment").fadeOut(250, "linear");
       $("#tabDiagnostics").fadeOut(250,"linear");
       $("#tabTheraupetics").fadeOut(250,"linear");
       $("#tabICD").fadeOut(250,"linear");
       $("#tabReferences").fadeIn(250, "linear");
       lblAssessment.className = "flag tabActive"
       lblReferences.className = "flag tabStill"       
       lblICD.className = "flag tabActive"
       lblTherapeutics.className = "flag tabActive"
       lblDiagnostics.className = "flag tabActive"
    }
}
    </script>
<head id="Head1" runat="server">
    <title>Outputs</title>
</head>
<body>
    <script src="js/jquery-1.3.2.js" type="text/javascript"></script>
    <form id="form1" runat="server">
    <div>
        <table width="100%">
            <tr>
                <td style="height:10px;"></td>
            </tr>
            <tr>
                <td>
                    <table width="100%" border="1" class="tbltable">
                        <tr class="trheader" style="font-size: 12px;">
                            <td>&nbsp;Input Summary</td>
                        </tr>
                        <tr>
                            <td><asp:Label ID="lblInputSummary" runat="server">
                            </asp:Label></td>
                        </tr>
                    </table>
                </td>                                                        
            </tr>
            <tr>
                <td style="height:10px;"></td>
            </tr>  
            <tr>
                <td colspan="3">
                    <table>
                        <tr class="trheader">
                             <td><label id="lblAssesment" class="flag tabActive" onclick="return Assessment()"> Assessment</label></td>
                            <td><label id="lblDiagnostics" class="flag tabActive" onclick="return Diagnostics()"> Diagnostics</label></td>
                            <td><label id="lblTherapeutics" class="flag tabActive" onclick="return Therapeutics()"> Therapeutics</label></td>
                            <td><label id="lblICD" class="flag tabActive" onclick="return ICD()">ICD 10</label></td>
                            <td><label id="lblReferences" class="flag tabActive" onclick="return References()"> Referrals / References</label></td>
                        </tr>
                    </table>
                  </td>
             </tr>
            <tr id="tabAssessment" style="display:none;height:0px;">
                <td>
                    <table width="100%" border="1" class="tbltable">
                        <tr>
                            <td>
                                  
                                  <asp:Label runat="server" ID="lblNiaspan4"></asp:Label>
                                  <asp:Label runat="server" ID="lblValvular" ></asp:Label>
                                 <asp:Label runat="server" ID="Contrain"></asp:Label>
                                
                            </td>
                        </tr>
                    </table>            
                </td>
            </tr>
            
            
            <tr id="tabDiagnostics" style="height:0px;">
                <td>
                <table width="100%" border="2" class="tbltable">
                    <colgroup>
                        <col width="40%" />
                        <col width="40%" />
                        <col width="20%" />
                    </colgroup>
                   <%-- <tr>
                        <td>
                            Target Non HDL--C: <asp:Label runat="server" ID="lblTargetHdl"></asp:Label>
                        </td>
                        <td>
                            TargetLdl--C : <asp:Label runat="server" ID="lblTargetLdl"></asp:Label>
                        </td>

                    </tr>--%>
                    <tr>
                        <td>
                            Target SBP: <asp:Label runat="server" ID="lblTargetSBP"></asp:Label>
                        </td>
                        <td>
                            Target DBP: <asp:Label runat="server" ID="lblTargetDBP"></asp:Label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <asp:Label runat="server" ID="lblNiaspan1"></asp:Label>
                            <asp:Label runat="server" ID="lblNiaspan2"></asp:Label>
                            <asp:Label runat="server" ID="lblNiaspan3"></asp:Label>
                          
                            <asp:Label runat="server" ID="lblNiaspan5"></asp:Label>
                        </td>
                    </tr>
                </table> 
                </td>           
            </tr>
                                  
            <tr id="tabTheraupetics" style="display:none;height:0px;">
                <td>
                    <table width="100%" border="1" class="tbltable">
                        <tr>
                            <td width="85%">
                                
                               <asp:Label runat="server" ID="lblIschemic"></asp:Label>
                                <asp:Label runat="server" ID="lblCHFandAF" ></asp:Label>
                                
                                <asp:Label runat="server" ID="lblTension"></asp:Label>
                                <asp:Label runat="server" ID="LabelLifevest"></asp:Label>
                                
                              
                                <asp:Label runat="server" ID="LabelSAH" Font-Name="Arial"></asp:Label>
                                <asp:Label runat="server" ID="LabelCOAG" Font-Name="Century"></asp:Label>
                               
                                <asp:Label runat="server" ID="lblStatin"></asp:Label>
                                <asp:Label runat="server" ID="LabelICD" Font-Name="Courier"></asp:Label>
                                <asp:Label runat="server" ID="lblStatinIntolerance"></asp:Label>
                            </td>
                            <td>
                                <asp:CheckBox runat="server" ID="chkStatinIntolerance" Text="Statin Intolerance" Visible="false" AutoPostBack="True"/>
                            </td>
                        </tr>
                    </table>                    
                </td>
            </tr>
            <tr id="tabICD" style="display:none;height:0px;">
                <td>
                    <table width="100%" border="1" class="tbltable">
                        <tr>
                            <td>
                                ICD-10 CM: <asp:Label runat="server" ID="ICD"></asp:Label>
                                
                            </td>
                        </tr>
                    </table>            
                </td>
            </tr>

            <tr id="tabReferences" style="display:none;height:0px;">
                <td>
                    <table width="100%" border="1" class="tbltable">
                        <tr>
                            <td>
                                <asp:Label runat="server" ID="lblreferral"></asp:Label>
                                <asp:Label runat="server" ID="lblRef1"></asp:Label>
                                <asp:Label runat="server" ID="lblRef2"></asp:Label>
                            </td>
                        </tr>
                    </table>                                        
                </td>
            </tr>            
            <tr>
                <td style="height:10px;"></td>
            </tr>
            <tr>
                <td align="center">
                    <asp:Button runat="server" ID="btnClose" Text="Close" OnClick="btnClose_Clicked" />
                </td>
            </tr>
        </table>    
    </div>
    </form>
</body>
</html>
