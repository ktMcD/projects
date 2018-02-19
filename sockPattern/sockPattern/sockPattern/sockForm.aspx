<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="sockForm.aspx.cs" Inherits="sockPattern.sockForm" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            font-family: Arial, Helvetica, sans-serif;
        }
        .auto-style2 {
            text-decoration: underline;
        }
        .auto-style6 {
            font-size: large;
            color: #FFFFFF;
            background-color: #CC0000;
        }
        .auto-style15 {
            width: 81%;
            height: 122px;
            position: relative;
            left: 0%;
            top: 0px;
        }
        .auto-style17 {
            text-align: center;
            width: 738px;
        }
        .auto-style18 {
            width: 141px;
        }
        .auto-style19 {
            color: #CC0000;
        }
        .auto-style21 {
            width: 140px;
            text-align: right;
        }
        .auto-style22 {
            width: 156px;
            text-align: right;
        }
        .auto-style23 {
            color: #000000;
        }
        .auto-style24 {
            font-family: "Times New Roman", Times, serif;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    
        <h1 class="auto-style1">Enter your Sock Measurements</h1>
        <p class="auto-style24">
            This is a pattern for a sock on two circular needles. Any pattern can be adapted for two-at-a-time.</p>
        <table class="auto-style15" style="padding: 2px; margin: 2px; border-style: none;">
            <tr>
                <td class="auto-style22">Foot Length:</td>
                <td class="auto-style18">
        <asp:TextBox ID="footLengthTextBox" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style17">&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style22">Foot Circumference:</td>
                <td class="auto-style18">
        <asp:TextBox ID="footWidthTextBox" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style17">&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style22">Stitches/Inch:</td>
                <td class="auto-style18">
        <asp:TextBox ID="spiTextBox" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style17">&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style22">Rows/Inch:</td>
                <td class="auto-style18">
        <asp:TextBox ID="rpiTextBox" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style17">&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style22">&nbsp;</td>
                <td class="auto-style18">
        <asp:Button ID="calcButton1" runat="server" OnClick="calcButton1_Click" Text="Calculate My Sock!" Width="137px" />
                </td>
                <td class="auto-style17"><strong>
        <asp:Label ID="inputErrorLabel" runat="server" CssClass="auto-style6"></asp:Label>
                    </strong></td>
            </tr>
        </table>
        <br />
        You entered the following data:<table style="width: 35%;">
            <tr>
                <td class="auto-style21">Foot Length:</td>
                <td>
                    <asp:Label ID="footLengthMeasLabel" runat="server"></asp:Label>
                </td>
            </tr>
            <tr>
                <td class="auto-style21">Foot Circumference:</td>
                <td>
                    <asp:Label ID="footCircMeasLabel" runat="server"></asp:Label>
                </td>
            </tr>
            <tr>
                <td class="auto-style21">Stitches/Inch:</td>
                <td>
                    <asp:Label ID="spiLabel" runat="server"></asp:Label>
                </td>
            </tr>
            <tr>
                <td class="auto-style21">Rows/Inch:</td>
                <td>
                    <asp:Label ID="rpiLabel" runat="server"></asp:Label>
                </td>
            </tr>
        </table>
        <br />
        Based on the measurements you entered, the sock will measure <asp:Label ID="sockMeasLengthLabel" runat="server" style="font-weight: 700" CssClass="auto-style19"></asp:Label>
&nbsp;inches long 
        <br />
        and
        <asp:Label ID="sockMeasCircLabel" runat="server" style="font-weight: 700" CssClass="auto-style19"></asp:Label>
&nbsp;inches around (assuming 10% ease for each measurement).<br />
        <br />
        The circumference of your sock, after the toe and before increasing for the gussett is:<br />
        <asp:Label ID="sockMeasCircLabel0" runat="server" CssClass="auto-style23"></asp:Label>
&nbsp;x
        <asp:Label ID="spiLabel0" runat="server"></asp:Label>
&nbsp;=
        <asp:Label ID="maxStitchesLabel0" runat="server" CssClass="auto-style23"></asp:Label>
        , rounded for convenience (see below).<br />
        <br />
        This pattern is adapted from one designed by Susan Glinert as published in Fleegle&#39;s Blog on Ravelry.com, available here:<br />
        <a href="http://www.ravelry.com/patterns/library/fleegles-toe-up-socks">http://www.ravelry.com/patterns/library/fleegles-toe-up-socks</a><br />
        <br />
        I first saw this heel ion Cat Bordhi&#39;s book &quot;Socks Soar on Two Circular Needles&quot;. It is a lovely no-wrap heel.<br />
        It works both top-down and toe-up. My modification includes a heel flap of sorts.
        <br />
        <br />
        <strong><span class="auto-style2">INSTRUCTIONS:</span><br class="auto-style2" />
        </strong>Using either <a href="https://www.youtube.com/watch?v=1pmxRDZ-cwo">Judy&#39;s Magic Cast-On</a> or the <a href="https://www.youtube.com/watch?v=KUl3uPfg4JY">Turkish Cast-On</a>, <strong>cast on 12, 14, 16 stitches (1/2 on each needle)</strong>.<br />
        I prefer the Turkish Cast-on because it doesn&#39;t create those ears on either side of your cast-on.<br />
        <br />
        This is often a matter of personal preference; if you&#39;re making a smaller sock, then casting on 12 stitches might work better.<br />
        If you&#39;re making a bigger sock then 16 stitches might do the trick.<br />
        In the alternative, I sometimes just cast on 1/4 of the total number of stitches you&#39;ll be using to knit after your toe increases<br />
        and       before your gusset increases. In this case that would be
        <asp:Label ID="oneQrtrOfMaxStsLabel" runat="server" style="font-weight: 700" CssClass="auto-style19"></asp:Label>
&nbsp;stitches (this may not be exaclty 1/4<br />
        of the stitches; we&#39;ve done some magic rounding in the background).<br />
        <br />
        Mark the needle that holds the first stitch of your round. This is Needle 1 (N1)<br />
        This will be your Gussett/Heel needle. The other needle will hold your instep stitches.<br />
        <br />
        Rnd 1: Knit around<br />
        Rnd 2: K2, inc 1, K to 3rd stitch before the end, inc 1, K2 to end<br />
        Rnd 3: Knit around<br />
        <br />
        Repeat Rnds 2 and 3 until there are
        <asp:Label ID="maxStitchesLabel" runat="server" style="font-weight: 700" CssClass="auto-style19"></asp:Label>
&nbsp;total stitches, or stitches on each needle.<br />
        <br />
        Add a lifeline here.<br />
        <br />
        Now, knit around until you have a tube approximately 2/3 the length of your sock<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (approximately <asp:Label ID="twoThirdsSockLengthLabel" runat="server" style="font-weight: 700" CssClass="auto-style19"></asp:Label>
&nbsp;inches).<br />
        This measurement represents the length of your sock from the toe to where the foot meets the leg at the ankle. It&#39;s an estimate.<br />
        Please adjust this if you need to get more granular.<br />
        <br />
        <span class="auto-style2"><strong>Now it&#39;s time to INCREASE FOR THE GUSSET:</strong></span><br />
        Add a lifeline here just in case you get messed up in your increases. I speak from experience here.<br />
        <br />
        Place 3 markers - 1 at every <asp:Label ID="quarterOfMaxStsLess2Label" runat="server" style="font-weight: 700" CssClass="auto-style19"></asp:Label>
        &nbsp;stitches.<br />
        It will probably be easier if you do this as you go. Whatever works best.<br />
        <br />
        Rnd 1 (Gusset/Heel needle): K2, inc 1, K to 3rd-to-last stitch on needle, inc 1, K2<br />
        Rnd 1 (Instep needle): knit around<br />
        <br />
        Rnd 2 (both needles): knit around<br />
        <br />
        Repeat Rnds 1 and 2 until there are
        <asp:Label ID="maxStsLess2Label" runat="server" style="font-weight: 700" CssClass="auto-style19"></asp:Label>
&nbsp;stitches on the Gusset/Heel needle,<br />
        ending with a Rnd 2 round on Instep needle.<br />
        <br />
        <span class="auto-style2"><strong>Now it&#39;s time to TURN THE HEEL</strong></span>:<br />
        Add a lifeline here. You may want to try different heels and a lifeline makes it easy to rip back and do something else (or fix mistakes).<br />
        <br />
        Working back and forth on the Gusset/Heel needle:<br />
        <br />
        Right Side (with knit stitches facing you) (&quot;<strong>RS</strong>&quot;): knit to 2 stitches beyond center marker, SSK, K1, turn. Pull yarn tight.<br />
        Wrong Side (with purl stitches facing you) (&quot;<strong>WS</strong>&quot;): Slip 1, purl to 2 stitches beyond marker, P2Tog, P1, turn. Pull yarn tight.<br />
        <em>Where you created your SSK and P2Tog stitches, you should notice a gap between the stitches.</em><br />
        Remove center marker. You won&#39;t need it anymore.<br />
        RS: Slip 1, knit across to 1 stitch before the gap, SSK stitch before the gap and the stitch after the gap. K1. Turn. Pull yarn tight.<br />
        WS: Slip 1, purl across to 1 stitch before the gap, P2Tog the stitch before the gap and the stitch after the gap. P1. Turn. pull yarn tight.<br />
        <br />
        Repeat until you have consumed all HEEL stitches, the stitches between the two outer<br />
        <br />
        <span class="auto-style2"><strong>Now it&#39;s time to CONSUME THE GUSSET STITCHES and ADD OPTIONAL HEEL FLAP</strong></span>:<br />
        <br />
        <strong>NON-HEEL FLAP METHOD</strong>:<br />
        RS: Slip 1, knit across to 1 stitch before the gap, SSK the stitch before the gap and the stitch after the gap. K1. turn. Pull yarn tight.<br />
        WS: Slip 1, purl across to 1 stitch before the gap. P2Tog the stitch before the gap and the stitch after the gap. P1. Turn. Pull yarn tight.<br />
        Repeat above two rows until you have consumed all RS Gusset Stitches.<br />
        END of NON-HEEL FLAP<br />
        ==========================================<br />
        <br />
        <strong>HEEL FLAP METHOD</strong>:<br />
        RS1: *(Slip 1, knit 1) repeat from * to 1 stitch before the gap, SSK the stitch before the gap and the stitch after the gap, K1, turn. Pull yarn tight.<br />
        WS: Slip 1, purl to 1 stitch before the gap, P2Tog the stitch before the gap and the stitch after the gap, P1, turn. Pull yarn tight.<br />
        RS2: *(Knit 1, slip 1) repeat from * to 1 stitch before the gap, SSK the stitch before the gap and the stitch after the gap, K1, turn. Pull yarn tight.<br />
        Repeat above three rows, alternatiing RS1 and RS2 after every WS row until you have consumed all RS Gusset Stitches<br />
        END of HEEL FLAP<br />
        ==========================================<br />
        <br />
        At this point, you will still have what looks like 2 stitches and a gap left to consume on the<br />
        Gusset/Heel needles from the WS (purl side) of your work. That is, 2 knit stitches, a gap, and then the rest of the heel stitches.<br />
        We&#39;ll consume them right away at the beginning of the next round.       <br />
        For now, though, resume knitting in the round by continuing on to the Instep needle. Knit across the instep needle.<br />
        <br />
        Next round: now you&#39;re back to the Gusset/Heel needle. Notice those last stitches that need to be consumed to complete turning the heel.<br />
&nbsp;&nbsp;&nbsp; Knit the first stitch, SSK the next two stitches (which should be a stitch before and a stitch after the gap). Knit across.<br />
        <br />
        The foot of your sock is complete!<br />
        <br />
        Now you&#39;re ready to do whatever you want to knit the leg and cuff of your sock.<br />
        I generally do 1x1 ribbing for the cuff in needle sizes 1 or 2 less than what I used for my main sock.<br />
        <br />
        Try <a href="https://youtu.be/SbzeEg6XMwM">this awesome bind-off</a> when your sock leg &amp; cuff is as long as you want it.<br />
       
        =================================================<br />
        <br />
        Please send your comments and requests for improvement to <a href="mailto:crafty.kt@gmail.com">crafty.kt@gmail.com</a>.<br />
        <br />
        </div>
    </form>
</body>
</html>
