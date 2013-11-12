package org.neuroml.export.info;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.lemsml.export.base.GenerationException;
import org.lemsml.jlems.core.expression.ParseError;
import org.lemsml.jlems.core.run.ConnectionError;
import org.lemsml.jlems.core.run.RuntimeError;
import org.lemsml.jlems.core.sim.ContentError;
import org.lemsml.jlems.core.sim.ParseException;
import org.lemsml.jlems.core.type.BuildException;
import org.lemsml.jlems.core.xml.XMLException;
import org.lemsml.jlems.io.util.JUtil;
import org.neuroml.export.Main;
import org.neuroml.export.info.model.InfoNode;
import org.neuroml.model.NeuroMLDocument;
import org.neuroml.model.util.NeuroMLConverter;

/**
 * @author matteocantarelli
 *
 */
public class InfoTreeCreatorTest extends TestCase
{

	public void testAbstract() throws ContentError, ParseError, ParseException, BuildException, XMLException, IOException, ConnectionError, RuntimeError, JAXBException, GenerationException
	{
		String expected="Element iafRef:\n" + 
				"	ID: iafRef\n" + 
				"Element adExBurst:\n" + 
				"	ID: adExBurst";
		Assert.assertEquals(expected, getInfoTreeAsString("NML2_AbstractCells.nml"));
	}

	public void testCell() throws ContentError, ParseError, ParseException, BuildException, XMLException, IOException, ConnectionError, RuntimeError, JAXBException, GenerationException
	{
		String expected="Cell SpikingCell:\n" + 
				"	ID: SpikingCell\n" + 
				"	Description: A Simple Spiking cell for testing purposes\n" + 
				"	Number of segments: 4";
		Assert.assertEquals(expected, getInfoTreeAsString("NML2_FullCell.nml"));
	}

	public void testIonChannel() throws ContentError, ParseError, ParseException, BuildException, XMLException, IOException, ConnectionError, RuntimeError, JAXBException, GenerationException
	{
		String expected="Ion Channel na:\n" + 
				"	ID: na\n" + 
				"	Gates:\n" + 
				"		gate m:\n" + 
				"			instances: 3\n" + 
				"			forward rate: 1000.00 * (v - -0.0400000)/0.0100000 / ( 1 - exp(-(v - -0.0400000) / 0.0100000))\n" + 
				"			reverse rate: 4000.00 * exp((v - -0.0650000)/-0.0180000)\n" + 
				"			forward rate plot: PlotNode [Title=RatePlot, X=mV, Y=ms-1, Data=[Data [X=[-8.0, -7.9, -7.8, -7.7000003, -7.6, -7.5, -7.4, -7.3, -7.2000003, -7.1, -7.0, -6.9, -6.8, -6.7000003, -6.6, -6.5, -6.4, -6.3, -6.2000003, -6.1, -6.0, -5.9, -5.8, -5.7000003, -5.6, -5.5, -5.4, -5.3, -5.2000003, -5.1, -5.0, -4.9, -4.8, -4.7000003, -4.6, -4.5, -4.4, -4.3, -4.2000003, -4.1, -4.0, -3.9, -3.8, -3.7, -3.6000001, -3.5, -3.4, -3.3, -3.2, -3.1000001, -3.0, -2.9, -2.8, -2.7, -2.6000001, -2.5, -2.4, -2.3, -2.2, -2.1000001, -2.0, -1.9, -1.8000001, -1.7, -1.6, -1.5, -1.4, -1.3000001, -1.2, -1.1, -1.0, -0.90000004, -0.8, -0.7, -0.6, -0.5, -0.4, -0.3, -0.2, -0.1, 0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.90000004, 1.0, 1.1, 1.2, 1.3000001, 1.4, 1.5, 1.6, 1.7, 1.8000001, 1.9, 2.0, 2.1000001, 2.2, 2.3, 2.4, 2.5, 2.6000001, 2.7, 2.8, 2.9, 3.0, 3.1000001, 3.2, 3.3, 3.4, 3.5, 3.6000001, 3.7, 3.8, 3.9, 4.0, 4.1, 4.2000003, 4.3, 4.4, 4.5, 4.6, 4.7000003, 4.8, 4.9, 5.0, 5.1, 5.2000003, 5.3, 5.4, 5.5, 5.6, 5.7000003, 5.8, 5.9, 6.0, 6.1, 6.2000003, 6.3, 6.4, 6.5, 6.6, 6.7000003, 6.8, 6.9, 7.0, 7.1, 7.2000003, 7.3, 7.4, 7.5, 7.6, 7.7000003, 7.8, 7.9, 8.0, 8.1, 8.2, 8.3, 8.400001, 8.5, 8.6, 8.7, 8.8, 8.900001, 9.0, 9.1, 9.2, 9.3, 9.400001, 9.5, 9.6, 9.7, 9.8, 9.900001], Y=[3335.9817, 3344.9927, 3354.0095, 3363.0332, 3372.063, 3381.0994, 3390.1423, 3399.1912, 3408.246, 3417.3079, 3426.3755, 3435.4495, 3444.5295, 3453.6157, 3462.7078, 3471.8064, 3480.9104, 3490.0203, 3499.1365, 3508.2588, 3517.3865, 3526.5205, 3535.66, 3544.8054, 3553.9563, 3563.1133, 3572.2756, 3581.4438, 3590.6177, 3599.7969, 3608.9817, 3618.172, 3627.3682, 3636.5693, 3645.7761, 3654.988, 3664.2058, 3673.4282, 3682.6567, 3691.8901, 3701.1287, 3710.3726, 3719.6213, 3728.8755, 3738.1345, 3747.3992, 3756.6682, 3765.9429, 3775.2222, 3784.5066, 3793.796, 3803.0903, 3812.3894, 3821.693, 3831.002, 3840.3154, 3849.6338, 3858.9568, 3868.2847, 3877.6174, 3886.954, 3896.2961, 3905.642, 3914.9932, 3924.3484, 3933.7085, 3943.0728, 3952.4417, 3961.8145, 3971.1924, 3980.5745, 3989.9607, 3999.3516, 4008.7463, 4018.1458, 4027.549, 4036.957, 4046.3687, 4055.785, 4065.2048, 4074.6294, 4084.058, 4093.4902, 4102.9272, 4112.367, 4121.812, 4131.2603, 4140.713, 4150.169, 4159.6294, 4169.0933, 4178.561, 4188.033, 4197.508, 4206.988, 4216.47, 4225.9575, 4235.4473, 4244.942, 4254.439, 4263.9404, 4273.4453, 4282.9536, 4292.466, 4301.9814, 4311.5005, 4321.0225, 4330.549, 4340.0776, 4349.6113, 4359.147, 4368.687, 4378.23, 4387.7764, 4397.3257, 4406.879, 4416.435, 4425.994, 4435.557, 4445.1226, 4454.692, 4464.264, 4473.8394, 4483.418, 4492.999, 4502.584, 4512.1714, 4521.7627, 4531.356, 4540.953, 4550.5522, 4560.155, 4569.7603, 4579.3687, 4588.9805, 4598.594, 4608.2114, 4617.8315, 4627.454, 4637.0796, 4646.708, 4656.339, 4665.9727, 4675.6094, 4685.2485, 4694.89, 4704.535, 4714.1826, 4723.8325, 4733.485, 4743.14, 4752.798, 4762.4585, 4772.121, 4781.786, 4791.454, 4801.1245, 4810.7974, 4820.4727, 4830.1504, 4839.8306, 4849.5137, 4859.198, 4868.8853, 4878.575, 4888.2676, 4897.9614, 4907.658, 4917.3574, 4927.059, 4936.762, 4946.4683, 4956.176, 4965.886, 4975.5986, 4985.3135, 4995.03, 5004.749, 5014.4697, 5024.1934], Label=HHExpLinearRate]]]\n" + 
				"			reverse rate plot: PlotNode [Title=RatePlot, X=mV, Y=ms-1, Data=[Data [X=[-8.0, -7.9, -7.8, -7.7000003, -7.6, -7.5, -7.4, -7.3, -7.2000003, -7.1, -7.0, -6.9, -6.8, -6.7000003, -6.6, -6.5, -6.4, -6.3, -6.2000003, -6.1, -6.0, -5.9, -5.8, -5.7000003, -5.6, -5.5, -5.4, -5.3, -5.2000003, -5.1, -5.0, -4.9, -4.8, -4.7000003, -4.6, -4.5, -4.4, -4.3, -4.2000003, -4.1, -4.0, -3.9, -3.8, -3.7, -3.6000001, -3.5, -3.4, -3.3, -3.2, -3.1000001, -3.0, -2.9, -2.8, -2.7, -2.6000001, -2.5, -2.4, -2.3, -2.2, -2.1000001, -2.0, -1.9, -1.8000001, -1.7, -1.6, -1.5, -1.4, -1.3000001, -1.2, -1.1, -1.0, -0.90000004, -0.8, -0.7, -0.6, -0.5, -0.4, -0.3, -0.2, -0.1, 0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.90000004, 1.0, 1.1, 1.2, 1.3000001, 1.4, 1.5, 1.6, 1.7, 1.8000001, 1.9, 2.0, 2.1000001, 2.2, 2.3, 2.4, 2.5, 2.6000001, 2.7, 2.8, 2.9, 3.0, 3.1000001, 3.2, 3.3, 3.4, 3.5, 3.6000001, 3.7, 3.8, 3.9, 4.0, 4.1, 4.2000003, 4.3, 4.4, 4.5, 4.6, 4.7000003, 4.8, 4.9, 5.0, 5.1, 5.2000003, 5.3, 5.4, 5.5, 5.6, 5.7000003, 5.8, 5.9, 6.0, 6.1, 6.2000003, 6.3, 6.4, 6.5, 6.6, 6.7000003, 6.8, 6.9, 7.0, 7.1, 7.2000003, 7.3, 7.4, 7.5, 7.6, 7.7000003, 7.8, 7.9, 8.0, 8.1, 8.2, 8.3, 8.400001, 8.5, 8.6, 8.7, 8.8, 8.900001, 9.0, 9.1, 9.2, 9.3, 9.400001, 9.5, 9.6, 9.7, 9.8, 9.900001], Y=[168.5754, 167.64145, 166.71268, 165.78906, 164.87059, 163.95717, 163.04881, 162.14552, 161.2472, 160.35385, 159.46545, 158.58202, 157.70343, 156.82976, 155.96089, 155.09683, 154.23756, 153.38309, 152.53331, 151.68823, 150.84789, 150.01216, 149.18106, 148.35455, 147.53267, 146.71532, 145.90251, 145.09418, 144.29033, 143.49092, 142.69595, 141.90541, 141.11923, 140.33743, 139.55992, 138.78677, 138.01782, 137.2532, 136.4928, 135.73659, 134.98462, 134.23677, 133.4931, 132.75348, 132.01804, 131.28662, 130.5593, 129.83597, 129.11668, 128.40134, 127.68997, 126.98254, 126.27903, 125.579445, 124.883705, 124.19185, 123.5038, 122.81956, 122.139114, 121.46243, 120.789505, 120.12036, 119.454865, 118.79306, 118.13492, 117.48045, 116.82958, 116.18232, 115.53865, 114.89859, 114.262, 113.62896, 112.999435, 112.37339, 111.75087, 111.131744, 110.51605, 109.90376, 109.2949, 108.689384, 108.08722, 107.48839, 106.89288, 106.30072, 105.71179, 105.1261, 104.54368, 103.96453, 103.38854, 102.81575, 102.246124, 101.67966, 101.116356, 100.556145, 99.99905, 99.44502, 98.89413, 98.34623, 97.80137, 97.25951, 96.72071, 96.18485, 95.65197, 95.12204, 94.59504, 94.070984, 93.54981, 93.031525, 92.516106, 92.00359, 91.493866, 90.98697, 90.48289, 89.98157, 89.48309, 88.987335, 88.49432, 88.00404, 87.516525, 87.03165, 86.54947, 86.06997, 85.59316, 85.11896, 84.64738, 84.17841, 83.71204, 83.248276, 82.78706, 82.32841, 81.872284, 81.41874, 80.96766, 80.51906, 80.07297, 79.62934, 79.18822, 78.7495, 78.3132, 77.87933, 77.44788, 77.01881, 76.5921, 76.16776, 75.74578, 75.326164, 74.908844, 74.49383, 74.0811, 73.67071, 73.26256, 72.85667, 72.453026, 72.05161, 71.652466, 71.2555, 70.860725, 70.46814, 70.07773, 69.68948, 69.30339, 68.91943, 68.537636, 68.15792, 67.78031, 67.40479, 67.03136, 66.66002, 66.29071, 65.92344, 65.55821, 65.19501, 64.83381, 64.47462, 64.11741, 63.76222, 63.40896, 63.05766, 62.708305, 62.36089], Label=HHExpRate]]]\n" + 
				"		gate h:\n" + 
				"			instances: 1\n" + 
				"			forward rate: 70.0000 * exp((v - -0.0650000)/-0.0200000)\n" + 
				"			reverse rate: 1000.00 /(1 + exp((v - -0.0350000)/0.0100000))\n" + 
				"			forward rate plot: PlotNode [Title=RatePlot, X=mV, Y=ms-1, Data=[Data [X=[-8.0, -7.9, -7.8, -7.7000003, -7.6, -7.5, -7.4, -7.3, -7.2000003, -7.1, -7.0, -6.9, -6.8, -6.7000003, -6.6, -6.5, -6.4, -6.3, -6.2000003, -6.1, -6.0, -5.9, -5.8, -5.7000003, -5.6, -5.5, -5.4, -5.3, -5.2000003, -5.1, -5.0, -4.9, -4.8, -4.7000003, -4.6, -4.5, -4.4, -4.3, -4.2000003, -4.1, -4.0, -3.9, -3.8, -3.7, -3.6000001, -3.5, -3.4, -3.3, -3.2, -3.1000001, -3.0, -2.9, -2.8, -2.7, -2.6000001, -2.5, -2.4, -2.3, -2.2, -2.1000001, -2.0, -1.9, -1.8000001, -1.7, -1.6, -1.5, -1.4, -1.3000001, -1.2, -1.1, -1.0, -0.90000004, -0.8, -0.7, -0.6, -0.5, -0.4, -0.3, -0.2, -0.1, 0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.90000004, 1.0, 1.1, 1.2, 1.3000001, 1.4, 1.5, 1.6, 1.7, 1.8000001, 1.9, 2.0, 2.1000001, 2.2, 2.3, 2.4, 2.5, 2.6000001, 2.7, 2.8, 2.9, 3.0, 3.1000001, 3.2, 3.3, 3.4, 3.5, 3.6000001, 3.7, 3.8, 3.9, 4.0, 4.1, 4.2000003, 4.3, 4.4, 4.5, 4.6, 4.7000003, 4.8, 4.9, 5.0, 5.1, 5.2000003, 5.3, 5.4, 5.5, 5.6, 5.7000003, 5.8, 5.9, 6.0, 6.1, 6.2000003, 6.3, 6.4, 6.5, 6.6, 6.7000003, 6.8, 6.9, 7.0, 7.1, 7.2000003, 7.3, 7.4, 7.5, 7.6, 7.7000003, 7.8, 7.9, 8.0, 8.1, 8.2, 8.3, 8.400001, 8.5, 8.6, 8.7, 8.8, 8.900001, 9.0, 9.1, 9.2, 9.3, 9.400001, 9.5, 9.6, 9.7, 9.8, 9.900001], Y=[4.049103, 4.0289073, 4.008814, 3.9888191, 3.9689252, 3.9491298, 3.9294329, 3.9098353, 3.8903353, 3.8709319, 3.851625, 3.8324153, 3.8133016, 3.7942822, 3.7753587, 3.7565286, 3.7377932, 3.7191505, 3.7006016, 3.6821444, 3.6637802, 3.6455066, 3.6273248, 3.6092331, 3.5912325, 3.5733206, 3.555499, 3.5377655, 3.5201206, 3.5025642, 3.4850948, 3.467713, 3.4504175, 3.433209, 3.4160852, 3.399048, 3.3820949, 3.365227, 3.3484423, 3.3317416, 3.3151248, 3.2985902, 3.2821388, 3.2657688, 3.249481, 3.2332737, 3.2171483, 3.2011023, 3.185137, 3.1692507, 3.1534445, 3.1377163, 3.1220672, 3.1064954, 3.0910022, 3.0755854, 3.0602462, 3.0449836, 3.0297964, 3.0146847, 2.9996486, 2.9846888, 2.9698024, 2.9549901, 2.9402516, 2.9255881, 2.9109964, 2.8964775, 2.8820307, 2.8676577, 2.853355, 2.8391232, 2.8249629, 2.810873, 2.7968547, 2.7829049, 2.7690248, 2.755214, 2.7414732, 2.7278, 2.7141945, 2.7006571, 2.6871872, 2.673786, 2.66045, 2.6471806, 2.6339781, 2.6208413, 2.6077695, 2.594763, 2.581822, 2.5689447, 2.5561323, 2.5433838, 2.5306983, 2.5180762, 2.5055175, 2.4930215, 2.4805872, 2.468215, 2.455905, 2.4436564, 2.4314685, 2.419341, 2.4072742, 2.395269, 2.3833222, 2.371435, 2.3596072, 2.3478394, 2.3361292, 2.3244774, 2.3128839, 2.301348, 2.2898707, 2.2784498, 2.2670858, 2.2557783, 2.2445283, 2.2333336, 2.2221944, 2.2111108, 2.2000837, 2.1891105, 2.1781921, 2.1673281, 2.1565187, 2.1457634, 2.135061, 2.124412, 2.1138167, 2.1032743, 2.092784, 2.0823464, 2.0719604, 2.0616264, 2.0513442, 2.0411134, 2.030933, 2.0208035, 2.0107253, 2.0006967, 1.9907179, 1.9807888, 1.9709095, 1.9610802, 1.9512991, 1.9415667, 1.9318829, 1.9222482, 1.9126607, 1.9031211, 1.8936291, 1.8841842, 1.8747876, 1.8654368, 1.8561327, 1.846875, 1.8376644, 1.8284987, 1.8193789, 1.8103044, 1.8012762, 1.792292, 1.7833527, 1.774458, 1.7656081, 1.7568023, 1.7480401, 1.7393218, 1.7306467, 1.7220154, 1.7134266, 1.7048811, 1.6963778, 1.6879172, 1.6794989, 1.6711222, 1.6627872, 1.6544938], Label=HHExpRate]]]\n" + 
				"			reverse rate plot: PlotNode [Title=RatePlot, X=mV, Y=ms-1, Data=[Data [X=[-8.0, -7.9, -7.8, -7.7000003, -7.6, -7.5, -7.4, -7.3, -7.2000003, -7.1, -7.0, -6.9, -6.8, -6.7000003, -6.6, -6.5, -6.4, -6.3, -6.2000003, -6.1, -6.0, -5.9, -5.8, -5.7000003, -5.6, -5.5, -5.4, -5.3, -5.2000003, -5.1, -5.0, -4.9, -4.8, -4.7000003, -4.6, -4.5, -4.4, -4.3, -4.2000003, -4.1, -4.0, -3.9, -3.8, -3.7, -3.6000001, -3.5, -3.4, -3.3, -3.2, -3.1000001, -3.0, -2.9, -2.8, -2.7, -2.6000001, -2.5, -2.4, -2.3, -2.2, -2.1000001, -2.0, -1.9, -1.8000001, -1.7, -1.6, -1.5, -1.4, -1.3000001, -1.2, -1.1, -1.0, -0.90000004, -0.8, -0.7, -0.6, -0.5, -0.4, -0.3, -0.2, -0.1, 0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.90000004, 1.0, 1.1, 1.2, 1.3000001, 1.4, 1.5, 1.6, 1.7, 1.8000001, 1.9, 2.0, 2.1000001, 2.2, 2.3, 2.4, 2.5, 2.6000001, 2.7, 2.8, 2.9, 3.0, 3.1000001, 3.2, 3.3, 3.4, 3.5, 3.6000001, 3.7, 3.8, 3.9, 4.0, 4.1, 4.2000003, 4.3, 4.4, 4.5, 4.6, 4.7000003, 4.8, 4.9, 5.0, 5.1, 5.2000003, 5.3, 5.4, 5.5, 5.6, 5.7000003, 5.8, 5.9, 6.0, 6.1, 6.2000003, 6.3, 6.4, 6.5, 6.6, 6.7000003, 6.8, 6.9, 7.0, 7.1, 7.2000003, 7.3, 7.4, 7.5, 7.6, 7.7000003, 7.8, 7.9, 8.0, 8.1, 8.2, 8.3, 8.400001, 8.5, 8.6, 8.7, 8.8, 8.900001, 9.0, 9.1, 9.2, 9.3, 9.400001, 9.5, 9.6, 9.7, 9.8, 9.900001], Y=[9.639782, 9.638827, 9.637873, 9.636919, 9.635964, 9.63501, 9.634056, 9.633101, 9.632148, 9.631194, 9.63024, 9.629287, 9.628333, 9.627379, 9.626426, 9.625472, 9.624519, 9.623567, 9.622613, 9.62166, 9.6207075, 9.619755, 9.618802, 9.617849, 9.616897, 9.615945, 9.614992, 9.614039, 9.613088, 9.612136, 9.611184, 9.610232, 9.609281, 9.608329, 9.607377, 9.606425, 9.605474, 9.604523, 9.603572, 9.602621, 9.601669, 9.6007185, 9.599768, 9.598817, 9.597867, 9.596916, 9.595965, 9.595016, 9.594065, 9.593115, 9.592165, 9.591215, 9.590265, 9.589315, 9.588366, 9.587416, 9.586467, 9.585517, 9.584568, 9.583618, 9.582669, 9.58172, 9.580771, 9.579823, 9.578874, 9.577925, 9.576977, 9.576028, 9.57508, 9.574131, 9.573183, 9.572235, 9.571287, 9.570339, 9.569391, 9.568443, 9.567496, 9.566548, 9.565601, 9.564653, 9.563706, 9.562759, 9.561812, 9.560865, 9.559918, 9.558971, 9.558024, 9.557078, 9.556131, 9.555185, 9.554238, 9.553292, 9.552346, 9.5514, 9.550454, 9.549508, 9.548563, 9.547617, 9.546671, 9.545726, 9.544781, 9.543835, 9.54289, 9.5419445, 9.540999, 9.540054, 9.53911, 9.538165, 9.53722, 9.536276, 9.535332, 9.534387, 9.5334425, 9.532498, 9.531554, 9.53061, 9.529666, 9.528723, 9.527779, 9.526835, 9.525891, 9.524948, 9.524005, 9.523062, 9.522119, 9.521175, 9.520232, 9.519289, 9.518347, 9.517404, 9.516461, 9.515518, 9.514576, 9.513634, 9.5126915, 9.511749, 9.510807, 9.509865, 9.508924, 9.507981, 9.50704, 9.506098, 9.5051565, 9.504215, 9.503274, 9.502333, 9.501391, 9.50045, 9.49951, 9.498569, 9.497627, 9.496687, 9.495747, 9.494806, 9.493865, 9.492925, 9.491985, 9.491045, 9.490105, 9.489164, 9.488225, 9.487285, 9.486345, 9.485406, 9.484467, 9.483527, 9.482588, 9.481648, 9.480709, 9.479771, 9.478831, 9.477893, 9.4769535, 9.476015, 9.475077, 9.474138, 9.4732, 9.472261, 9.471323, 9.470385], Label=HHSigmoidRate]]]";

		Assert.assertEquals(expected, getInfoTreeAsString("NML2_SimpleIonChannel.nml"));
	}

	public void testNetwork() throws ContentError, ParseError, ParseException, BuildException, XMLException, IOException, ConnectionError, RuntimeError, JAXBException, GenerationException
	{
		String expected="Network InstanceBasedNetwork:\n" + 
				"	ID: InstanceBasedNetwork\n" + 
				"	Number of populations: 1\n" + 
				"	Population iafCells:\n" + 
				"		ID: iafCells\n" + 
				"		Size (number of instances): 3\n" + 
				"	Number of projections: 2\n" + 
				"	Projection internal1:\n" + 
				"		ID: internal1\n" + 
				"		Presynaptic population: iafCells\n" + 
				"		Postsynaptic population: iafCells\n" + 
				"	Projection internal2:\n" + 
				"		ID: internal2\n" + 
				"		Presynaptic population: iafCells\n" + 
				"		Postsynaptic population: iafCells";
		Assert.assertEquals(expected, getInfoTreeAsString("NML2_InstanceBasedNetwork.nml"));
	}
	
	/**
	 * Test method for {@link org.neuroml.export.info.InfoTreeCreator#createInfoTree(org.neuroml.model.NeuroMLDocument)}.
	 * @throws ContentError 
	 * @throws JAXBException 
	 */
	private String getInfoTreeAsString(String nmlFilename) throws ContentError, JAXBException
	{
		String content = JUtil.getRelativeResource(this.getClass(), Main.getNeuroMLExamplesResourcesDir()+"/"+nmlFilename);
		NeuroMLConverter nmlc = new NeuroMLConverter();
    	NeuroMLDocument nmlDocument = nmlc.loadNeuroML(content);
		InfoNode root = InfoTreeCreator.createInfoTree(nmlDocument);
		Assert.assertFalse(root.isEmpty());
		return root.toString();
	}

}
