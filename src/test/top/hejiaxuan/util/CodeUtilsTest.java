package top.hejiaxuan.util;

import org.junit.Test;

public class CodeUtilsTest {

    @Test
    public void jsonFormat() throws Exception {
        System.out.println(CodeUtils.jsonFormat(json));
    }

    String json = "{\n" +
            "    \"count\":1,\n" +
            "    \"insuranceNumber\":\"1\",\n" +
            "    \"insuredInfo\":[\n" +
            "        \"0\"\n" +
            "    ],\n" +
            "    \"insurerInfo\":[\n" +
            "        \"0\"\n" +
            "    ],\n" +
            "    \"params\":{\n" +
            "        \"InfoInsured\":[\n" +
            "            {\n" +
            "                \"age\":\"24\",\n" +
            "                \"annualIncome\":\"0\",\n" +
            "                \"appBrithday\":\"1993-12-06\",\n" +
            "                \"appCellPhone\":\"18237783704\",\n" +
            "                \"appCertiCode\":\"411381199312066096\",\n" +
            "                \"appCertiType\":\"120001\",\n" +
            "                \"appEmail\":\"s362793045@qq.com\",\n" +
            "                \"appName\":\"张氏四\",\n" +
            "                \"appNameFormat\":false,\n" +
            "                \"appRelation\":\"601005\",\n" +
            "                \"appSex\":\"M\",\n" +
            "                \"benefitedInfoList\":[\n" +
            "                    {\n" +
            "                        \"benefitedBirthDate\":755107200000,\n" +
            "                        \"benefitedCertiCode\":\"411381199312066096\",\n" +
            "                        \"benefitedCertiType\":\"120001\",\n" +
            "                        \"benefitedName\":\"张氏四\",\n" +
            "                        \"benifitpercent\":10000,\n" +
            "                        \"position\":1,\n" +
            "                        \"relationship\":\"601005\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"buyNum\":0,\n" +
            "                \"channelNameFormat\":false,\n" +
            "                \"coverage\":6000000,\n" +
            "                \"difDay\":0,\n" +
            "                \"emailFormat\":false,\n" +
            "                \"idCardFormat\":false,\n" +
            "                \"idCardNum\":0,\n" +
            "                \"phoneNum\":0,\n" +
            "                \"physical\":\"0\",\n" +
            "                \"socialFlag\":\"1\",\n" +
            "                \"validityDay\":0\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"status\":0\n" +
            "}\n";
}