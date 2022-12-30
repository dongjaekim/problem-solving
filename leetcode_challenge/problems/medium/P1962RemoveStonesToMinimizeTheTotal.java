package problems.medium;

import java.util.*;

public class P1962RemoveStonesToMinimizeTheTotal {
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        int n = piles.length;

        for (int i = 0; i < n; i++)
            priorityQueue.add(piles[i]);
        for (int i = 0; i < k; i++) {
            Integer val = priorityQueue.poll();
            val = val - (val / 2);
            priorityQueue.add(val);
        }
        return priorityQueue.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        int p1 = minStoneSum(new int[]{5, 4, 9}, 2);
        System.out.println("p1 = " + p1);

        int p2 = minStoneSum(new int[]{4, 3, 6, 7}, 3);
        System.out.println("p2 = " + p2);

        int p3 = minStoneSum(new int[]{1}, 10000);
        System.out.println("p3 = " + p3);

        int p4 = minStoneSum(new int[]{262, 6658, 932, 504, 6091, 770, 282, 2597, 1076, 8334, 9772, 6642, 2058, 6009, 7400, 5799, 4366, 4464, 8903, 1746, 1889, 9740, 349, 4768, 9831, 2083, 1221, 9636, 7017, 4022, 5966, 8251, 1270, 6340, 6307, 4781, 9814, 1513, 3557, 5973, 6851, 6062, 6555, 1253, 1956, 8070, 69, 2446, 2837, 1007, 9083, 1053, 1762, 3447, 3548, 1571, 8081, 5757, 3608, 2623, 9893, 3500, 5801, 9054, 7055, 723, 1904, 4449, 8413, 2799, 6693, 3612, 9808, 4214, 728, 386, 9622, 7759, 1711, 666, 8817, 530, 4452, 7455, 9436, 9657, 5715, 8280, 4600, 1898, 7781, 1808, 9142, 3198, 5218, 8454, 9222, 8911, 7100, 9572, 1521, 1725, 8944, 1282, 656, 8178, 9121, 1643, 9925, 1675, 5763, 2635, 8299, 3831, 7796, 1071, 5243, 7194, 6198, 3944, 9836, 553, 3921, 7284, 7547, 8450, 3048, 6923, 3278, 714, 9713, 8072, 7508, 1720, 6347, 1948, 3975, 4525, 3638, 7507, 4517, 5110, 4456, 8088, 3986, 9094, 4870, 6970, 7461, 3961, 4662, 7091, 9272, 8779, 6331, 7212, 6698, 9282, 4167, 9087, 8406, 747, 8765, 4131, 8936, 6842, 3340, 4135, 3735, 8662, 6946, 9420, 8044, 9310, 318, 4320, 6767, 574, 6473, 1180, 7462, 9545, 6079, 2814, 7570, 4723, 6376, 1849, 841, 6185, 9178, 8774, 889, 1408, 2522, 4074, 4180, 4035, 2646, 8665, 7867, 7241, 2492, 9236, 6267, 1174, 3363, 3919, 45, 4571, 7104, 4889, 3016, 6103, 6173, 9859, 7727, 9952, 886, 4744, 3308, 8863, 3133, 2032, 8597, 4890, 4763, 4756, 4659, 1879, 9688, 9845, 9376, 2150, 6219, 3931, 3000, 9339, 786, 9616, 4166, 7945, 3575, 1588, 5117, 1684, 9880, 4462, 808, 8252, 2324, 8040, 3962, 379, 5984, 5857, 5407, 7589, 7088, 4394, 7091, 44, 1864, 1055, 3348, 9843, 1658, 7082, 4574, 7990, 7784, 3253, 7670, 564, 5317, 5863, 4555, 3409, 40, 4560, 7089, 8977, 4956, 8033, 2869, 4519, 1336, 3460, 794, 2210, 6048, 7793, 9421, 2707, 8249, 8054, 2151, 3322, 4281, 3078, 7567, 2119, 8794, 6069, 1214, 6156, 9376, 639, 5185, 7905, 7215, 856, 6350, 4352, 9189, 1014, 9837, 9999, 5924, 4072, 7594, 8039, 3079, 2610, 8308, 7065, 3370, 4934, 175, 4429, 4973, 9815, 2385, 9914, 4835, 7474, 9383, 512, 1775, 4087, 360, 3572, 9742, 3061, 934, 7018, 3676, 5606, 7659, 3627, 9848, 4524, 672, 418, 8184, 6015, 8681, 153, 9752, 6981, 5006, 144, 5530, 7706, 501, 41, 8690, 1999, 6077, 1648, 2250, 8605, 8076, 7288, 9959, 6003, 7250, 5719, 974, 6547, 68, 520, 7111, 7412, 2120, 1367, 363, 9297, 6159, 3325, 2231, 2304, 9405, 3414, 2080, 4847, 9126, 935, 1690, 7627, 3699, 6245, 4208, 2148, 9326, 3481, 8487, 7732, 5628, 9495, 6917, 3529, 2838, 409, 6938, 5564, 6574, 7190, 6403, 7166, 8062, 5439, 6786, 3693, 8744, 9433, 9804, 2556, 7398, 6424, 8117, 6636, 2184, 9526, 9162, 7281, 312, 8696, 6892, 6989, 9828, 5221, 2452, 6415, 7958, 1596, 8654, 5440, 3783, 8763, 2158, 9930, 4171, 494, 6418, 3231, 1613, 5250, 9814, 2420, 716, 3508, 3684, 7313, 3723, 3321, 4513, 4865, 572, 97, 4020, 3345, 8158, 6235, 6878, 7622, 3904, 8400, 598, 9809, 2556, 929, 5532, 8288, 2762, 4381, 2050, 5977, 7632, 5157, 8526, 5524, 8311, 7268, 5767, 2933, 5833, 4994, 5987, 9505, 6616, 1936, 194, 9985, 3415, 846, 8749, 576, 2669, 6559, 8470, 3466, 8645, 6945, 4528, 5877, 7987, 6634, 3089, 6219, 6243, 4867, 9472, 487, 5737, 2480, 3905, 7091, 2339, 2889, 8320, 2541, 9941, 9141, 7987, 4835, 163, 5732, 3260, 7900, 9318, 885, 6366, 8879, 8493, 8283, 9082, 7394, 9306, 2249, 4999, 3629, 5053, 8768, 5035, 702, 3300, 1004, 3284, 1839, 739, 1361, 67, 5873, 4014, 4152, 6720, 4997, 1086, 7376, 8583, 3348, 2093, 1085, 3570, 8910, 1896, 2588, 4396, 2555, 6201, 7588, 5419, 9875, 6537, 8647, 5447, 7198, 2484, 8486, 718, 9066, 5283, 3223, 462, 2050, 5738, 841, 792, 5094, 965, 684, 8003, 9037, 9832, 7135, 2727, 1887, 9723, 667, 8019, 4888, 703, 8701, 9752, 6041, 244, 2642, 2232, 161, 7534, 4720, 5715, 8455, 3008, 1275, 134, 545, 3591, 1783, 5764, 6161, 6010, 6231, 6060, 1125, 1407, 9295, 6592, 2605, 2081, 2435, 9440, 4795, 2504, 923, 2188, 4152, 6018, 6832, 5283, 5684, 6976, 8674, 6392, 6874, 6182, 5639, 9745, 1955, 3590, 1353, 8492, 204, 3658, 9108, 2107, 1058, 2842, 350, 1017, 8900, 5440, 4134, 3373, 1447, 1666, 7173, 1623, 3116, 5750, 5969, 3524, 577, 5354, 4017, 9719, 5466, 8606, 5715, 128, 8392, 8423, 5573, 9984, 138, 9251, 8630, 8310, 2018, 490, 3137, 8234, 740, 3837, 6687, 1954, 3334, 9085, 9320, 2855, 8305, 726, 6030, 1694, 8794, 9400, 8132, 2558, 9174, 4780, 8809, 594, 3761, 208, 4647, 8448, 3347, 3012, 5412, 6965, 4554, 6316, 9870, 2886, 2494, 9812, 1998, 1015, 402, 1156, 4455, 5708, 4956, 2339, 6863, 3340, 6252, 3602, 3792, 4116, 4961, 6882, 6040, 9273, 3955, 5157, 8465, 4324, 1935, 4430, 5212, 5025, 8098, 2644, 4372, 4414, 7397, 5862, 5275, 9786, 2470, 5807, 6931, 2910, 1116, 2750, 1073, 3993, 5280, 1481, 2588, 4652, 1962, 6675, 2266, 4511, 9744, 4838, 704, 1230, 4141, 4752, 6473, 6633, 1791, 1774, 7490, 8943, 2796, 9159, 10, 828, 2205, 5262, 3972, 1012, 8972, 7989, 1140, 1183, 1404, 7869, 8790, 9591, 8921, 8955, 6312, 3446, 9600, 135, 5610, 9338, 5586, 9573, 6296, 3772, 5529, 3601, 1022, 1078, 1022, 9941, 1942, 5110, 1968, 3466, 5359, 3407, 864, 6322, 5434, 1106, 8846, 8422, 7112, 4593, 1918, 1755, 5560, 2206, 4877, 5553, 4408, 2493, 7319, 8035, 5518, 6397, 7865, 5970, 7402, 5321, 7000, 7579, 8698, 9083, 5516, 6102, 4841, 8018, 6081, 2645, 5314, 5473, 6686, 2286, 182, 4232, 5333, 1633, 4639, 8807, 6408, 4691, 1639, 1553, 1594, 3615, 6737, 3610, 9372, 824, 8572, 475, 7256, 3860, 1004, 2334, 8946, 7760, 8075, 2162, 5276, 4579, 6669, 7837, 6013, 9752, 4051, 6792, 5532, 635, 1243, 7966, 1789, 4975, 8670, 2093, 2436, 10000, 5089, 9476, 5520, 7139, 4413, 2078, 9735, 9345, 7400, 8903, 4302, 6585, 1697, 847, 9652, 3427, 3831, 3416, 962, 9758, 5773, 9992, 1357, 5185, 5969, 8460, 6313, 6868, 1296, 9797, 9452, 697, 4195, 4640, 230, 3410, 6646, 4966, 3495, 5845, 1910, 6961, 9946, 5031, 1264, 4075, 7229, 5712, 9034, 8642, 7505, 2940, 9713, 367, 9600, 5684, 7926, 5451, 7632, 7864, 6722, 9048, 9985, 7288, 1961, 738, 6398, 7133, 3299, 7019, 2030, 7935, 8917, 6998, 9374, 6076, 3821, 3014, 5892, 8772, 9310, 8622, 8248, 2594, 2901, 2108, 9471, 7440, 2980, 5500, 2271, 6580, 3667, 3312, 5563, 7594, 4239, 4214, 194, 9424, 8316, 7128, 8113, 3313, 5467, 7468, 7043, 239, 1296, 5025, 4447, 1620, 4809, 5848, 7681, 5914, 1743, 7295, 563, 5362, 9916, 6738, 5406, 5922, 8052, 7621, 125, 8728, 8855, 7196, 249, 8355, 5507, 6344, 1889, 506, 6686, 7222, 395, 6055, 6618, 5466, 3468, 2946, 1900, 4368, 7850, 720, 6500, 9534, 908, 8022, 9156, 3062, 1137, 5327, 881, 8342, 9586, 1685, 4262, 8333, 8294, 1002, 5466, 8434, 1981, 8701, 2553, 3572, 7038, 1197, 5492, 8809, 1513, 7979, 8886, 4638, 2361, 6477, 596, 1608, 5396, 5289, 7591, 2799, 949, 4021, 1754, 2305, 6637, 4044, 682, 8414, 511, 5992, 4731, 5626, 5586, 6257, 3824, 9710, 1369, 6534, 4480, 4273, 8185, 7127, 1981, 5587, 9291, 5101, 9006, 2642, 9799, 7396, 8406, 4717, 3389, 5390, 1974, 3403, 7578, 3866, 4337, 2278, 8351, 1006, 5514, 923, 4115, 2159, 8330, 3268, 9856, 6999, 6113, 2057, 401, 7778, 4993, 2849, 5696, 1749, 5170, 3858, 5394, 6605, 4052, 6517, 908, 965, 4798, 4435, 9533, 3109, 8782, 7996, 7334, 6964, 181, 146, 7083, 2515, 4417, 9229, 2860, 5871, 6993, 9745, 6158, 404, 7654, 2864, 4864, 9587, 331, 4040, 5903, 6341, 5705, 4353, 4627, 5516, 1189, 6819, 7267, 6996, 7762, 1688, 4499, 5393, 1778, 7516, 5570, 7130, 1214, 3056, 5901, 3412, 2335, 6638, 9898, 9091, 6442, 7723, 1463, 3994, 5199, 1456, 8781, 8958, 49, 885, 7473, 1823, 3528, 8512, 8951, 9705, 1054, 7727, 7903, 6137, 7094, 5639, 8242, 8581, 2047, 1035, 7494, 8398, 4384, 5977, 9240, 7591, 4120, 3891, 7212, 5725, 6836, 4032, 4809, 1575, 81, 9848, 9634, 2948, 2297, 7527, 8746, 4110, 1243, 3042, 4309, 7743, 1727, 7653, 2604, 7811, 2336, 6421, 1490, 6926, 3992, 7694, 9122, 8721, 7154, 2385, 2997, 7040, 9549, 8566, 200, 8479, 8731, 8188, 603, 5185, 280, 8278, 8729, 8768, 110, 7637, 3240, 8184, 7036, 4287, 3923, 522, 8217, 3704, 8444, 6669, 7922, 3428, 9761, 2181, 1941, 8719, 4799, 5182, 2361, 675, 9161, 4181, 2874, 1158, 7440, 4894, 7681, 7110, 2131, 5430, 3066, 8651, 2688, 6538, 4197, 1609, 9275, 2995, 5663, 5757, 1613, 4693, 9511, 7766, 5599, 9741, 5568, 1251, 5118, 269, 2378, 1793, 8741, 3942, 4471, 1757, 4177, 1624, 2343, 8139, 3261, 1897, 1441, 1983, 3321, 1879, 5501, 6501, 5589, 1290, 6443, 4294, 3080, 1835, 1810, 4058, 9395, 967, 455, 3373, 1988, 5864, 7495, 8026, 9037, 660, 828, 4723, 4866, 867, 7004, 1355, 3026, 3427, 8765, 5997, 505, 9869, 8285, 2247, 9050, 2468, 3170, 9727, 2810, 2222, 1611, 9729, 2617, 3618, 9494, 4921, 9144, 2391, 5517, 4877, 2892, 3062, 6055, 6055, 9797, 211, 5605, 5784, 4370, 4099, 3723, 6091, 2652, 2251, 1082, 5068, 7120, 156, 6175, 43, 5909, 1025, 855, 8290, 8867, 6697, 8031, 3382, 291, 6684, 1653, 7588, 9791, 7192, 5728, 5075, 2117, 7695, 7499, 9435, 3766, 6849, 8426, 2908, 4016, 7899, 5512, 1506, 8794, 5167, 2286, 9812, 7269, 6252, 5875, 7192, 1008, 111, 3770, 6081, 1534, 7707, 7774, 3923, 1419, 8414, 2478, 2136, 8792, 7409, 8290, 3209, 7130, 2829, 4476, 2710, 3542, 6278, 272, 5495, 9155, 6173, 531, 1955, 4616, 8431, 4727, 4663, 6945, 4746, 775, 58, 10, 1459, 6663, 2205, 1276, 9138, 3512, 7674, 800, 6292, 9779, 298, 495, 6246, 2013, 2869, 7087, 5983, 6223, 4948, 3085, 2095, 8177, 3840, 655, 7695, 2205, 3895, 3004, 3381, 9991, 7756, 9495, 8177, 7815, 2141, 1038, 1494, 6539, 4282, 6155, 3793, 8905, 97, 6714, 9992, 3490, 7039, 7294, 5034, 3026, 4848, 6479, 1062, 7082, 1304, 6273, 2979, 5908, 5963, 6480, 4565, 6123, 7628, 1809, 2565, 6712, 4126, 5382, 354, 3168, 1122, 4897, 7535, 5747, 1896, 7316, 6124, 6845, 6820, 3073, 8531, 8872, 9632, 2768, 9416, 4346, 5730, 9255, 2825, 4433, 2255, 997, 1278, 3330, 1705, 8792, 684, 8148, 7080, 3780, 8284, 5138, 9510, 8924, 8534, 1955, 6653, 8262, 4261, 2742, 3661, 43, 2937, 9784, 6651, 8151, 1729, 1506, 856, 3645, 5839, 2018, 2039, 5506, 6743, 756, 5110, 6643, 7442, 2840, 8331, 6477, 5039, 9013, 3181, 4204, 1018, 1778, 9404, 37, 3984, 4546, 1449, 7153, 7299, 1974, 5954, 3972, 5715, 4342, 1112, 6154, 263, 2703, 1965, 4141, 6734, 3204, 7667, 341, 6239, 2098, 8841, 9165, 9499, 2000, 1099, 371, 8876, 4936, 8687, 601, 1337, 5104, 1518, 7220, 1660, 5671, 6391, 266, 9417, 7552, 2339, 8810, 3453, 8925, 7763, 1941, 5270, 960, 4846, 3389, 151, 4184, 7543, 2510, 7769, 8945, 1400, 5207, 1277, 3636, 1915, 5908, 3760, 1732, 5345, 1932, 226, 1967, 8389, 9274, 8220, 2535, 5616, 9019, 2184, 8315, 1236, 830, 3181, 7976, 3225, 2200, 4069, 8166, 7014, 5357, 2858, 4023, 501, 2932, 7403, 5004, 6623, 7995, 5537, 3328, 6698, 1181, 5019, 7149, 5758, 7478, 4124, 3280, 7080, 3154, 900, 2246, 263, 4520, 4780, 6352, 7844, 3013, 2679, 2796, 1684, 4176, 791, 2552, 4932, 7679, 5157, 1274, 4621, 9033, 5184, 6287, 9000, 788, 761, 6537, 7050, 5110, 3806, 5201, 7332, 884, 9550, 555, 7544, 4936, 4212, 582, 9313, 8642, 9755, 6982, 6608, 6457, 3330, 4039, 4383, 6805, 7835, 5145, 8404, 5973, 9419, 979, 3919, 3749, 8117, 8945, 8477, 4585, 930, 4156, 8055, 6001, 7928, 832, 1857, 2393, 8605, 3121, 4336, 3525, 6128, 7662, 4110, 6976, 2095, 1159, 6427, 3356, 1349, 7048, 570, 3820, 8897, 9868, 6643, 5630, 9559, 8524, 9400, 4310, 3905, 952, 3624, 230, 5162, 5548, 3004, 9271, 5824, 7836, 6696, 2858, 2992, 8803, 5070, 2783, 8073, 2226, 6135, 7284, 2241, 8215, 7161, 7883, 527, 8537, 6660, 560, 743, 5566, 3911, 3131, 811, 9583, 6413, 9936, 9705, 4419, 5706, 5775, 2570, 3788, 8304, 2464, 8326, 1353, 4719, 2479, 495, 4635, 1756, 4210, 4182, 135, 161, 8809, 852, 2414, 2954, 5183, 3099, 2420, 1402, 8487, 5560, 4580, 7825, 4306, 7559, 8493, 8351, 7049, 1422, 293, 3434, 4377, 9876, 5136, 8002, 5497, 7955, 9238, 7119, 9378, 2657, 9081, 7682, 4067, 8214, 3605, 4505, 8589, 9810, 9192, 4044, 3085, 6232, 3437, 6295, 7265, 4365, 5256, 6275, 294, 3125, 937, 1332, 1936, 4916, 5782, 8583, 6809, 8646, 7698, 4881, 148, 8901, 6100, 5730, 8081, 750, 1878, 862, 6619, 4564, 6731, 7624, 705, 8968, 344, 4600, 6861, 5726, 8205, 6708, 864, 2359, 1489, 2046, 8023, 4142, 4695, 5631, 6294, 4337, 349, 339, 8653, 7998, 8122, 390, 1936, 5796, 4162, 7511, 3985, 7735, 2885, 5408, 7878, 5800, 4815, 4329, 4182, 6486, 5291, 4575, 3449, 2538, 3818, 7530, 8789, 7720, 2854, 7758, 7064, 6641, 560, 9275, 2774, 3501, 6264, 1393, 789, 4131, 1263, 7500, 5780, 3784, 8545, 1048, 5429, 5409, 4909, 6562, 4966, 2876, 3996, 1595, 9678, 7950, 885, 2435, 5763, 6389, 8247, 2329, 5132, 4811, 8750, 6899, 2392, 342, 9072, 9751, 9938, 142, 1987, 2546, 7774, 1193, 65, 6796, 1013, 5139, 7502, 3967, 988, 8761, 7081, 7252, 136, 7031, 7646, 2518, 3400, 8582, 4895, 6050, 3608, 1081, 3346, 7724, 6486, 9951, 6602, 8125, 4447, 6000, 2983, 8075, 1642, 9531, 4198, 7526, 7730, 7722, 360, 5372, 605, 2582, 5682, 7343, 9636, 1051, 2560, 4943, 8967, 9997, 9905, 3414, 504, 618, 3358, 4254, 9423, 1486, 3506, 3298, 1395, 1387, 4125, 3924, 951, 38, 1091, 9923, 7591, 8564, 8553, 2527, 8118, 8983, 9005, 714, 9995, 1658, 2171, 1952, 8916, 4786, 5294, 3727, 4894, 9826, 9952, 6523, 3022, 5902, 1185, 4860, 7057, 8381, 4246, 2004, 1706, 2242, 3346, 7141, 498, 303, 9999, 6964, 1481, 1705, 8975, 9817, 4458, 8042, 6993, 2448, 4367, 3451, 2623, 3169, 5469, 5610, 9471, 7369, 8819, 6529, 6281, 6400, 5670, 7459, 8444, 4295, 8234, 4480, 1221, 3234, 4186, 948, 6045, 8736, 3650, 7386, 7568, 501, 6743, 8308, 2702, 7264, 5673, 88, 544, 2788, 5856, 868, 982, 5123, 5235, 5371, 8794, 879, 8535, 7733, 4320, 4444, 2406, 9055, 3815, 3753, 5922, 8537, 224, 8282, 8132, 6997, 9523, 6418, 7332, 4899, 623, 7300, 9675, 5527, 1872, 8398, 194, 7005, 690, 4843, 5608, 4290, 2992, 8862, 954, 2963, 1306, 5541, 8164, 7586, 3729, 438, 2846, 7719, 6494, 1032, 4006, 1058, 4832, 4629, 4540, 2846, 9318, 7175, 3261, 3037, 3123, 2732, 9664, 3332, 4622, 4488, 9128, 9795, 7653, 9133, 6823, 9756, 8388, 8471, 2687, 1227, 3162, 2754, 8822, 2247, 1928, 3842, 5745, 1694, 6104, 7829, 3343, 3132, 2675, 7154, 1142, 7050, 8380, 4578, 3408, 3035, 2007, 4018, 3483, 2817, 9713, 2438, 877, 3077, 6740, 103, 6612, 2931, 1456, 6911, 4830, 237, 2850, 419, 4878, 4278, 1210, 4514, 2769, 8936, 5263, 4725, 6741, 7472, 1445, 963, 518, 9252, 7407, 3132, 7263, 6905, 3058, 7008, 1812, 711, 4281, 6607, 94, 5060, 3100, 6727, 1136, 1874, 6568, 7226, 5367, 5468, 4341, 5293, 3119, 3591, 1156, 3290, 9502, 8701, 3378, 3608, 5316, 2298, 3268, 3087, 4697, 1402, 2701, 5544, 1888, 721, 4784, 4191, 2005, 5978, 4160, 1648, 3474, 1928, 9032, 5876, 9281, 9800, 3637, 242, 1928, 197, 9875, 5388, 479, 4132, 3499, 9750, 3723, 7774, 9191, 3005, 3512, 402, 5254, 6632, 6827, 5351, 9885, 9571, 9620, 2701, 6941, 954, 5918, 8886, 4364, 4101, 3975, 4679, 1805, 2815, 4048, 2689, 8049, 4449, 9308, 1948, 3529, 7619, 3557, 4797, 8649, 5010, 3215, 8244, 7701, 5370, 303, 1127, 698, 6143, 7503, 1326, 598, 2101, 9944, 3228, 9615, 9975, 5690, 450, 9893, 4486, 6153, 4166, 7394, 3803, 3360, 5755, 1433, 9107, 9129, 1293, 1652, 2469, 1319, 4825, 4064, 5465, 2177, 1507, 1972, 201, 7272, 9462, 2263, 2713, 4658, 8681, 7969, 7006, 3497, 9859, 9334, 3867, 3858, 3944, 5834, 5788, 5354, 341, 8660, 587, 3795, 1480, 75, 7408, 6295, 217, 8950, 9012, 4268, 6991, 7563, 1377, 1093, 7163, 1304, 2022, 130, 5209, 7749, 5874, 3702, 1076, 7810, 8671, 4001, 9814, 9039, 9485, 8329, 1682, 4242, 2019, 7834, 2560, 2272, 8361, 7181, 9318, 1969, 9884, 732, 639, 178, 5029, 8844, 2079, 7376, 7863, 791, 4769, 169, 2630, 5651, 534, 1233, 4876, 5047, 4678, 9034, 622, 789, 919, 5265, 4680, 3821, 7810, 6729, 4133, 9973, 9775, 7464, 9354, 4227, 1160, 635, 8289, 6268, 2036, 7977, 1268, 5171, 8444, 6638, 2372, 6740, 6637, 6897, 6340, 8145, 4036, 8449, 7349, 2221, 2478, 5206, 7757, 8490, 7024, 1576, 1217, 9027, 7388, 7214}, 9886);
        System.out.println("p4 = " + p4);
    }
}