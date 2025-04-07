package com.lizhongquan.toolkit;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGatt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.Map;
import java.util.TimerTask;
import java.util.regex.*;
import dalvik.system.DexClassLoader;

import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
// import okhttp3.Request;

public class XposedUtils implements IXposedHookLoadPackage {

    XC_MethodHook mRequest;

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        // AZ: for java2smali usage......
        // Log.e("xposed-amap", this.mRequest.toString());

//        final Random rand = new Random();
//
//        XposedHelpers.findAndHookMethod("android.telephony.TelephonyManager",
//                lpparam.classLoader, "getDeviceId",
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
//                        int randomNumber = rand.nextInt(1000000) + 1;
//                        param.setResult(randomNumber + "");
//                    }
//                });
//
//        XposedHelpers.findAndHookMethod("com.example.lizhongquan.test.coredex.MainActivity",
//                lpparam.classLoader, "test", new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
//                        param.setResult("hooked test");
//                    }
//                });

        // handleGeneral(lpparam);

        // com.ubercab

//        if ("com.lincoln.lincolnway".equals(lpparam.packageName)
//                || "com.sdl.hellosdlandroid".equals(lpparam.packageName)
//                || "com.glympse.android.glympse".equals(lpparam.packageName)
//                || "com.lincoln.lincolnalexa".equals(lpparam.packageName) ) {
//            Log.e("xposed-FORD", "handling FORD1 app...");
//            // handleOla(lpparam);
//            handleFord1(lpparam);
//
//        }
        if ("com.lincoln.lincolnway".equals(lpparam.packageName)
                || "com.sdl.hellosdlandroid".equals(lpparam.packageName)
                || "com.lincoln.lincolnalexa".equals(lpparam.packageName) ) {
            Log.e("xposed-FORD", "handling FORD1 app...");
            // handleOla(lpparam);
            handleFord1(lpparam);
        } else if ("com.ubercab".equals(lpparam.packageName)) {
            Log.e("xposed-uber", "handling uber cab...");
            // handleOla(lpparam);
            handleUber(lpparam);

        } else if ("br.com.easytaxi".equals(lpparam.packageName)) {
            Log.e("xposed-easy", "handling easy taxi");
            // handleOla(lpparam);
            handleEasy(lpparam);

        } else if ("com.olacabs.customer".equals(lpparam.packageName)) {
            Log.e("xposed-ola", "handling olacabs");
            // handleOla(lpparam);
            handleOlaB(lpparam);

        } else if ("jp.co.nikko_data.japantaxi".equals(lpparam.packageName)) {
            Log.e("xposed-japan", "handling japan-taxi");
            handleJapan(lpparam);
            handleJapanB(lpparam);

        } else if ("com.MobileTicket".equals(lpparam.packageName)) {

            handle12306B(lpparam);
            handle12306(lpparam);

        } else if ("com.sankuai.meituan.takeoutnew".equals(lpparam.packageName)) {
            handleMTWaimai(lpparam);
        } else if ("com.taxis99".equals(lpparam.packageName)) {
            handle99pop(lpparam);
        } else if ("com.olacabs.customer".equals(lpparam.packageName)) {
            handleOla(lpparam);
        } else if ("com.cornermation.calltaxi".equals(lpparam.packageName)) {
            handleHKTaxi(lpparam);
        } else if ("jp.co.nikko_data.japantaxi".equals(lpparam.packageName)) {
            handleJapanTaxi(lpparam);
        } else if ("com.dwd.rider".equals(lpparam.packageName)) {
            handleDianWoDaDriver(lpparam);
        } else if ("com.autonavi.minimap".equals(lpparam.packageName)) {
            // This is for GAO-DE MAP app...
            handleAmap(lpparam);
        } else if ("com.glympse.android.glympse".equals(lpparam.packageName)
            ||("com.glympse.android.glympse.Glympse").equals(lpparam.packageName)){
            Log.e("xposed-Glympse", "handling Glympse app...");
            handleGlympse(lpparam);
        }
    }

    /**
     * Japan Taxi @ ZW
     */
    private void handleJapan(final XC_LoadPackage.LoadPackageParam lpparam) {

        // jp/co/japantaxi/brooklyn/repository/api/c/a;->a(Ljava/lang/String;)
        XposedHelpers.findAndHookMethod("jp.co.japantaxi.brooklyn.repository.api.c.a",
                lpparam.classLoader, "a", String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-japan-Response", "...B........jp.co.japantaxi.brooklyn.repository.api.c.a->a(String).......");
                        String strParam = (String) (param.args[0]);
                        Log.e("xposed-japan-Response", "first parameter is " + strParam);
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });


        // "jp/co/japantaxi/brooklyn/repository/api/c/a;->a()",
        //        "jp/co/japantaxi/brooklyn/repository/api/c/a;->b()",
        //        "jp/co/japantaxi/brooklyn/repository/api/c/a;->c()",
        //        "jp/co/japantaxi/brooklyn/repository/api/c/a;->toString()",
        XposedHelpers.findAndHookMethod("jp.co.japantaxi.brooklyn.repository.api.c.a",
                lpparam.classLoader, "a", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-japan-Response", "...B........jp.co.japantaxi.brooklyn.repository.api.c.a->a().......");
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        String strRes = (String)(param.getResult());
                        Log.e("xposed-japan-Response", ".....E......jp.co.japantaxi.brooklyn.repository.api.c.a->a() returns " + strRes);
                    }
                });

        XposedHelpers.findAndHookMethod("jp.co.japantaxi.brooklyn.repository.api.c.a",
                lpparam.classLoader, "b", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-japan-Response", "...B........jp.co.japantaxi.brooklyn.repository.api.c.a->b().......");
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        String strRes = (String)(param.getResult());
                        Log.e("xposed-japan-Response", ".....E......jp.co.japantaxi.brooklyn.repository.api.c.a->b() returns " + strRes);
                    }
                });

        XposedHelpers.findAndHookMethod("jp.co.japantaxi.brooklyn.repository.api.c.a",
                lpparam.classLoader, "c", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-japan-Response", "...B........jp.co.japantaxi.brooklyn.repository.api.c.a->c().......");
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Boolean strRes = (Boolean)(param.getResult());
                        Log.e("xposed-japan-Response", ".....E......jp.co.japantaxi.brooklyn.repository.api.c.a->c() returns " + strRes);
                    }
                });

        XposedHelpers.findAndHookMethod("jp.co.japantaxi.brooklyn.repository.api.c.a",
                lpparam.classLoader, "toString", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-japan-Response", "...B........jp.co.japantaxi.brooklyn.repository.api.c.a->toString().......");
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        String strRes = (String)(param.getResult());
                        Log.e("xposed-japan-Response", ".....E......jp.co.japantaxi.brooklyn.repository.api.c.a->toString() returns " + strRes);
                    }
                });

        // invoke-virtual {v0, v1}, Ljp/co/japantaxi/brooklyn/repository/api/c/d/b$a;->a(Ljava/lang/String;)Ljp/co/japantaxi/brooklyn/repository/api/c/d/b$a;

        XposedHelpers.findAndHookMethod("jp.co.japantaxi.brooklyn.repository.api.c.d.b$a",
                lpparam.classLoader, "a", String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-japan", "...B........jp.co.japantaxi.brooklyn.repository.api.c.d.b$a->a.......");
                        String strParam = (String) (param.args[0]);
                        Log.e("xposed-japan", "first parameter is " + strParam);
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("jp.co.japantaxi.brooklyn.repository.api.c.d.b$a",
                lpparam.classLoader, "b", String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-japan", "...B........jp.co.japantaxi.brooklyn.repository.api.c.d.b$a->b.......");
                        String strParam = (String) (param.args[0]);
                        Log.e("xposed-japan", "first parameter is " + strParam);
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("jp.co.japantaxi.brooklyn.repository.api.c.d.b$a",
                lpparam.classLoader, "c", String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-japan", "...B........jp.co.japantaxi.brooklyn.repository.api.c.d.b$a;->c.......");
                        String strParam = (String) (param.args[0]);
                        Log.e("xposed-japan", "first parameter is " + strParam);
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("jp.co.japantaxi.brooklyn.repository.api.c.d.b$a",
                lpparam.classLoader, "d", String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-japan", "...B........jp.co.japantaxi.brooklyn.repository.api.c.d.b$a;->d.......");
                        String strParam = (String) (param.args[0]);
                        Log.e("xposed-japan", "first parameter is " + strParam);
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("com.google.android.gms.common.internal.j",
                lpparam.classLoader, "c", "android.content.Context", int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-japan", "...B........com.google.android.gms.common.internal.j.......");
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("okhttp3.t$a",
                lpparam.classLoader, "toString", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-japan", "...B.....okhttp3/t$a->toString..........");
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        String str = (String )(param.getResult());
                        Log.e("xposed-japan", "...B.....okhttp3/t$a->toString returns .........." + str);
                    }
                });
    }

    Object parameterType(String pstr) {

        // if (pstr.startsWith("Ljava/lang/") && pstr.substring(11).equals("String")){
        //         return String.class;
        // } else

        if (pstr.startsWith("[")) {
            int lidx = pstr.indexOf('L');
            if (lidx >= 1) {
                StringBuilder sbuilder = new StringBuilder();
                sbuilder.append(pstr.substring(lidx + 1).replace('/', '.'));
                for (int i = 0; i < lidx; i++) {
                    sbuilder.append("[]");
                }
                return sbuilder.toString();
            }
        }
        if (pstr.startsWith("L")) {
            return pstr.substring(1).replace('/', '.');
        }

        if (pstr.equals("J")) {
            return long.class;
        }
        if (pstr.equals("I")) {
            return int.class;
        }
        if (pstr.equals("Z")) {
            return boolean.class;
        }
        if (pstr.equals("B")) {
            return byte.class;
        }
        if (pstr.equals("C")) {
            return char.class;
        }
        if (pstr.equals("S")) {
            return short.class;
        }
        if (pstr.equals("F")) {
            return float.class;
        }
        if (pstr.equals("D")) {
            return double.class;
        }
        return null;
    }

    private void findAndHook(final XC_LoadPackage.LoadPackageParam lpparam, String proto) {

        System.err.println("xposed-12306-itrace: working on function: " + proto);
        Pattern pattern = Pattern.compile("(\\S+);->(\\S+)\\((\\S*)\\)\\S*");
        Matcher matcher = pattern.matcher(proto);
        String cname;

        if (matcher.matches()) {
            Log.e("xposed--itrace-conf", "Group 0: " + matcher.group(0));
            Log.e("xposed--itrace-conf", "Group 1: " + matcher.group(1));
            Log.e("xposed--itrace-conf", "Group 2: " + matcher.group(2));
            Log.e("xposed--itrace-conf", "Group 3: " + matcher.group(3));
            cname = matcher.group(1);
            String classname = cname.replace('/', '.');
            String mname = matcher.group(2);
            String paramsStr = matcher.group(3);
            String[] params = paramsStr.split(";");

            // findAndHook(lpparam, classname, mname, params);
            findAndHookSimplified(lpparam, classname, mname, params);
        }

    }

    private void findAndHook4SDL(final XC_LoadPackage.LoadPackageParam lpparam, String proto) {

        System.err.println("xposed-FORDSDL-itrace: working on function: " + proto);
        Pattern pattern = Pattern.compile("(\\S+);->(\\S+)\\((\\S*)\\)\\S*");
        Matcher matcher = pattern.matcher(proto);
        String cname;

        if (matcher.matches()) {
            Log.e("xposed--FORDSDL-conf", "Group 0: " + matcher.group(0));
            Log.e("xposed--FORDSDL-conf", "Group 1: " + matcher.group(1));
            Log.e("xposed--FORDSDL-conf", "Group 2: " + matcher.group(2));
            Log.e("xposed--FORDSDL-conf", "Group 3: " + matcher.group(3));
            cname = matcher.group(1);
            String classname = cname.replace('/', '.');
            String mname = matcher.group(2);
            String paramsStr = matcher.group(3);
            String[] params = paramsStr.split(";");

            // findAndHook(lpparam, classname, mname, params);
            findAndHookSimplified4SDL(lpparam, classname, mname, params);
        }

    }

    private void findAndHookSimplified4SDL(final XC_LoadPackage.LoadPackageParam lpparam, final String cname, final String mname, String[] params) {

        ArrayList<Object> alist = new ArrayList<Object>();

        if (params.length > 0) {
            for (String param : params) {
                Object obj = parameterType(param);
                if (obj != null) {
                    alist.add(obj);
                    System.out.println("xposed-FORDSDL-itrace......param: " + obj.toString());
                }
            }
        }

        XC_MethodHook methodHook = new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                if (param.args != null) {
                    Object obj1 = param.args[0];
                    if (obj1 != null)
                        Log.e("xposed-FORDSDL-param", "first parameter is " + obj1.toString());
                    else
                        Log.e("xposed-FORDSDL-param", "first parameter is NULL...");
                    if (obj1 instanceof String) {
                        String strParam = (String) obj1;
                        obj1 = "To TEST SDL ParaMeter MODIFICATION!!! LOL~~~~";
                        param.args[0] = "To TEST SDL ParaMeter MODIFICATION!!! LOL~~~~";
                        Log.e("xposed-FORDSDL-param", "TRYING to update the first parameter to " + obj1.toString());
                    }
                    if (obj1.getClass().getName().equals("java.lang.Integer")) {
                        Integer intParam = (Integer) obj1;
                        Log.e("xposed-FORDSDL-param", "first parameter is " + intParam);
                    }

                    if (param.args.length > 1) {
                        Object obj2 = param.args[1];
                        if (obj2 instanceof String) {
                            String strParam = (String) obj2;
                            Log.e("xposed-FORDSDL-param", "second parameter is " + strParam);
                        }
                        if (obj2.getClass().getName().equals("java.lang.Integer")) {
                            Integer intParam = (Integer) obj2;
                            Log.e("xposed-FORDSDL-param", "second parameter is " + intParam);
                        }
                    }
                }
                Log.e("xposed-FORDSDL-itrace", "...B........" + cname + ";->" + mname);
                Throwable e = new Throwable();
                e.printStackTrace();
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Object retObj = param.getResult();
                if (retObj instanceof String) {
                    String strRes = (String) retObj;
                    Log.e("xposed-FORDSDL-param", "the return value is " + strRes);
                }
                Log.e("xposed-FORDSDL-itrace", "...E..." + cname + ";->" + mname);
            }

        };

        alist.add(methodHook);
        XposedHelpers.findAndHookMethod(cname, lpparam.classLoader, mname, alist.toArray(new Object[alist.size()]));
    }

    private void findAndHookSimplified(final XC_LoadPackage.LoadPackageParam lpparam, final String cname, final String mname, String[] params) {

        ArrayList<Object> alist = new ArrayList<Object>();

        if (params.length > 0) {
            for (String param : params) {
                Object obj = parameterType(param);
                if (obj != null) {
                    alist.add(obj);
                    System.out.println("xposed-12306-itrace......param: " + obj.toString());
                }
            }
        }

        XC_MethodHook methodHook = new XC_MethodHook() {

            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                if (param.args != null) {
                    Object obj1 = param.args[0];
                    Log.e("xposed-OLA-paramtrace", "first parameter is " + obj1.toString());
                    if (obj1 instanceof String) {
                        String strParam = (String) obj1;
                        Log.e("xposed-12306-paramtrace", "first parameter is " + strParam);
                    }
                    if (obj1.getClass().getName().equals("java.lang.Integer")) {
                        Integer intParam = (Integer) obj1;
                        Log.e("xposed-12306-paramtrace", "first parameter is " + intParam);
                    }

                    if (param.args.length > 1) {
                        Object obj2 = param.args[1];
                        if (obj2 instanceof String) {
                            String strParam = (String) obj2;
                            Log.e("xposed-12306-paramtrace", "second parameter is " + strParam);
                        }
                        if (obj2.getClass().getName().equals("java.lang.Integer")) {
                            Integer intParam = (Integer) obj2;
                            Log.e("xposed-12306-paramtrace", "second parameter is " + intParam);
                        }
                    }
                }
                Log.e("xposed-12306-itrace", "...B........" + cname + ";->" + mname);
                Throwable e = new Throwable();
                e.printStackTrace();
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Object retObj = param.getResult();
                if (retObj instanceof String) {
                    String strRes = (String) retObj;
                    Log.e("xposed-12306-paramtrace", "the return value is " + strRes);
                }
                Log.e("xposed-12306-itrace", "...E..." + cname + ";->" + mname);
            }

        };

        alist.add(methodHook);
        XposedHelpers.findAndHookMethod(cname, lpparam.classLoader, mname, alist.toArray(new Object[alist.size()]));
    }

    private void handleUber(final XC_LoadPackage.LoadPackageParam lpparam) {

        /*XposedHelpers.findAndHookMethod("okhttp3.Request$Builder",
                lpparam.classLoader, "addHeader", "java.lang.String", "java.lang.String", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        String key = (String) (param.args[0]);
                        String val = (String)(param.args[1]);
                        Log.e("xposed-uber", "......REQ add header......" + key + " --- " + val);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("okhttp3.OkHttpClient",
                lpparam.classLoader, "newCall", "okhttp3.Request", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);


                        Object arg0 = param.args[0];
                        Log.e("xposed-uber", "......Beginning NewCall......" + arg0.toString());
                        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                        Log.e("xposed-uber", "==========");

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });
        ***/

        XposedHelpers.findAndHookMethod("com.ubercab.presidio.PresidioApplication",
                lpparam.classLoader, "onCreate", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Log.e("xposed-uber", "......Beginning onCreate......");
                        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                        Log.e("xposed-uber", "==========");

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("okhttp3.HttpUrl",
                lpparam.classLoader, "resolve", String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        String url = (String) (param.args[0]);

                        Log.e("xposed-uber", "......Beginning HttpUrl resolve ......" + url);
                        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                        Log.e("xposed-uber", "====Trying to hook Request$Builder ======");

                        XposedHelpers.findAndHookMethod("okhttp3.Request$Builder",
                                lpparam.classLoader, "addHeader", "java.lang.String", "java.lang.String", new XC_MethodHook() {
                                    @Override
                                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                        super.beforeHookedMethod(param);
                                        String key = (String) (param.args[0]);
                                        String val = (String)(param.args[1]);
                                        Log.e("xposed-uber", "......REQ add header/inside......" + key + " --- " + val);
                                        Throwable e = new Throwable();
                                        e.printStackTrace();
                                    }

                                    @Override
                                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                        super.afterHookedMethod(param);
                                    }
                                });

                        XposedHelpers.findAndHookMethod("okhttp3.Request$Builder",
                                lpparam.classLoader, "header", "java.lang.String", "java.lang.String", new XC_MethodHook() {
                                    @Override
                                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                        super.beforeHookedMethod(param);
                                        String key = (String) (param.args[0]);
                                        String val = (String)(param.args[1]);
                                        Log.e("xposed-uber", "......REQ set header/inside......" + key + " --- " + val);
                                        Throwable e = new Throwable();
                                        e.printStackTrace();
                                    }

                                    @Override
                                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                        super.afterHookedMethod(param);
                                    }
                                });

                        XposedHelpers.findAndHookMethod("okhttp3.OkHttpClient",
                                lpparam.classLoader, "newCall", "okhttp3.Request", new XC_MethodHook() {
                                    @Override
                                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                        super.beforeHookedMethod(param);


                                        /*** WZ-0909
                                        Object arg0 = param.args[0];
                                        final Class<?> reqClass = XposedHelpers.findClass("okhttp3.Request", lpparam.classLoader);
                                        Object arg0 = XposedHelpers.newInstance(reqClass, param.args[0], "okhttp3.Request$Builder");
                                        Object arg0 = XposedHelpers.newInstance(reqClass, param.args);
                                        String hstr = (String)XposedHelpers.callMethod(arg0, "headers");
                                         ******/

                                        Object arg0 = param.args[0];
                                        Object headers = XposedHelpers.getObjectField(param.args[0], "headers");
                                        String[] hstr = (String [])XposedHelpers.getObjectField(headers, "namesAndValues");

                                        // TBD: can we use reflection to find the reference to class "okhttp3.Request" and its methods???
                                        // okhttp3.Request arg0 = param.args[0];
                                        Log.e("xposed-uber", "......Beginning NewCall......" + arg0.toString());
                                        Log.e("xposed-UBER", ".........REQ headers are: ..." + Arrays.toString(hstr));
                                        Throwable e = new Throwable();
                                        e.printStackTrace();
                                        Log.e("xposed-uber", "==========");

                                    }

                                    @Override
                                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                        super.afterHookedMethod(param);
                                    }
                                });

                        Log.e("xposed-uber", "hooking Request$Builder finished");
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("okhttp3.Request$Builder",
                lpparam.classLoader, "addHeader", "java.lang.String", "java.lang.String", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        String key = (String) (param.args[0]);
                        String val = (String)(param.args[1]);
                        Log.e("xposed-uber", "......REQ add header......" + key + " --- " + val);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("okhttp3.Request$Builder",
                lpparam.classLoader, "header", "java.lang.String", "java.lang.String", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        String key = (String) (param.args[0]);
                        String val = (String)(param.args[1]);
                        Log.e("xposed-uber", "......REQ set header/outside......" + key + " --- " + val);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

    }

    private void handleEasy(final XC_LoadPackage.LoadPackageParam lpparam) {

        String methodProtos2[] = {
                // "com/android/volley/i$b;->a(Ljava/lang/Object;)V",
                // "okhttp3/aa$a;->b(Ljava/lang/String;Ljava/lang/String;)"
                // "com/olacabs/customer/model/OlaGsonRequest;->deliverResponse(Ljava/lang/Object;)V"
        };

/****
        XposedHelpers.findAndHookMethod("okhttp3.OkHttpClient",
                lpparam.classLoader, "newCall", "okhttp3.Request", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);


                        Object arg0 = param.args[0];
                        Log.e("xposed-EASY", "......Beginning NewCall......" + arg0.toString());
                        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                        Log.e("xposed-EASY", "==========");

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        // Object res = param.getResult();
                        // BasicHttpResponse basicRes = (BasicHttpResponse) res;
                        // HttpEntity entity = basicRes.getEntity();
                        // String respStr = EntityUtils.toString(basicRes.getEntity());
                        // Log.e("xposed-OLA", "......Ending PerformResponse......Result is : " + respStr);
                    }
                });
***/

//infrastructure/network/d/b

        XposedHelpers.findAndHookMethod("br.com.easytaxi.infrastructure.network.d.b",
                lpparam.classLoader, "a", "okhttp3.Request", "br.com.easytaxi.infrastructure.network.result.shared.AbstractEndpointResult",
                "android.os.Handler", "br.com.easytaxi.infrastructure.network.b.e.c", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Object arg0 = param.args[0];
                        Log.e("xposed-EASY", "......Beginning NewCall......" + arg0.toString());
                        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("br.com.easytaxi.infrastructure.network.d.b",
                lpparam.classLoader, "a", String.class, Object.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Object arg0 = param.args[0];
                        Object arg1 = param.args[1];
                        Log.e("xposed-EASY", "......Adding Header -- " + arg0.toString() + " value -- " + arg1.toString());
                        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("br.com.easytaxi.infrastructure.network.d.b",
                lpparam.classLoader, "b", String.class, Object.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Object arg0 = param.args[0];
                        Object arg1 = param.args[1];
                        Log.e("xposed-EASY", "......Adding Parameter -- " + arg0.toString() + " value -- " + arg1.toString());
                        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("okhttp3.ResponseBody",
                lpparam.classLoader, "string", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        String result = (String)(param.getResult());
                        Log.e("xposed-EASY", "......RESPONSE BODY string returns ......" + result);

                    }
                });


        XposedHelpers.findAndHookMethod("io.reactivex.y",
                lpparam.classLoader, "b", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-EASY", "......REQ add header......");
                        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        // okhttp3/aa$a;->b
        /**************
         XposedHelpers.findAndHookMethod("okhttp3.aa$a",
         lpparam.classLoader, "b", "java.lang.String", "java.lang.String", new XC_MethodHook() {
        @Override
        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        String key = (String) (param.args[0]);
        String val = (String)(param.args[1]);
        Log.e("xposed-OLA", "......REQ add header......" + key + " --- " + val);
        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
        Throwable e = new Throwable();
        e.printStackTrace();
        }

        @Override
        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
        }
        });



         XposedHelpers.findAndHookMethod("com.olacabs.customer.u.ad",
         lpparam.classLoader, "a", new XC_MethodHook() {
        @Override
        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        Log.e("xposed-OLA", "......Checking Root 1......");
        Throwable e = new Throwable();
        e.printStackTrace();
        }

        @Override
        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
        param.setResult(false);
        Log.e("xposed-OLA", "......setting getRoot1 to false");
        }
        });

         XposedHelpers.findAndHookMethod("com.olacabs.customer.u.ad",
         lpparam.classLoader, "a", "android.content.Context", new XC_MethodHook() {
        @Override
        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        Log.e("xposed-OLA", "......Checking Root 2......");
        Throwable e = new Throwable();
        e.printStackTrace();
        }

        @Override
        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
        param.setResult(false);
        Log.e("xposed-OLA", "......setting getRoot2XXX to false");
        }
        });

         XposedHelpers.findAndHookMethod("com.olacabs.customer.model.bt",
         lpparam.classLoader, "isRooted", new XC_MethodHook() {
        @Override
        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        Log.e("xposed-OLA", "......Model.DeviceInfo Checking Root 1......");
        Throwable e = new Throwable();
        e.printStackTrace();
        }

        @Override
        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
        param.setResult(false);
        Log.e("xposed-OLA", "......setting Model.DeviceInfo->CheckingRoot1 to false");
        }
        });

         XposedHelpers.findAndHookMethod("com.olacabs.customer.model.bt",
         lpparam.classLoader, "getRootBeerCheck", new XC_MethodHook() {
        @Override
        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        Log.e("xposed-OLA", "......Model.DeviceInfo Checking Root 2......");
        Throwable e = new Throwable();
        e.printStackTrace();
        }

        @Override
        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
        param.setResult("NA");
        Log.e("xposed-OLA", "......setting Model.DeviceInfo->CheckingRoot2 to false");
        }
        });

         XposedHelpers.findAndHookMethod("com.olacabs.customer.ui.MainActivity",
         lpparam.classLoader, "o", new XC_MethodHook() {
        @Override
        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        Log.e("xposed-OLA", "......ui.MainActivity to quit the execution of method o ......");
        Throwable e = new Throwable();
        e.printStackTrace();
        param.setResult(null); // Quit the execution of this method named 'o'
        }
        });
         **************/
        // com.olacabs.customer.model.bt.isRooted

        /*****************
         XposedHelpers.findAndHookMethod("com.android.volley.i$b",
         lpparam.classLoader, "a", "java.lang.Object", new XC_MethodHook() {
        @Override
        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        Object arg0 = param.args[0];
        Log.e("xposed-OLA", " response Listener " + arg0.toString());
        Throwable e = new Throwable();
        e.printStackTrace();
        }

        @Override
        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
        }
        });


         System.out.println("xposed-OLA-itrace-conf" + " ...entering handleOLAB..................");
         Log.e("xposed-OLA-itrace-conf", "...entering handleOLAB..................");

         for (String mproto: methodProtos2) {
         System.out.println("xposed-OLA-itrace........... to work on: " + mproto);
         findAndHook(lpparam, mproto);
         }
         ****************/

    }

    private void handleOlaB(final XC_LoadPackage.LoadPackageParam lpparam) {

        String methodProtos2[] = {
                // "com/android/volley/i$b;->a(Ljava/lang/Object;)V",
                "okhttp3/aa$a;->b(Ljava/lang/String;Ljava/lang/String;)"
                // "com/olacabs/customer/model/OlaGsonRequest;->deliverResponse(Ljava/lang/Object;)V"
        };


        XposedHelpers.findAndHookMethod("com.olacabs.customer.app.q",
                lpparam.classLoader, "a", "com.android.volley.h", "java.util.Map", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        // This is an work-around for classNotFound issue...
                        XposedHelpers.findAndHookMethod("okhttp3.aa$a",
                                lpparam.classLoader, "b", "java.lang.String", "java.lang.String", new XC_MethodHook() {
                                    @Override
                                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                        super.beforeHookedMethod(param);
                                        String key = (String) (param.args[0]);
                                        String val = (String)(param.args[1]);
                                        Log.e("xposed-OLA", "......REQ add header......" + key + " --- " + val);
                                        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
                                        Throwable e = new Throwable();
                                        e.printStackTrace();
                                    }

                                    @Override
                                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                        super.afterHookedMethod(param);
                                    }
                                });

                        Object arg0 = param.args[0];
                        Map paramMap = (Map)(param.args[1]);
                        Log.e("xposed-OLA", "......Beginning PerformResponse......" + arg0.toString());
                        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
                        Iterator v2 = paramMap.keySet().iterator();
                        while (v2.hasNext()) {
                            Object v3 = v2.next();
                            Log.e("xposed-OLA", "Key - " + ((String)v3) + ", value - " + paramMap.get(v3));
                        }
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Object res = param.getResult();
                        BasicHttpResponse basicRes = (BasicHttpResponse) res;
                        // HttpEntity entity = basicRes.getEntity();
                        String respStr = EntityUtils.toString(basicRes.getEntity());
                        Log.e("xposed-OLA", "......Ending PerformResponse......Result is : " + respStr);
                    }
                });

        // okhttp3/aa$a;->b
        /**************
        XposedHelpers.findAndHookMethod("okhttp3.aa$a",
                lpparam.classLoader, "b", "java.lang.String", "java.lang.String", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        String key = (String) (param.args[0]);
                        String val = (String)(param.args[1]);
                        Log.e("xposed-OLA", "......REQ add header......" + key + " --- " + val);
                        // Log.e("xposed-OLA", ".........REQ header is: ..." + arg0.getHeaders().keySet);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });



        XposedHelpers.findAndHookMethod("com.olacabs.customer.u.ad",
                lpparam.classLoader, "a", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-OLA", "......Checking Root 1......");
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        param.setResult(false);
                        Log.e("xposed-OLA", "......setting getRoot1 to false");
                    }
                });

        XposedHelpers.findAndHookMethod("com.olacabs.customer.u.ad",
                lpparam.classLoader, "a", "android.content.Context", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-OLA", "......Checking Root 2......");
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        param.setResult(false);
                        Log.e("xposed-OLA", "......setting getRoot2XXX to false");
                    }
                });

        XposedHelpers.findAndHookMethod("com.olacabs.customer.model.bt",
                lpparam.classLoader, "isRooted", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-OLA", "......Model.DeviceInfo Checking Root 1......");
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        param.setResult(false);
                        Log.e("xposed-OLA", "......setting Model.DeviceInfo->CheckingRoot1 to false");
                    }
                });

        XposedHelpers.findAndHookMethod("com.olacabs.customer.model.bt",
                lpparam.classLoader, "getRootBeerCheck", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-OLA", "......Model.DeviceInfo Checking Root 2......");
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        param.setResult("NA");
                        Log.e("xposed-OLA", "......setting Model.DeviceInfo->CheckingRoot2 to false");
                    }
                });

        XposedHelpers.findAndHookMethod("com.olacabs.customer.ui.MainActivity",
                lpparam.classLoader, "o", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-OLA", "......ui.MainActivity to quit the execution of method o ......");
                        Throwable e = new Throwable();
                        e.printStackTrace();
                        param.setResult(null); // Quit the execution of this method named 'o'
                    }
                });
        **************/
        // com.olacabs.customer.model.bt.isRooted

        /*****************
        XposedHelpers.findAndHookMethod("com.android.volley.i$b",
                lpparam.classLoader, "a", "java.lang.Object", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Object arg0 = param.args[0];
                        Log.e("xposed-OLA", " response Listener " + arg0.toString());
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });


        System.out.println("xposed-OLA-itrace-conf" + " ...entering handleOLAB..................");
        Log.e("xposed-OLA-itrace-conf", "...entering handleOLAB..................");

        for (String mproto: methodProtos2) {
            System.out.println("xposed-OLA-itrace........... to work on: " + mproto);
            findAndHook(lpparam, mproto);
        }
         ****************/

    }
    private void handleFord1(final XC_LoadPackage.LoadPackageParam lpparam) {

        String methodProtos[] = {
                // "com/fordmps/mobileapp/application/FordApplication;->onCreate()V",
                // "com/smartdevicelink/proxy/rpc/listeners/OnRPCResponseListener;->onResponse(ILcom/smartdevicelink/proxy/RPCResponse;)V",
                // "com/smartdevicelink/api/view/SdlAlertDialog;->send(Lcom/smartdevicelink/api/interfaces/SdlContext;Lcom/smartdevicelink/api/interfaces/SdlInteractionResponseListener;)Z",
                // "com/smartdevicelink/managers;->sendRPC(Lcom/smartdevicelink/proxy/RPCMessage;)V",
                // "com/smartdevicelink/managers/screen/ScreenManager;->beginTransaction()V",
                "com/smartdevicelink/managers/screen/ScreenManager;->setTextField1(Ljava/lang/String;)V",
                "com/smartdevicelink/managers/screen/ScreenManager;->setTextField2(Ljava/lang/String;)V"
                // "com/smartdevicelink/managers/screen/menu/MenuCell;-><init>(Ljava/lang/String;Lcom/smartdevicelink/managers/file/filetypes/SdlArtwork;Ljava/util/List;Lcom/smartdevicelink/managers/screen/menu/MenuSelectionListener;)V"
        };

        // System.out.println("class name is " + className);
        System.out.println("xposed-FORDSDL-itrace" + " ...entering handleFord1..................");
        Log.e("xposed-FORDSDL-itrace", "...entering handleFord1..................");

        for (String mproto: methodProtos) {
            System.out.println("xposed-FORDSDL-itrace........... to work on: " + mproto);
            findAndHook4SDL(lpparam, mproto);
        }

        String meth2tamper[] = {
                "com/smartdevicelink/proxy/rpc/TTSChunk;->setText(Ljava/lang/String;)V"
        };
        /*****for (String mproto: meth2tamper) {
            System.out.println("xposed-FORDSDL-TAMPER........... to work on: " + mproto);
            findAndTamper4SDL(lpparam, mproto);
        }*****/

        // To handle GpsData
        // Lcom/smartdevicelink/proxy/rpc/OnVehicleData;->getGps()Lcom/smartdevicelink/proxy/rpc/GPSData;
        XposedHelpers.findAndHookMethod("com.smartdevicelink.proxy.rpc.OnVehicleData",
                lpparam.classLoader, "getGps", String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-FORD1", "...B........com.smartdevicelink.proxy.rpc.OnVehicleData;->getGps.......");
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Log.e("xposed-FORD1", "... getGps finished.");
                        Object res = param.getResult();
                        byte[] res1 = (byte[]) res;
                        Log.e("Xposed-12306/mpass", "...getGps returns : " + Arrays.toString(res1));
                    }
                });


        // To handle TTS manipulation
        XposedHelpers.findAndHookMethod("com.smartdevicelink.proxy.rpc.TTSChunk",
                lpparam.classLoader, "setText", String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("xposed-japan", "...B........com.smartdevicelink.proxy.rpc.TTSChunk;->setText.......");
                        String strParam = (String) (param.args[0]);
                        Object obj1 = param.args[0];
                        // String strParam = (String) obj1;
                        obj1 = "Damn";
                        param.args[0] = "Damn";
                        Log.e("xposed-FORDSDL-param", "TRYING to update the first parameter to " + obj1.toString());

                        Log.e("xposed-japan", "first parameter is " + strParam);
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        // To handle MenuCell
        Log.e("xposed-FORDSDL-itrace", "...HANDLING MENUCELL..................");
        Class<?> clazzMenuCell = XposedHelpers.findClass("com.smartdevicelink.managers.screen.menu.MenuCell", lpparam.classLoader);
        XposedBridge.hookAllConstructors(clazzMenuCell, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                if (param.args != null) {
                    Object obj1 = param.args[0];
                    if (obj1 != null)
                        Log.e("xposed-FORDSDL-param", "first parameter is " + obj1.toString());
                    else
                        Log.e("xposed-FORDSDL-param", "first parameter is NULL...");
                    if (obj1 instanceof String) {
                        String strParam = (String) obj1;
                        obj1 = "DIDIDIDI" + strParam;
                        param.args[0] = "DIDIDIDI" + strParam;
                        Log.e("xposed-FORDSDL-param", "TRYING to update the first parameter to " + obj1.toString());
                    }
                    if (obj1 != null && obj1.getClass().getName().equals("java.lang.Integer")) {
                        Integer intParam = (Integer) obj1;
                        Log.e("xposed-FORDSDL-param", "first parameter is " + intParam);
                    }

                    if (param.args.length > 1) {
                        Object obj2 = param.args[1];
                        if (obj2 instanceof String) {
                            String strParam = (String) obj2;
                            Log.e("xposed-FORDSDL-param", "second parameter is " + strParam);
                        }
                        if (obj2 != null && obj2.getClass().getName().equals("java.lang.Integer")) {
                            Integer intParam = (Integer) obj2;
                            Log.e("xposed-FORDSDL-param", "second parameter is " + intParam);
                        }
                    }
                }
                Log.e("xposed-FORDSDL-itrace", "...B........com.smartdevicelink.managers.screen.menu.MenuCell" + ";-><INIT>");
                // Throwable e = new Throwable();
                // e.printStackTrace();
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Object retObj = param.getResult();
                if (retObj instanceof String) {
                    String strRes = (String) retObj;
                    Log.e("xposed-FORDSDL-param", "the return value is " + strRes);
                }
                Log.e("xposed-FORDSDL-itrace", "...E...com.smartdevicelink.managers.screen.menu.MenuCell" + ";-><INIT>");
            }

        });

        // Handling ChoiceCell
        Log.e("xposed-FORDSDL-itrace", "...HANDLING ChoiceCELL..................");
        Class<?> clazzChoiceCell = XposedHelpers.findClass("com.smartdevicelink.managers.screen.choiceset.ChoiceCell", lpparam.classLoader);
        XposedBridge.hookAllConstructors(clazzChoiceCell, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                if (param.args != null) {
                    Object obj1 = param.args[0];
                    if (obj1 != null)
                        Log.e("xposed-SDL-ChoiceCell", "first parameter is " + obj1.toString());
                    else
                        Log.e("xposed-SDL-ChoiceCell", "first parameter is NULL...");
                    if (obj1 instanceof String) {
                        String strParam = (String) obj1;
                        obj1 = "DIDIDIDI" + strParam;
                        param.args[0] = "DIDIDIDI" + strParam;
                        Log.e("xposed-SDL-ChoiceCell", "TRYING to update the first parameter to " + obj1.toString());
                    }

                    if (param.args.length > 1) {
                        Object obj2 = param.args[1];
                        if (obj2 instanceof String) {
                            String strParam = (String) obj2;
                            Log.e("xposed-SDL-ChoiceCell", "second parameter is " + strParam);
                        }
                    }
                }
                Log.e("xposed-SDL-ChoiceCell", "...B........com.smartdevicelink.managers.screen.ChoiceSet.ChoiceCell" + ";-><INIT>");
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Object retObj = param.getResult();
                if (retObj instanceof String) {
                    String strRes = (String) retObj;
                    Log.e("xposed-SDL-ChoiceCell", "the return value is " + strRes);
                }
                Log.e("xposed-SDL-ChoiceCell", "...E...com.smartdevicelink.managers.screen.ChoiceSet.ChoiceCell" + ";-><INIT>");
            }

        });

    }

    private void handleGlympse(final XC_LoadPackage.LoadPackageParam lpparam) {
//        if (!lpparam.packageName.equals("com.glympse.android.glympse")) return;

        Log.e("xposed-Glympse", "Hook Glympse beginning...");

        // 1. Hook system location: getLatitude
        try {
            XposedHelpers.findAndHookMethod("android.location.Location",
                    lpparam.classLoader,
                    "getLatitude",
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            double originalLat = ((Double) param.getResult()).doubleValue();
                            Log.e("xposed-Glympse", "Original Latitude: " + originalLat);
                            param.setResult(40.7128);
                            Log.e("xposed-Glympse", "Modified Latitude: 40.7128");
                        }
                    });
            Log.e("xposed-Glympse", "Hook getLatitude SUCCESS");
        } catch (Throwable t) {
            Log.e("xposed-Glympse", "Hook getLatitude FAILED: " + Log.getStackTraceString(t));
        }

        // 2. Hook getLongitude
        try {
            XposedHelpers.findAndHookMethod("android.location.Location",
                    lpparam.classLoader,
                    "getLongitude",
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            double originalLong = ((Double) param.getResult()).doubleValue();
                            Log.e("xposed-Glympse", "Original Longitude: " + originalLong);
                            param.setResult(-74.0060);
                            Log.e("xposed-Glympse", "Modified Longitude: -74.0060");
                        }
                    });
            Log.e("xposed-Glympse", "Hook getLongitude SUCCESS");
        } catch (Throwable t) {
            Log.e("xposed-Glympse", "Hook getLongitude FAILED: " + Log.getStackTraceString(t));
        }

        // 3. Hook Glympse internal location API
        try {
            Class<?> gLocationClass = lpparam.classLoader.loadClass("com.glympse.android.hal.Location");

            XposedHelpers.findAndHookMethod(gLocationClass,
                    "getLatitude",
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            param.setResult(40.7128);
                            Log.e("xposed-Glympse", "Modified Glympse Latitude API");
                        }
                    });

            XposedHelpers.findAndHookMethod(gLocationClass,
                    "getLongitude",
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            param.setResult(-74.0060);
                            Log.e("xposed-Glympse", "Modified Glympse Longitude API");
                        }
                    });

            Log.e("xposed-Glympse", "Hook Glympse internal Location API SUCCESS");
        } catch (Throwable t) {
            Log.e("xposed-Glympse", "Hook Glympse internal Location API FAILED: " + Log.getStackTraceString(t));
        }

        // 4. Hook BluetoothGattCharacteristic.setValue(byte[])
        try {
            Log.e("xposed-Glympse", "Modifying bluetooth...");
            XposedHelpers.findAndHookMethod("android.bluetooth.BluetoothGattCharacteristic",
                    lpparam.classLoader,
                    "setValue",
                    byte[].class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            byte[] data = (byte[]) param.args[0];

                            // 打印 setValue() 方法的数据
                            Log.e("xposed-Glympse", "setValue() called with: " + Arrays.toString(data));

                            // 打印调用栈
                            Log.e("xposed-Glympse", "Stack trace:\n" + Log.getStackTraceString(new Throwable()));

                            // 可以修改蓝牙数据
                            if (data != null) {
                                for (int i = 0; i < data.length; i++) {
                                    data[i] = (byte)(data[i] + 1); // 举例，逐字节加 1
                                }
                                param.args[0] = data;
                                Log.e("xposed-Glympse", "Modified BT data: " + Arrays.toString(data));
                            }
                        }
                    });
            Log.e("xposed-Glympse", "Hook BluetoothGattCharacteristic.setValue SUCCESS");
        } catch (Throwable t) {
            Log.e("xposed-Glympse", "Hook BluetoothGattCharacteristic FAILED: " + Log.getStackTraceString(t));
        }


        // 5. Hook GlympseManager.sendLocation(GLocation)
        try {
            Log.e("xposed-Glympse", "hooking location...");
            Class<?> gLocationClass = lpparam.classLoader.loadClass("com.glympse.android.core.GLocation");
            Class<?> gManagerClass = lpparam.classLoader.loadClass("com.glympse.android.core.GlympseManager");

            XposedHelpers.findAndHookMethod(gManagerClass,
                    "sendLocation",
                    gLocationClass,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            Log.e("xposed-Glympse", "hooked sendLocation");
                        }
                    });
            Log.e("xposed-Glympse", "Hook GlympseManager.sendLocation SUCCESS");
        } catch (Throwable t) {
            Log.e("xposed-Glympse", "Hook GlympseManager.sendLocation FAILED: " + Log.getStackTraceString(t));
        }

        try {
            XposedHelpers.findAndHookMethod("android.bluetooth.BluetoothGatt",
                    lpparam.classLoader,
                    "writeCharacteristic",
                    android.bluetooth.BluetoothGattCharacteristic.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            BluetoothGattCharacteristic charac = (BluetoothGattCharacteristic) param.args[0];
                            byte[] value = charac.getValue();
                            Log.e("xposed-BLE", "writeCharacteristic(): " + Arrays.toString(value));

                            // 可选：修改内容
                            if (value != null) {
                                for (int i = 0; i < value.length; i++) {
                                    value[i] = (byte)(value[i] ^ 0xFF); // 举例，全部取反
                                }
                                charac.setValue(value);
                                Log.e("xposed-BLE", "Modified value: " + Arrays.toString(value));
                            }
                        }
                    });
            Log.e("xposed-Glympse", "Hook writeCharacteristic SUCCESS");
        } catch (Throwable t) {
            Log.e("xposed-Glympse", "Hook writeCharacteristic FAILED: " + Log.getStackTraceString(t));
        }

    }



    private void handleJapanB(final XC_LoadPackage.LoadPackageParam lpparam) {
        String methodProtos[] = {
                "okhttp3/t;->a(Ljava/lang/String;)",
                "okhttp3/t;->a(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)",
                "okhttp3/t;->a(Ljava/lang/String;IIZ)",
                "okhttp3/t;->a(Ljava/lang/String;Ljava/lang/String;ZZZZ)",
                "okhttp3/t;->a(Ljava/lang/String;Ljava/lang/String;ZZZZLjava/nio/charset/Charset;)",
                "okhttp3/t;->a(Ljava/lang/String;Z)",
                "okhttp3/t;->a(Ljava/util/List;Z)",
                "okhttp3/t;->a(Lb/c;Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)",
                "okhttp3/t;->a(Lb/c;Ljava/lang/String;IIZ)",
                "okhttp3/t;->a(Ljava/lang/StringBuilder;Ljava/util/List;)",
                "okhttp3/t;->a(Ljava/lang/String;II)",
                "okhttp3/t;->b(Ljava/lang/String;)",
                "okhttp3/t;->b(Ljava/lang/StringBuilder;Ljava/util/List;)",
                "okhttp3/t;->e(Ljava/lang/String;)",
                "okhttp3/t;->f(Ljava/lang/String;)",
                "okhttp3/t;->a()",
                "okhttp3/t;->b()",
                "okhttp3/t;->c(Ljava/lang/String;)",
                "okhttp3/t;->c()",
                "okhttp3/t;->d()",
                "okhttp3/t;->d(Ljava/lang/String;)",
                "okhttp3/t;->e()",
                "okhttp3/t;->equals(Ljava/lang/Object;)",
                "okhttp3/t;->f()",
                "okhttp3/t;->g()",
                "okhttp3/t;->h()",
                "okhttp3/t;->hashCode()",
                "okhttp3/t;->i()",
                "okhttp3/t;->j()",
                "okhttp3/t;->k()",
                "okhttp3/t;->l()",
                "okhttp3/t;->m()",
                "okhttp3/t;->n()",
                "okhttp3/t;->o()",
                "okhttp3/t;->toString()",

                "okhttp3/aa$a;->a(Ljava/lang/Class;Ljava/lang/Object;)",
                "okhttp3/aa$a;->a(Ljava/lang/Object;)",
                "okhttp3/aa$a;->a(Ljava/lang/String;)",
                "okhttp3/aa$a;->a(Ljava/lang/String;Ljava/lang/String;)",
                "okhttp3/aa$a;->a(Ljava/lang/String;Lokhttp3/ab;)",
                "okhttp3/aa$a;->a(Lokhttp3/ab;)",
                "okhttp3/aa$a;->a(Lokhttp3/s;)",
                "okhttp3/aa$a;->a(Lokhttp3/t;)",
                "okhttp3/aa$a;->a()",
                "okhttp3/aa$a;->b(Ljava/lang/String;)",
                "okhttp3/aa$a;->b(Ljava/lang/String;Ljava/lang/String;)",

                "okhttp3/aa;->a(Ljava/lang/String;)",
                "okhttp3/aa;->a()",
                "okhttp3/aa;->b()",
                "okhttp3/aa;->c()",
                "okhttp3/aa;->d()",
                "okhttp3/aa;->e()",
                "okhttp3/aa;->f()",
                "okhttp3/aa;->g()",
                "okhttp3/aa;->toString()",

                "okhttp3/s;->a([Ljava/lang/String;Ljava/lang/String;)",
                "okhttp3/s;->a(Ljava/util/Map;)",
                "okhttp3/s;->a([Ljava/lang/String;)",
                "okhttp3/s;->a()",
                "okhttp3/s;->a(I)",
                "okhttp3/s;->a(Ljava/lang/String;)",
                "okhttp3/s;->b(I)",
                "okhttp3/s;->b(Ljava/lang/String;)",
                "okhttp3/s;->b()",
                "okhttp3/s;->equals(Ljava/lang/Object;)",
                "okhttp3/s;->hashCode()",
                "okhttp3/s;->toString()",

                "jp/co/japantaxi/brooklyn/repository/api/c/d/b$a;->a(Ljp/co/japantaxi/brooklyn/repository/api/c/d/b$a;)",
                "jp/co/japantaxi/brooklyn/repository/api/c/d/b$a;->b(Ljp/co/japantaxi/brooklyn/repository/api/c/d/b$a;)",
                "jp/co/japantaxi/brooklyn/repository/api/c/d/b$a;->c(Ljp/co/japantaxi/brooklyn/repository/api/c/d/b$a;)",
                "jp/co/japantaxi/brooklyn/repository/api/c/d/b$a;->d(Ljp/co/japantaxi/brooklyn/repository/api/c/d/b$a;)",
                "jp/co/japantaxi/brooklyn/repository/api/c/d/b$a;->a(Ljava/lang/String;)",
                "jp/co/japantaxi/brooklyn/repository/api/c/d/b$a;->a()",
                "jp/co/japantaxi/brooklyn/repository/api/c/d/b$a;->b(Ljava/lang/String;)",
                "jp/co/japantaxi/brooklyn/repository/api/c/d/b$a;->c(Ljava/lang/String;)",
                "jp/co/japantaxi/brooklyn/repository/api/c/d/b$a;->d(Ljava/lang/String;)",

                "jp/co/japantaxi/brooklyn/repository/api/c/d/c;->d()",
                "jp/co/japantaxi/brooklyn/repository/api/c/d/c;->toString()",

                "jp/co/japantaxi/brooklyn/repository/api/c/d/a;->a(Ljp/co/japantaxi/brooklyn/repository/api/c/d/b;)",
                "jp/co/japantaxi/brooklyn/repository/api/c/d/a;->b(Ljp/co/japantaxi/brooklyn/repository/api/c/d/b;)",

                "jp/co/japantaxi/brooklyn/repository/api/c/a;-><init>()",
                "jp/co/japantaxi/brooklyn/repository/api/c/a;->a(Ljava/lang/String;)",
                "jp/co/japantaxi/brooklyn/repository/api/c/a;->a(Ljava/lang/Throwable;)",
                "jp/co/japantaxi/brooklyn/repository/api/c/a;->a()",
                "jp/co/japantaxi/brooklyn/repository/api/c/a;->b()",
                "jp/co/japantaxi/brooklyn/repository/api/c/a;->c()",
                "jp/co/japantaxi/brooklyn/repository/api/c/a;->toString()",


        };

        // System.out.println("class name is " + className);
        System.out.println("xposed-japan-itrace-conf" + " ...entering handleJapanB..................");
        Log.e("xposed-12306-itrace", "...entering handleJapanB..................");

        for (String mproto: methodProtos) {
            System.out.println("xposed-japan-itrace........... to work on: " + mproto);
            findAndHook(lpparam, mproto);
        }

    }
    /**
     * to handle 12306 railway ticket app
     *
     */
    private void handle12306B(final XC_LoadPackage.LoadPackageParam lpparam) {

        String methodProtos[] = {"com/alipay/mobile/common/rpc/RpcInvoker;->setScene(Ljava/lang/String;)V",
                "com/alipay/mobile/common/rpc/RpcInvoker;->printAllTimeLog(Ljava/lang/reflect/Method;Ljava/lang/String;J)V",
                "com/alipay/mobile/common/rpc/RpcInvoker;->invoke(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lcom/alipay/mobile/common/rpc/transport/InnerRpcInvokeContext;)Ljava/lang/Object"
        };

        String methodProtos2[] = {"com/alipay/mobile/common/rpc/protocol/json/JsonDeserializer;->logResult(Ljava/lang/String;)",
                "com/alipay/mobile/common/rpc/protocol/json/JsonDeserializer;->parser()",
                "com/alipay/mobile/common/rpc/protocol/json/JsonDeserializerV2;->logResult(Ljava/lang/String;)",
                "com/alipay/mobile/common/rpc/protocol/json/JsonDeserializerV2;->parser()",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializer;->buildNameValuePairs(Ljava/util/List;)",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializer;->buildReqDataNVPair()",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializer;->getId()",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializer;->getOperationType()",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializer;->getRequestDataDigest()",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializer;->getRequestDataJson()",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializer;->nvpairs2Bytes(Ljava/util/List;)",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializer;->packet()",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializer;->postPacket(Ljava/util/List;)",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializer;->prePacket(Ljava/util/List;)",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializer;->setExtParam(Ljava/lang/Object;)",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializer;->setId(I)",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializerV2;->getRequestDataDigest()",
                "com/alipay/mobile/common/rpc/protocol/json/JsonSerializerV2;->packet()",
                "com/alipay/mobile/common/rpc/protocol/json/SignJsonSerializer;->buildSignNameValuePairs(Ljava/util/List;)",
                "com/alipay/mobile/common/rpc/protocol/json/SignJsonSerializer;->sortNVPairList(Ljava/util/List;)",
                "com/alipay/mobile/common/rpc/protocol/json/SignJsonSerializer;->getRequestDataDigest()",
                "com/alipay/mobile/common/rpc/protocol/json/SignJsonSerializer;->getSignData()",
                "com/alipay/mobile/common/rpc/protocol/json/SignJsonSerializer;->getSignTimestamp()",
                "com/alipay/mobile/common/rpc/protocol/json/SignJsonSerializer;->packet()",
                "com/alipay/mobile/common/rpc/protocol/json/SignJsonSerializer;->setExtParam(Ljava/lang/Object;)",
                "com/alipay/mobile/common/rpc/protocol/json/SimpleRpcJsonSerializer;->getRequestDataJson()",
                "com/alipay/mobile/common/rpc/protocol/json/SimpleRpcJsonSerializerV2;->getRequestDataJson()"
        };


        // System.out.println("class name is " + className);
        System.out.println("xposed-12306-itrace" + " ...entering handle12306B..................");
        Log.e("xposed-12306-itrace", "...entering handle12306B..................");

        for (String mproto: methodProtos2) {
            System.out.println("xposed-12306-itrace........... to work on: " + mproto);
            findAndHook(lpparam, mproto);
        }

        System.out.println("xposed-12306-itrace.............\n......to work on: " + methodProtos[0]);
        findAndHook(lpparam, methodProtos[0]);

        System.out.println("xposed-12306-itrace.............\n......to work on: " + methodProtos[1]);
        findAndHook(lpparam, methodProtos[1]);

        System.out.println("xposed-12306-itrace.............\n......to work on: " + methodProtos[2]);
        findAndHook(lpparam, methodProtos[2]);
    }

    /**
     * to handle 12306 railway ticket app
     **/
    private void handle12306(final XC_LoadPackage.LoadPackageParam lpparam) {

        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",
                lpparam.classLoader, "getPackageInfo", String.class, int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 2, 93, 48, -126, 1, -58, -96, 3, 2, 1, 2, 2, 4, 76, 3, 39, 40, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 114, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 17, 48, 15, 6, 3, 85, 4, 10, 19, 8, 97, 117, 116, 111, 110, 97, 118, 105, 49, 26, 48, 24, 6, 3, 85, 4, 11, 19, 17, 109, 111, 98, 105, 108, 101, 32, 100, 101, 112, 97, 114, 116, 109, 101, 110, 116, 49, 16, 48, 14, 6, 3, 85, 4, 3, 19, 7, 109, 105, 110, 105, 109, 97, 112, 48, 32, 23, 13, 49, 48, 48, 53, 51, 49, 48, 51, 48, 52, 48, 56, 90, 24, 15, 50, 48, 54, 53, 48, 51, 48, 51, 48, 51, 48, 52, 48, 56, 90, 48, 114, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 17, 48, 15, 6, 3, 85, 4, 10, 19, 8, 97, 117, 116, 111, 110, 97, 118, 105, 49, 26, 48, 24, 6, 3, 85, 4, 11, 19, 17, 109, 111, 98, 105, 108, 101, 32, 100, 101, 112, 97, 114, 116, 109, 101, 110, 116, 49, 16, 48, 14, 6, 3, 85, 4, 3, 19, 7, 109, 105, 110, 105, 109, 97, 112, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -84, 36, 92, -102, -12, -70, -45, 46, -48, 7, -25, -70, 94, -93, 92, 3, -30, 110, -98, 49, 62, 64, -89, 111, 62, 87, -97, -88, -26, 18, -62, -118, 99, -23, 7, -122, -78, -34, -100, -61, 114, -50, -121, -59, 94, 80, -30, -11, -26, -20, 70, 51, 102, -32, -120, 119, 60, -92, -115, -9, -43, 105, -16, 37, 92, -124, 73, 118, -45, 112, 10, -83, -65, 7, 35, 6, 66, 59, -13, 35, 103, -16, 126, -75, 37, 10, -112, -70, 11, -43, 109, 122, -22, 24, 80, 54, -75, 24, 9, 6, -118, -41, 51, -5, 44, 28, 44, -17, 15, -105, -112, 9, -42, -115, -25, 62, -95, 0, -26, -51, -128, 2, -2, -86, 2, 103, -76, -105, 2, 3, 1, 0, 1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, -91, 32, 102, -64, -19, -5, -55, -18, 90, 95, -12, -54, -1, 57, -99, -79, 26, 116, 27, 49, 84, 45, 110, 105, -53, -49, -17, 3, 89, 118, 120, -94, 84, -76, 16, 42, 60, 66, -5, -30, -112, 58, -12, 50, -10, -8, -3, -36, -83, -121, 4, -2, 46, -107, 44, 57, -75, -69, -6, -56, -110, 1, -97, 50, -58, 123, -37, -48, -127, -12, 12, 93, 99, 68, 55, -15, -26, -21, -30, 125, 118, 124, 98, 27, -107, 82, 76, -128, 123, 13, 19, 24, 81, -113, 114, 28, 70, 16, 59, -125, 28, -117, -68, -17, 27, 113, -110, -58, -42, -50, -66, 28, -125, -58, -11, -86, 4, 106, -46, -115, -68, 111, 1, 56, 90, -112, 96, 28};
                        // {48, -126, 3, -99, 48, -126, 2, -123, -96, 3, 2, 1, 2, 2, 4, 88, 3, -68, -45, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 126, 49, 40, 48, 38, 6, 3, 85, 4, 10, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 11, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 3, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 48, 32, 23, 13, 49, 51, 48, 53, 48, 56, 48, 56, 50, 52, 50, 49, 90, 24, 15, 51, 48, 49, 50, 48, 57, 48, 56, 48, 56, 50, 52, 50, 49, 90, 48, 126, 49, 40, 48, 38, 6, 3, 85, 4, 10, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 11, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 3, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -98, 12, -58, 101, -96, -8, 58, -118, 59, 107, 107, 37, 33, -6, -21, 20, 34, -88, -27, 71, -112, 79, -51, 103, -94, -6, -107, -117, -57, 101, 65, -119, 22, 66, 93, 111, -106, 30, 31, -118, 20, -30, 116, 110, -126, -54, -106, -81, 64, -61, 106, 117, 101, -79, 127, 108, -90, 95, -108, -105, 12, 35, 123, -51, -72, 89, -100, -42, -93, -32, 119, 59, 33, -5, -3, 10, 19, -8, 4, -22, -12, -62, 37, -26, 122, -122, 52, 11, -97, 16, 111, -115, -68, -47, 100, 74, -44, 119, -7, 40, -122, 40, 33, 79, 55, 92, 40, 112, 7, 114, -87, 13, 12, -29, 83, 88, -113, -73, 71, -4, 80, -121, 124, -115, 65, 118, -30, -77, -52, -97, 110, -61, 98, -55, -97, 17, 98, -1, -68, 87, 46, 122, 14, 104, -15, -105, 64, -106, -22, 115, -91, 86, 91, -10, 85, 101, 52, 20, -112, 31, -81, -46, 78, -16, 9, -99, -85, -112, 114, -126, -33, -63, -101, -3, -85, -123, 109, 65, 117, -41, 81, -109, 55, 114, -86, 12, -7, 73, 96, 72, -93, 36, -62, -80, -65, 104, 120, 118, 18, -116, -56, 76, 16, 32, -63, 45, 37, 49, -78, -48, 18, -60, -68, -61, 104, 8, 18, -125, -77, -30, 56, -21, 91, 83, 88, 13, 52, 16, -116, 75, 68, 79, -45, 47, 52, -97, 108, -16, -74, -20, 96, 26, 49, -70, 45, 34, -108, 113, -124, 43, 26, -86, -116, 91, -70, 1, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 89, -57, 94, -56, -46, -52, -55, -63, 85, -49, 90, 3, -110, -67, -7, -20, -35, -18, -65, 71, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 69, -102, -118, -29, 31, 83, -43, 107, 19, 115, 109, 68, 54, 115, 59, 99, 11, 2, 61, 40, 117, 71, 98, 8, 110, 58, 78, 39, -41, -92, -82, 37, 89, -79, 6, -43, 17, 50, 3, -88, -3, -76, 104, -97, 69, -16, -89, 99, -22, 125, 77, -125, 120, 68, -110, 126, 44, 28, -94, 42, 61, 86, -46, 54, -55, -127, -98, 104, 20, -81, -126, 1, 113, 2, -44, 103, -60, -53, 85, -47, -79, -103, -95, 90, -108, -42, 52, -125, 76, 21, 44, 56, -98, 110, 85, 90, 40, 67, -116, 114, -3, -63, 111, -76, 117, -48, 69, 33, 63, -69, 56, -125, -37, -12, 71, 45, -28, 80, -104, -42, -106, 110, 16, 66, 71, 116, -81, 115, 19, -22, 115, -87, -4, 39, -55, -56, -85, -127, -22, 33, 84, 40, -95, -26, 27, 87, -97, 43, -109, 71, -81, 21, 39, -98, -62, 89, -78, 88, 34, -36, 43, -85, -116, -71, 113, 32, 88, 6, -4, 100, -21, -87, -2, 91, -73, -67, -5, 122, -31, -96, -73, -108, 20, 34, -79, 111, -127, -112, 57, 9, 80, 70, -53, 125, -86, -53, 72, 109, 124, -45, -3, 33, 56, 44, -57, 58, -118, 103, -41, 36, 85, 119, 52, 5, 60, 85, -109, -58, 109, 52, 49, -23, 123, -101, -53, -72, -43, -50, 2, 31, -108, 116, -48, 99, -95, 86, -124, -49, -21, -3, 107, -59, 124, -55, 37, 67, -16, -109, -9, 107, -100, 60, 27, 117, -19, 64};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 2, 55, 48, -126, 1, -96, -96, 3, 2, 1, 2, 2, 4, 82, 12, -105, 20, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 95, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 48, 49, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 12, 48, 10, 6, 3, 85, 4, 10, 19, 3, 122, 116, 99, 49, 14, 48, 12, 6, 3, 85, 4, 11, 19, 5, 114, 97, 105, 108, 115, 49, 14, 48, 12, 6, 3, 85, 4, 3, 19, 5, 49, 50, 51, 48, 54, 48, 32, 23, 13, 49, 51, 48, 56, 49, 53, 48, 56, 53, 51, 52, 48, 90, 24, 15, 50, 49, 49, 51, 48, 55, 50, 50, 48, 56, 53, 51, 52, 48, 90, 48, 95, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 48, 49, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 12, 48, 10, 6, 3, 85, 4, 10, 19, 3, 122, 116, 99, 49, 14, 48, 12, 6, 3, 85, 4, 11, 19, 5, 114, 97, 105, 108, 115, 49, 14, 48, 12, 6, 3, 85, 4, 3, 19, 5, 49, 50, 51, 48, 54, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -97, -22, -99, 86, 39, 127, -62, 124, 104, -93, -125, 97, 115, -46, -122, 121, 26, -14, -66, 56, -25, 56, 74, -4, -29, 47, 56, -79, 100, -40, 58, 108, 110, -57, 101, 111, 120, -127, -60, 68, -62, -26, 119, -30, 25, 84, 21, -87, 43, -74, -96, 102, 56, -120, 109, 19, 45, 38, -50, 71, -119, 95, -87, 96, 118, 8, 88, 19, -18, 123, 38, 77, 96, 23, -78, 26, 100, -57, 90, -28, -70, 99, 73, 105, 6, -2, 119, -3, -90, -125, 5, -40, -18, 66, 110, -50, 6, -31, -74, -125, -65, 120, -20, -50, -33, -117, -51, -104, 23, 55, 109, 38, -59, 15, -5, 116, 95, 55, -118, 80, -125, 79, -42, 82, 45, -77, -90, 21, 2, 3, 1, 0, 1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, 62, 100, 109, 29, -22, 87, 99, -15, 32, 8, -45, 96, 35, -96, -127, 43, -60, 69, 43, 21, -45, -8, -53, -15, -119, -30, -10, -76, 59, -119, -93, 115, -28, -52, 78, -57, 25, 127, 49, -23, -57, 101, -126, 29, 108, -124, -103, -51, 10, 113, -28, -97, -84, 17, 75, 11, -112, -65, 45, -72, -9, 82, 13, 90, -71, 34, -64, 75, 96, 47, 126, -127, -51, 127, 77, -53, -98, -108, 17, -122, -111, -65, 45, -42, 39, 123, -60, 4, -67, -4, 105, 6, -6, -78, 20, 92, 52, 38, -96, 98, 74, 84, -100, -40, 94, -125, -2, 72, 34, -26, -122, -85, -60, 17, -97, 33, -37, -35, -72, -53, 113, -59, -21, -37, 95, 4, 38, -120};
                        // {48, -126, 2, 93, 48, -126, 1, -58, -96, 3, 2, 1, 2, 2, 4, 76, 3, 39, 40, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 114, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 17, 48, 15, 6, 3, 85, 4, 10, 19, 8, 97, 117, 116, 111, 110, 97, 118, 105, 49, 26, 48, 24, 6, 3, 85, 4, 11, 19, 17, 109, 111, 98, 105, 108, 101, 32, 100, 101, 112, 97, 114, 116, 109, 101, 110, 116, 49, 16, 48, 14, 6, 3, 85, 4, 3, 19, 7, 109, 105, 110, 105, 109, 97, 112, 48, 32, 23, 13, 49, 48, 48, 53, 51, 49, 48, 51, 48, 52, 48, 56, 90, 24, 15, 50, 48, 54, 53, 48, 51, 48, 51, 48, 51, 48, 52, 48, 56, 90, 48, 114, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 17, 48, 15, 6, 3, 85, 4, 10, 19, 8, 97, 117, 116, 111, 110, 97, 118, 105, 49, 26, 48, 24, 6, 3, 85, 4, 11, 19, 17, 109, 111, 98, 105, 108, 101, 32, 100, 101, 112, 97, 114, 116, 109, 101, 110, 116, 49, 16, 48, 14, 6, 3, 85, 4, 3, 19, 7, 109, 105, 110, 105, 109, 97, 112, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -84, 36, 92, -102, -12, -70, -45, 46, -48, 7, -25, -70, 94, -93, 92, 3, -30, 110, -98, 49, 62, 64, -89, 111, 62, 87, -97, -88, -26, 18, -62, -118, 99, -23, 7, -122, -78, -34, -100, -61, 114, -50, -121, -59, 94, 80, -30, -11, -26, -20, 70, 51, 102, -32, -120, 119, 60, -92, -115, -9, -43, 105, -16, 37, 92, -124, 73, 118, -45, 112, 10, -83, -65, 7, 35, 6, 66, 59, -13, 35, 103, -16, 126, -75, 37, 10, -112, -70, 11, -43, 109, 122, -22, 24, 80, 54, -75, 24, 9, 6, -118, -41, 51, -5, 44, 28, 44, -17, 15, -105, -112, 9, -42, -115, -25, 62, -95, 0, -26, -51, -128, 2, -2, -86, 2, 103, -76, -105, 2, 3, 1, 0, 1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, -91, 32, 102, -64, -19, -5, -55, -18, 90, 95, -12, -54, -1, 57, -99, -79, 26, 116, 27, 49, 84, 45, 110, 105, -53, -49, -17, 3, 89, 118, 120, -94, 84, -76, 16, 42, 60, 66, -5, -30, -112, 58, -12, 50, -10, -8, -3, -36, -83, -121, 4, -2, 46, -107, 44, 57, -75, -69, -6, -56, -110, 1, -97, 50, -58, 123, -37, -48, -127, -12, 12, 93, 99, 68, 55, -15, -26, -21, -30, 125, 118, 124, 98, 27, -107, 82, 76, -128, 123, 13, 19, 24, 81, -113, 114, 28, 70, 16, 59, -125, 28, -117, -68, -17, 27, 113, -110, -58, -42, -50, -66, 28, -125, -58, -11, -86, 4, 106, -46, -115, -68, 111, 1, 56, 90, -112, 96, 28};
                        // {48, -126, 3, -99, 48, -126, 2, -123, -96, 3, 2, 1, 2, 2, 4, 88, 3, -68, -45, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 126, 49, 40, 48, 38, 6, 3, 85, 4, 10, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 11, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 3, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 48, 32, 23, 13, 49, 51, 48, 53, 48, 56, 48, 56, 50, 52, 50, 49, 90, 24, 15, 51, 48, 49, 50, 48, 57, 48, 56, 48, 56, 50, 52, 50, 49, 90, 48, 126, 49, 40, 48, 38, 6, 3, 85, 4, 10, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 11, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 3, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -98, 12, -58, 101, -96, -8, 58, -118, 59, 107, 107, 37, 33, -6, -21, 20, 34, -88, -27, 71, -112, 79, -51, 103, -94, -6, -107, -117, -57, 101, 65, -119, 22, 66, 93, 111, -106, 30, 31, -118, 20, -30, 116, 110, -126, -54, -106, -81, 64, -61, 106, 117, 101, -79, 127, 108, -90, 95, -108, -105, 12, 35, 123, -51, -72, 89, -100, -42, -93, -32, 119, 59, 33, -5, -3, 10, 19, -8, 4, -22, -12, -62, 37, -26, 122, -122, 52, 11, -97, 16, 111, -115, -68, -47, 100, 74, -44, 119, -7, 40, -122, 40, 33, 79, 55, 92, 40, 112, 7, 114, -87, 13, 12, -29, 83, 88, -113, -73, 71, -4, 80, -121, 124, -115, 65, 118, -30, -77, -52, -97, 110, -61, 98, -55, -97, 17, 98, -1, -68, 87, 46, 122, 14, 104, -15, -105, 64, -106, -22, 115, -91, 86, 91, -10, 85, 101, 52, 20, -112, 31, -81, -46, 78, -16, 9, -99, -85, -112, 114, -126, -33, -63, -101, -3, -85, -123, 109, 65, 117, -41, 81, -109, 55, 114, -86, 12, -7, 73, 96, 72, -93, 36, -62, -80, -65, 104, 120, 118, 18, -116, -56, 76, 16, 32, -63, 45, 37, 49, -78, -48, 18, -60, -68, -61, 104, 8, 18, -125, -77, -30, 56, -21, 91, 83, 88, 13, 52, 16, -116, 75, 68, 79, -45, 47, 52, -97, 108, -16, -74, -20, 96, 26, 49, -70, 45, 34, -108, 113, -124, 43, 26, -86, -116, 91, -70, 1, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 89, -57, 94, -56, -46, -52, -55, -63, 85, -49, 90, 3, -110, -67, -7, -20, -35, -18, -65, 71, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 69, -102, -118, -29, 31, 83, -43, 107, 19, 115, 109, 68, 54, 115, 59, 99, 11, 2, 61, 40, 117, 71, 98, 8, 110, 58, 78, 39, -41, -92, -82, 37, 89, -79, 6, -43, 17, 50, 3, -88, -3, -76, 104, -97, 69, -16, -89, 99, -22, 125, 77, -125, 120, 68, -110, 126, 44, 28, -94, 42, 61, 86, -46, 54, -55, -127, -98, 104, 20, -81, -126, 1, 113, 2, -44, 103, -60, -53, 85, -47, -79, -103, -95, 90, -108, -42, 52, -125, 76, 21, 44, 56, -98, 110, 85, 90, 40, 67, -116, 114, -3, -63, 111, -76, 117, -48, 69, 33, 63, -69, 56, -125, -37, -12, 71, 45, -28, 80, -104, -42, -106, 110, 16, 66, 71, 116, -81, 115, 19, -22, 115, -87, -4, 39, -55, -56, -85, -127, -22, 33, 84, 40, -95, -26, 27, 87, -97, 43, -109, 71, -81, 21, 39, -98, -62, 89, -78, 88, 34, -36, 43, -85, -116, -71, 113, 32, 88, 6, -4, 100, -21, -87, -2, 91, -73, -67, -5, 122, -31, -96, -73, -108, 20, 34, -79, 111, -127, -112, 57, 9, 80, 70, -53, 125, -86, -53, 72, 109, 124, -45, -3, 33, 56, 44, -57, 58, -118, 103, -41, 36, 85, 119, 52, 5, 60, 85, -109, -58, 109, 52, 49, -23, 123, -101, -53, -72, -43, -50, 2, 31, -108, 116, -48, 99, -95, 86, -124, -49, -21, -3, 107, -59, 124, -55, 37, 67, -16, -109, -9, 107, -100, 60, 27, 117, -19, 64};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                        byte[] oldCert = ((PackageInfo) param.getResult()).signatures[0].toByteArray();
                        Log.e("xposed-12306", Arrays.toString(oldCert));
                        Log.e("xposed-12306", "...setting cert to " + Arrays.toString(cert));
                    }
                });

        XposedHelpers.findAndHookMethod("cn.com.bsfit.dfp.android.client.a.a",
              lpparam.classLoader, "a", "android.content.Context", String.class, String.class, int.class, new XC_MethodHook() {
                  @Override
                  protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                      super.beforeHookedMethod(param);
                      String key1 = (String) param.args[1];
                      String val1 = (String) param.args[2];
                      Log.e("xposed-12306", " to set key: " + key1 + " to val: " + val1);
                      Throwable e = new Throwable();
                      e.printStackTrace();
                  }

                  @Override
                  protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                      super.afterHookedMethod(param);
                  }
                });

        // TO intercept ...... calls

//        XposedHelpers.findAndHookMethod("com.alipay.mobile.common.transport.http.HttpUrlRequest",
//                lpparam.classLoader, "HttpUrlRequest", String.class, new XC_MethodHook() {
        XposedHelpers.findAndHookConstructor("com.alipay.mobile.common.transport.http.HttpUrlRequest",
                lpparam.classLoader, String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        String url = (String) param.args[0];
                        Log.e("xposed-12306", " initialize HttpUrlRequest with " + url);
                        Throwable e = new Throwable();
                        e.printStackTrace();
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("cn.com.bsfit.dfp.android.client.feature.FeatureCollection",
                lpparam.classLoader, "b", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Log.e("xposed-12306", "..." +
                                " FeatureCollection()...");
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        // PackageInfo packageInfo = (PackageInfo) param.getResult();
                        Map<String, String> hashMap = (Map<String, String>) param.getResult();
                        Log.e("xposed-12306-features", Arrays.toString(hashMap.entrySet().toArray()));
                    }
                });

        XposedHelpers.findAndHookMethod("com.alipay.mobile.common.mpaas_crypto.Client",
                lpparam.classLoader, "encode", "byte[]", "byte[]", int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Log.e("xposed-12306", "... encoding ");
                        byte[] bArr1 = (byte[]) param.args[0];
                        byte[] bArr2 = (byte[]) param.args[1];
                        Integer cfgParam = (Integer) param.args[2];
                        Log.e("Xposed-12306/mpass", "encode param1" + Arrays.toString(bArr1));
                        Log.e("Xposed-12306/mpass", "encode param2" + Arrays.toString(bArr2));
                        Log.e("Xposed-12306/mpass", "encode param3" + cfgParam.toString());
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        // PackageInfo packageInfo = (PackageInfo) param.getResult();
                        // Map<String, String> hashMap = (Map<String, String>) param.getResult();
                        Log.e("Xposed-12306/mpass", "... encoding finished.");
                        Object res = param.getResult();
                        byte[][] res1 = (byte[][]) res;
                        for (byte[] result: res1) {
                            Log.e("Xposed-12306/mpass", "...encode returns : " + Arrays.toString(result));
                        }
                    }
                });

        XposedHelpers.findAndHookMethod("com.alipay.mobile.common.transport.http.selfencrypt.ClientRpcPack",
                lpparam.classLoader, "encrypt", "byte[]", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Log.e("xposed-12306", "... encrypting... ");
                        byte[] bArr1 = (byte[]) param.args[0];
                        Log.e("Xposed-12306/mpass", "encrypt param1" + Arrays.toString(bArr1));
                        Throwable e = new Throwable();
                        e.printStackTrace();

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        // PackageInfo packageInfo = (PackageInfo) param.getResult();
                        // Map<String, String> hashMap = (Map<String, String>) param.getResult();
                        Log.e("Xposed-12306/mpass", "... encrypting finished.");
                        Object res = param.getResult();
                        byte[] res1 = (byte[]) res;
                        // for (byte[] result: res1) {
                            Log.e("Xposed-12306/mpass", "...encrypt returns : " + Arrays.toString(res1));
                        // }
                    }
                });

        Log.e("xposed-12306", "...trying to hook getDexClassLoader");

        XposedHelpers.findAndHookMethod("com.alipay.mobile.common.mpaas_crypto.Client",
                lpparam.classLoader, "decode", "byte[]", "byte[]", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Log.e("xposed-12306", "... decoding start");
                        byte[] bArr1 = (byte[]) param.args[0];
                        byte[] bArr2 = (byte[]) param.args[1];
                        Log.e("Xposed-12306/mpass", "decode param1" + Arrays.toString(bArr1));
                        Log.e("Xposed-12306/mpass", "decode param2" + Arrays.toString(bArr2));
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        // PackageInfo packageInfo = (PackageInfo) param.getResult();
                        // Map<String, String> hashMap = (Map<String, String>) param.getResult();
                        Log.e("xposed-12306", "... decoding finished.");
                        Object res = param.getResult();
                        byte[] res1 = (byte[]) res;
                        int index = 0;
                        while (index <= res1.length) {
                            byte[] subarr = Arrays.copyOfRange(res1, index, index+100);
                            index += 100;
                            Log.e("Xposed-12306/mpass", "...decode returns : " + Arrays.toString(subarr));
                        }
                        // Log.e("Xposed-12306/mpass", "...decode returns : " + Arrays.toString(res1));
                    }
                });

/*        XposedHelpers.findAndHookMethod("com.alibaba.wireless.security.framework.IRouterComponent",
                lpparam.classLoader, "doCommand", int.class, Object[].class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Log.e("xposed-12306", "... doCommand...");
                        int cmdno = (Integer) param.args[0];
                        Log.e("Xposed-12306/mpass", "deCommand param1" + Integer.toString(cmdno));
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        // PackageInfo packageInfo = (PackageInfo) param.getResult();
                        // Map<String, String> hashMap = (Map<String, String>) param.getResult();
                        Log.e("xposed-12306", "... doCommand finished.");
                        Object res = param.getResult();
                        byte[] res1 = (byte[]) res;
                        Log.e("Xposed-12306/mpass", "...decode returns : " + Arrays.toString(res1));
                    }
                });

        Log.e("xposed-12306", "...trying to hook getDexClassLoader");
*/

        XposedHelpers.findAndHookMethod("com.alibaba.wireless.security.framework.c",
                lpparam.classLoader, "b", String.class, String.class, boolean.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Log.e("xposed-12306", "... getDexClassLoader...");
                        String dexPath = (String) param.args[0];
                        String optDir = (String) param.args[1];
                        Log.e("xposed-12306/NEW-plugin", "getDexClassLoader param1" + dexPath);
                        Log.e("xposed-12306/NEW-plugin", "getDexClassLoader param2" + optDir);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        // PackageInfo packageInfo = (PackageInfo) param.getResult();
                        // Map<String, String> hashMap = (Map<String, String>) param.getResult();
                        Log.e("xposed-12306/NEW-plugin", "... getDexClassLoader finished.");
                        Object res = param.getResult();
                        DexClassLoader clzLoader = (DexClassLoader) res;
                        Log.e("xposed-12306/NEW-plugin", "...getDexClassLoader returns : " + clzLoader.toString());

                        // At this point, we can hook the functions inside the loaded module...

                        XposedHelpers.findAndHookMethod("com.alibaba.wireless.security.mainplugin.a",
                                clzLoader, "doCommand", int.class, Object[].class, new XC_MethodHook() {
                                    @Override
                                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                        super.beforeHookedMethod(param);

                                        Log.e("xposed-12306-dynLoader", "... doCommand...");
                                        Throwable e = new Throwable();
                                        e.printStackTrace();
                                        int cmdno = (Integer) param.args[0];
                                        Object[] objs = (Object[]) param.args[1];
                                        Log.e("xposed-12306/doCommand", "doCommand param1 - " + Integer.toString(cmdno));

                                        for (Object var: objs) {
                                            if (var instanceof String[]) {
                                                String[] strs = (String[]) var;
                                                for (String str: strs) {
                                                    Log.e("xposed-12306/doCommand", "param2 - " + str);
                                                }
                                            } else {
                                                Log.e("xposed-12306/doCommand", "param2 - " + var.toString());
                                            }
                                        }
                                    }

                                    @Override
                                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                        super.afterHookedMethod(param);
                                        // PackageInfo packageInfo = (PackageInfo) param.getResult();
                                        // Map<String, String> hashMap = (Map<String, String>) param.getResult();
                                        Log.e("xposed-12306-dynLoader", "... doCommand finished.");
                                        Object res = param.getResult();
                                        if (res instanceof byte[]) {
                                            byte[] res1 = (byte[]) res;
                                            Log.e("Xposed-12306/mpass", "...doCommand returns : " + Arrays.toString(res1));
                                        }
                                        if (res instanceof String) {
                                            String res1 = (String) res;
                                            Log.e("Xposed-12306/mpass", "...doCommand returns : " + res1);
                                        }
                                    }
                                });


                    }
                });

        XposedHelpers.findAndHookMethod("com.alibaba.wireless.security.framework.c",
                lpparam.classLoader, "c", String.class, String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Log.e("xposed-12306", "... getDexClassLoader...");
                        String dexPath = (String) param.args[0];
                        String optDir = (String) param.args[1];
                        Log.e("xposed-12306/sgplugin", "getDexClassLoader param1" + dexPath);
                        Log.e("xposed-12306/sgplugin", "getDexClassLoader param2" + optDir);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        // PackageInfo packageInfo = (PackageInfo) param.getResult();
                        // Map<String, String> hashMap = (Map<String, String>) param.getResult();
                        Log.e("xposed-12306", "... getDexClassLoader finished.");
                        Object res = param.getResult();
                        DexClassLoader clzLoader = (DexClassLoader) res;
                        Log.e("Xposed-12306/mpass", "...getDexClassLoader returns : " + clzLoader.toString());

                        // At this point, we can hook the functions inside the loaded module...


                        XposedHelpers.findAndHookMethod("com.alibaba.wireless.security.mainplugin.a",
                                clzLoader, "doCommand", int.class, Object[].class, new XC_MethodHook() {
                                    @Override
                                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                        super.beforeHookedMethod(param);

                                        Log.e("xposed-12306-dynLoader", "... doCommand...");
                                        Throwable e = new Throwable();
                                        e.printStackTrace();
                                        int cmdno = (Integer) param.args[0];
                                        Object[] objs = (Object[]) param.args[1];
                                        Log.e("xposed-12306/doCommand", "doCommand param1 - " + Integer.toString(cmdno));

                                        for (Object var: objs) {
                                            if (var instanceof String[]) {
                                                String[] strs = (String[]) var;
                                                for (String str: strs) {
                                                    Log.e("xposed-12306/doCommand", "param2 - " + str);
                                                }
                                            } else {
                                                Log.e("xposed-12306/doCommand", "param2 - " + var.toString());
                                            }
                                        }
                                    }

                                    @Override
                                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                        super.afterHookedMethod(param);
                                        // PackageInfo packageInfo = (PackageInfo) param.getResult();
                                        // Map<String, String> hashMap = (Map<String, String>) param.getResult();
                                        Log.e("xposed-12306-dynLoader", "... doCommand finished.");
                                        Object res = param.getResult();
                                        if (res instanceof byte[]) {
                                            byte[] res1 = (byte[]) res;
                                            Log.e("Xposed-12306/mpass", "...doCommand returns : " + Arrays.toString(res1));
                                        }
                                        if (res instanceof String) {
                                            String res1 = (String) res;
                                            Log.e("Xposed-12306/mpass", "...doCommand returns : " + res1);
                                        }
                                    }
                                });


                    }
                });

        XposedHelpers.findAndHookMethod("com.alibaba.wireless.security.mainplugin.a",
                lpparam.classLoader, "doCommand", int.class, Object[].class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Log.e("xposed-12306", "... doCommand...");
                        int cmdno = (Integer) param.args[0];
                        Log.e("Xposed-12306/mpass", "doCommand param1" + Integer.toString(cmdno));
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        // PackageInfo packageInfo = (PackageInfo) param.getResult();
                        // Map<String, String> hashMap = (Map<String, String>) param.getResult();
                        Log.e("xposed-12306", "... doCommand finished.");
                        Object res = param.getResult();
                        byte[] res1 = (byte[]) res;
                        Log.e("Xposed-12306/mpass", "...doCommand returns : " + Arrays.toString(res1));
                    }
                });


//        XposedHelpers.findAndHookMethod("ahw",
//                lpparam.classLoader, "getHeader", String.class, new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
//                        String param1 = (String) param.args[0];
//                        Log.e("Xposed-Amap", "getHeader......" + param1);
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
//                        Object res = param.getResult();
//                        if (res instanceof String == false ) {
//                            byte[] res1 = (byte[]) res;
//                            Log.e("Xposed-Amap", "getHeader Result byte: " + Arrays.toString(res1));
//                        } else {
//                            Log.e("Xposed-Amap", "getHeader Result string: " + (String)(res));
//                        }
//                    }
//                });
//
//        XposedHelpers.findAndHookConstructor("com.autonavi.minimap.drive.freeride.statusmachine.request.IndexPageRequest$IndexPageParam",
//                lpparam.classLoader, byte.class, new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
//                        String param1 = (String) param.args[0];
//                        Log.e("Xposed-Amap", "IndexPageRequest$IndexPageParam" + param1);
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
//                    }
//                });
//
//
//
//        XposedHelpers.findAndHookMethod("ahw",
//                lpparam.classLoader, "getResponseBodyString", new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
//                        Log.e("getResponseBodyString", "......");
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
//                        Object res = param.getResult();
//                        if (res instanceof String == false ) {
//                            byte[] res1 = (byte[]) res;
//                            Log.e("getResponseBodyResult", "byte: " + Arrays.toString(res1));
//                        } else {
//                            String str = (String) res;
//                            Log.e("getResponseBodyResult", Integer.toString((str.length())));
//                            Log.e("getResponseBodyResult", "string: " + res);
//                        }
//                    }
//                });
//
    }


    /**
     * Gao De Map
     */
    private void handleAmap(final XC_LoadPackage.LoadPackageParam lpparam) {

        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",
                lpparam.classLoader, "getPackageInfo", String.class, int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 2, 93, 48, -126, 1, -58, -96, 3, 2, 1, 2, 2, 4, 76, 3, 39, 40, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 114, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 17, 48, 15, 6, 3, 85, 4, 10, 19, 8, 97, 117, 116, 111, 110, 97, 118, 105, 49, 26, 48, 24, 6, 3, 85, 4, 11, 19, 17, 109, 111, 98, 105, 108, 101, 32, 100, 101, 112, 97, 114, 116, 109, 101, 110, 116, 49, 16, 48, 14, 6, 3, 85, 4, 3, 19, 7, 109, 105, 110, 105, 109, 97, 112, 48, 32, 23, 13, 49, 48, 48, 53, 51, 49, 48, 51, 48, 52, 48, 56, 90, 24, 15, 50, 48, 54, 53, 48, 51, 48, 51, 48, 51, 48, 52, 48, 56, 90, 48, 114, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 17, 48, 15, 6, 3, 85, 4, 10, 19, 8, 97, 117, 116, 111, 110, 97, 118, 105, 49, 26, 48, 24, 6, 3, 85, 4, 11, 19, 17, 109, 111, 98, 105, 108, 101, 32, 100, 101, 112, 97, 114, 116, 109, 101, 110, 116, 49, 16, 48, 14, 6, 3, 85, 4, 3, 19, 7, 109, 105, 110, 105, 109, 97, 112, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -84, 36, 92, -102, -12, -70, -45, 46, -48, 7, -25, -70, 94, -93, 92, 3, -30, 110, -98, 49, 62, 64, -89, 111, 62, 87, -97, -88, -26, 18, -62, -118, 99, -23, 7, -122, -78, -34, -100, -61, 114, -50, -121, -59, 94, 80, -30, -11, -26, -20, 70, 51, 102, -32, -120, 119, 60, -92, -115, -9, -43, 105, -16, 37, 92, -124, 73, 118, -45, 112, 10, -83, -65, 7, 35, 6, 66, 59, -13, 35, 103, -16, 126, -75, 37, 10, -112, -70, 11, -43, 109, 122, -22, 24, 80, 54, -75, 24, 9, 6, -118, -41, 51, -5, 44, 28, 44, -17, 15, -105, -112, 9, -42, -115, -25, 62, -95, 0, -26, -51, -128, 2, -2, -86, 2, 103, -76, -105, 2, 3, 1, 0, 1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, -91, 32, 102, -64, -19, -5, -55, -18, 90, 95, -12, -54, -1, 57, -99, -79, 26, 116, 27, 49, 84, 45, 110, 105, -53, -49, -17, 3, 89, 118, 120, -94, 84, -76, 16, 42, 60, 66, -5, -30, -112, 58, -12, 50, -10, -8, -3, -36, -83, -121, 4, -2, 46, -107, 44, 57, -75, -69, -6, -56, -110, 1, -97, 50, -58, 123, -37, -48, -127, -12, 12, 93, 99, 68, 55, -15, -26, -21, -30, 125, 118, 124, 98, 27, -107, 82, 76, -128, 123, 13, 19, 24, 81, -113, 114, 28, 70, 16, 59, -125, 28, -117, -68, -17, 27, 113, -110, -58, -42, -50, -66, 28, -125, -58, -11, -86, 4, 106, -46, -115, -68, 111, 1, 56, 90, -112, 96, 28};
                                // {48, -126, 3, -99, 48, -126, 2, -123, -96, 3, 2, 1, 2, 2, 4, 88, 3, -68, -45, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 126, 49, 40, 48, 38, 6, 3, 85, 4, 10, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 11, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 3, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 48, 32, 23, 13, 49, 51, 48, 53, 48, 56, 48, 56, 50, 52, 50, 49, 90, 24, 15, 51, 48, 49, 50, 48, 57, 48, 56, 48, 56, 50, 52, 50, 49, 90, 48, 126, 49, 40, 48, 38, 6, 3, 85, 4, 10, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 11, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 3, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -98, 12, -58, 101, -96, -8, 58, -118, 59, 107, 107, 37, 33, -6, -21, 20, 34, -88, -27, 71, -112, 79, -51, 103, -94, -6, -107, -117, -57, 101, 65, -119, 22, 66, 93, 111, -106, 30, 31, -118, 20, -30, 116, 110, -126, -54, -106, -81, 64, -61, 106, 117, 101, -79, 127, 108, -90, 95, -108, -105, 12, 35, 123, -51, -72, 89, -100, -42, -93, -32, 119, 59, 33, -5, -3, 10, 19, -8, 4, -22, -12, -62, 37, -26, 122, -122, 52, 11, -97, 16, 111, -115, -68, -47, 100, 74, -44, 119, -7, 40, -122, 40, 33, 79, 55, 92, 40, 112, 7, 114, -87, 13, 12, -29, 83, 88, -113, -73, 71, -4, 80, -121, 124, -115, 65, 118, -30, -77, -52, -97, 110, -61, 98, -55, -97, 17, 98, -1, -68, 87, 46, 122, 14, 104, -15, -105, 64, -106, -22, 115, -91, 86, 91, -10, 85, 101, 52, 20, -112, 31, -81, -46, 78, -16, 9, -99, -85, -112, 114, -126, -33, -63, -101, -3, -85, -123, 109, 65, 117, -41, 81, -109, 55, 114, -86, 12, -7, 73, 96, 72, -93, 36, -62, -80, -65, 104, 120, 118, 18, -116, -56, 76, 16, 32, -63, 45, 37, 49, -78, -48, 18, -60, -68, -61, 104, 8, 18, -125, -77, -30, 56, -21, 91, 83, 88, 13, 52, 16, -116, 75, 68, 79, -45, 47, 52, -97, 108, -16, -74, -20, 96, 26, 49, -70, 45, 34, -108, 113, -124, 43, 26, -86, -116, 91, -70, 1, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 89, -57, 94, -56, -46, -52, -55, -63, 85, -49, 90, 3, -110, -67, -7, -20, -35, -18, -65, 71, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 69, -102, -118, -29, 31, 83, -43, 107, 19, 115, 109, 68, 54, 115, 59, 99, 11, 2, 61, 40, 117, 71, 98, 8, 110, 58, 78, 39, -41, -92, -82, 37, 89, -79, 6, -43, 17, 50, 3, -88, -3, -76, 104, -97, 69, -16, -89, 99, -22, 125, 77, -125, 120, 68, -110, 126, 44, 28, -94, 42, 61, 86, -46, 54, -55, -127, -98, 104, 20, -81, -126, 1, 113, 2, -44, 103, -60, -53, 85, -47, -79, -103, -95, 90, -108, -42, 52, -125, 76, 21, 44, 56, -98, 110, 85, 90, 40, 67, -116, 114, -3, -63, 111, -76, 117, -48, 69, 33, 63, -69, 56, -125, -37, -12, 71, 45, -28, 80, -104, -42, -106, 110, 16, 66, 71, 116, -81, 115, 19, -22, 115, -87, -4, 39, -55, -56, -85, -127, -22, 33, 84, 40, -95, -26, 27, 87, -97, 43, -109, 71, -81, 21, 39, -98, -62, 89, -78, 88, 34, -36, 43, -85, -116, -71, 113, 32, 88, 6, -4, 100, -21, -87, -2, 91, -73, -67, -5, 122, -31, -96, -73, -108, 20, 34, -79, 111, -127, -112, 57, 9, 80, 70, -53, 125, -86, -53, 72, 109, 124, -45, -3, 33, 56, 44, -57, 58, -118, 103, -41, 36, 85, 119, 52, 5, 60, 85, -109, -58, 109, 52, 49, -23, 123, -101, -53, -72, -43, -50, 2, 31, -108, 116, -48, 99, -95, 86, -124, -49, -21, -3, 107, -59, 124, -55, 37, 67, -16, -109, -9, 107, -100, 60, 27, 117, -19, 64};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 2, 93, 48, -126, 1, -58, -96, 3, 2, 1, 2, 2, 4, 76, 3, 39, 40, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 114, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 17, 48, 15, 6, 3, 85, 4, 10, 19, 8, 97, 117, 116, 111, 110, 97, 118, 105, 49, 26, 48, 24, 6, 3, 85, 4, 11, 19, 17, 109, 111, 98, 105, 108, 101, 32, 100, 101, 112, 97, 114, 116, 109, 101, 110, 116, 49, 16, 48, 14, 6, 3, 85, 4, 3, 19, 7, 109, 105, 110, 105, 109, 97, 112, 48, 32, 23, 13, 49, 48, 48, 53, 51, 49, 48, 51, 48, 52, 48, 56, 90, 24, 15, 50, 48, 54, 53, 48, 51, 48, 51, 48, 51, 48, 52, 48, 56, 90, 48, 114, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 99, 110, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 98, 101, 105, 106, 105, 110, 103, 49, 17, 48, 15, 6, 3, 85, 4, 10, 19, 8, 97, 117, 116, 111, 110, 97, 118, 105, 49, 26, 48, 24, 6, 3, 85, 4, 11, 19, 17, 109, 111, 98, 105, 108, 101, 32, 100, 101, 112, 97, 114, 116, 109, 101, 110, 116, 49, 16, 48, 14, 6, 3, 85, 4, 3, 19, 7, 109, 105, 110, 105, 109, 97, 112, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -84, 36, 92, -102, -12, -70, -45, 46, -48, 7, -25, -70, 94, -93, 92, 3, -30, 110, -98, 49, 62, 64, -89, 111, 62, 87, -97, -88, -26, 18, -62, -118, 99, -23, 7, -122, -78, -34, -100, -61, 114, -50, -121, -59, 94, 80, -30, -11, -26, -20, 70, 51, 102, -32, -120, 119, 60, -92, -115, -9, -43, 105, -16, 37, 92, -124, 73, 118, -45, 112, 10, -83, -65, 7, 35, 6, 66, 59, -13, 35, 103, -16, 126, -75, 37, 10, -112, -70, 11, -43, 109, 122, -22, 24, 80, 54, -75, 24, 9, 6, -118, -41, 51, -5, 44, 28, 44, -17, 15, -105, -112, 9, -42, -115, -25, 62, -95, 0, -26, -51, -128, 2, -2, -86, 2, 103, -76, -105, 2, 3, 1, 0, 1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, -91, 32, 102, -64, -19, -5, -55, -18, 90, 95, -12, -54, -1, 57, -99, -79, 26, 116, 27, 49, 84, 45, 110, 105, -53, -49, -17, 3, 89, 118, 120, -94, 84, -76, 16, 42, 60, 66, -5, -30, -112, 58, -12, 50, -10, -8, -3, -36, -83, -121, 4, -2, 46, -107, 44, 57, -75, -69, -6, -56, -110, 1, -97, 50, -58, 123, -37, -48, -127, -12, 12, 93, 99, 68, 55, -15, -26, -21, -30, 125, 118, 124, 98, 27, -107, 82, 76, -128, 123, 13, 19, 24, 81, -113, 114, 28, 70, 16, 59, -125, 28, -117, -68, -17, 27, 113, -110, -58, -42, -50, -66, 28, -125, -58, -11, -86, 4, 106, -46, -115, -68, 111, 1, 56, 90, -112, 96, 28};
                                // {48, -126, 3, -99, 48, -126, 2, -123, -96, 3, 2, 1, 2, 2, 4, 88, 3, -68, -45, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 126, 49, 40, 48, 38, 6, 3, 85, 4, 10, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 11, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 3, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 48, 32, 23, 13, 49, 51, 48, 53, 48, 56, 48, 56, 50, 52, 50, 49, 90, 24, 15, 51, 48, 49, 50, 48, 57, 48, 56, 48, 56, 50, 52, 50, 49, 90, 48, 126, 49, 40, 48, 38, 6, 3, 85, 4, 10, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 11, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 3, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -98, 12, -58, 101, -96, -8, 58, -118, 59, 107, 107, 37, 33, -6, -21, 20, 34, -88, -27, 71, -112, 79, -51, 103, -94, -6, -107, -117, -57, 101, 65, -119, 22, 66, 93, 111, -106, 30, 31, -118, 20, -30, 116, 110, -126, -54, -106, -81, 64, -61, 106, 117, 101, -79, 127, 108, -90, 95, -108, -105, 12, 35, 123, -51, -72, 89, -100, -42, -93, -32, 119, 59, 33, -5, -3, 10, 19, -8, 4, -22, -12, -62, 37, -26, 122, -122, 52, 11, -97, 16, 111, -115, -68, -47, 100, 74, -44, 119, -7, 40, -122, 40, 33, 79, 55, 92, 40, 112, 7, 114, -87, 13, 12, -29, 83, 88, -113, -73, 71, -4, 80, -121, 124, -115, 65, 118, -30, -77, -52, -97, 110, -61, 98, -55, -97, 17, 98, -1, -68, 87, 46, 122, 14, 104, -15, -105, 64, -106, -22, 115, -91, 86, 91, -10, 85, 101, 52, 20, -112, 31, -81, -46, 78, -16, 9, -99, -85, -112, 114, -126, -33, -63, -101, -3, -85, -123, 109, 65, 117, -41, 81, -109, 55, 114, -86, 12, -7, 73, 96, 72, -93, 36, -62, -80, -65, 104, 120, 118, 18, -116, -56, 76, 16, 32, -63, 45, 37, 49, -78, -48, 18, -60, -68, -61, 104, 8, 18, -125, -77, -30, 56, -21, 91, 83, 88, 13, 52, 16, -116, 75, 68, 79, -45, 47, 52, -97, 108, -16, -74, -20, 96, 26, 49, -70, 45, 34, -108, 113, -124, 43, 26, -86, -116, 91, -70, 1, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 89, -57, 94, -56, -46, -52, -55, -63, 85, -49, 90, 3, -110, -67, -7, -20, -35, -18, -65, 71, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 69, -102, -118, -29, 31, 83, -43, 107, 19, 115, 109, 68, 54, 115, 59, 99, 11, 2, 61, 40, 117, 71, 98, 8, 110, 58, 78, 39, -41, -92, -82, 37, 89, -79, 6, -43, 17, 50, 3, -88, -3, -76, 104, -97, 69, -16, -89, 99, -22, 125, 77, -125, 120, 68, -110, 126, 44, 28, -94, 42, 61, 86, -46, 54, -55, -127, -98, 104, 20, -81, -126, 1, 113, 2, -44, 103, -60, -53, 85, -47, -79, -103, -95, 90, -108, -42, 52, -125, 76, 21, 44, 56, -98, 110, 85, 90, 40, 67, -116, 114, -3, -63, 111, -76, 117, -48, 69, 33, 63, -69, 56, -125, -37, -12, 71, 45, -28, 80, -104, -42, -106, 110, 16, 66, 71, 116, -81, 115, 19, -22, 115, -87, -4, 39, -55, -56, -85, -127, -22, 33, 84, 40, -95, -26, 27, 87, -97, 43, -109, 71, -81, 21, 39, -98, -62, 89, -78, 88, 34, -36, 43, -85, -116, -71, 113, 32, 88, 6, -4, 100, -21, -87, -2, 91, -73, -67, -5, 122, -31, -96, -73, -108, 20, 34, -79, 111, -127, -112, 57, 9, 80, 70, -53, 125, -86, -53, 72, 109, 124, -45, -3, 33, 56, 44, -57, 58, -118, 103, -41, 36, 85, 119, 52, 5, 60, 85, -109, -58, 109, 52, 49, -23, 123, -101, -53, -72, -43, -50, 2, 31, -108, 116, -48, 99, -95, 86, -124, -49, -21, -3, 107, -59, 124, -55, 37, 67, -16, -109, -9, 107, -100, 60, 27, 117, -19, 64};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                        // byte[] oldCert = ((PackageInfo) param.getResult()).signatures[0].toByteArray();
                        // Log.e("xposed-amap", Arrays.toString(oldCert));
                        Log.e("xposed-Amap", "...setting cert to " + Arrays.toString(cert));
                    }
                });

        XposedHelpers.findAndHookMethod("com.autonavi.map.activity.SplashActivity",
                lpparam.classLoader, "onCreate", "android.os.Bundle", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Log.e("SplashAct: onCreate", "......entered");
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("bjs",
                lpparam.classLoader, "i", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        Log.e("Xposed-Amap", "...From SplashActivity...entered bjs.i()...");
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });

        XposedHelpers.findAndHookMethod("ahw",
                lpparam.classLoader, "getHeader", String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        String param1 = (String) param.args[0];
                        Log.e("Xposed-Amap", "getHeader......" + param1);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Object res = param.getResult();
                        if (res instanceof String == false ) {
                            byte[] res1 = (byte[]) res;
                            Log.e("Xposed-Amap", "getHeader Result byte: " + Arrays.toString(res1));
                        } else {
                            Log.e("Xposed-Amap", "getHeader Result string: " + (String)(res));
                        }
                    }
                });

        XposedHelpers.findAndHookConstructor("com.autonavi.minimap.drive.freeride.statusmachine.request.IndexPageRequest$IndexPageParam",
                lpparam.classLoader, byte.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        String param1 = (String) param.args[0];
                        Log.e("Xposed-Amap", "IndexPageRequest$IndexPageParam" + param1);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });



        XposedHelpers.findAndHookMethod("ahw",
                lpparam.classLoader, "getResponseBodyString", new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e("getResponseBodyString", "......");
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                        Object res = param.getResult();
                        if (res instanceof String == false ) {
                            byte[] res1 = (byte[]) res;
                            Log.e("getResponseBodyResult", "byte: " + Arrays.toString(res1));
                        } else {
                            String str = (String) res;
                            Log.e("getResponseBodyResult", Integer.toString((str.length())));
                            Log.e("getResponseBodyResult", "string: " + res);
                        }
                    }
                });

//        XposedHelpers.findAndHookMethod("dwc$1",
//                lpparam.classLoader, "getPostContent",
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
//                        byte[] res = (byte[]) param.getResult();
//                        Log.e("xposed_log", "byte: " + Arrays.toString(res));
//                    }
//                });
//
    }

    /**
     * 点我达骑手
     *
     * @param lpparam XC_LoadPackage.LoadPackageParam
     */
    private void handleDianWoDaDriver(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",
                lpparam.classLoader, "getPackageInfo", String.class, int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 3, 103, 48, -126, 2, 79, -96, 3, 2, 1, 2, 2, 4, 34, -107, -78, 8, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 99, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 16, 48, 14, 6, 3, 85, 4, 10, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 16, 48, 14, 6, 3, 85, 4, 11, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 12, 48, 10, 6, 3, 85, 4, 3, 19, 3, 120, 108, 106, 48, 32, 23, 13, 49, 52, 48, 53, 48, 54, 48, 54, 50, 52, 53, 51, 90, 24, 15, 51, 48, 49, 51, 48, 57, 48, 54, 48, 54, 50, 52, 53, 51, 90, 48, 99, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 16, 48, 14, 6, 3, 85, 4, 10, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 16, 48, 14, 6, 3, 85, 4, 11, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 12, 48, 10, 6, 3, 85, 4, 3, 19, 3, 120, 108, 106, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -98, -41, -21, -33, 30, 112, 57, 115, 82, -33, -31, -64, 24, -111, -112, 112, -101, -39, -2, -126, 60, -122, -61, 0, -75, -88, -40, -105, 65, -43, 85, -126, 50, 112, -23, -77, 11, -111, 22, 90, 67, 62, -105, -66, -110, 119, -89, 73, -34, -20, -7, -113, -17, 40, -74, -120, 20, -26, 64, -115, -59, -40, -127, 112, -61, -3, 83, 118, 18, -49, -37, -81, 33, 90, -57, 84, 85, 67, -46, 76, -39, -78, 75, 127, -61, 103, -51, 56, 9, 32, -113, 19, 68, -58, -110, -69, 87, -15, 21, 45, 116, 21, 112, 40, -52, 125, -1, 34, 33, -8, -20, -41, 43, 21, 24, -92, 26, -55, 91, 88, 30, 59, -124, 124, 120, -108, -92, 46, -61, -14, 123, -79, -117, 15, -13, 92, -124, -45, 88, 17, 107, -127, -39, 16, 27, 45, 49, 60, -63, 30, 39, 79, -104, 101, 25, -53, 65, 93, 80, -39, -72, -52, 120, 48, 63, -112, 12, 77, -54, -114, 108, -48, -111, -78, -55, 109, -60, -42, -45, -24, -88, 5, -41, 85, -36, -70, 59, 111, 67, -120, 12, 8, 89, 52, -50, -3, -128, -3, -44, -16, -12, -30, -81, 24, 92, 107, 71, -1, 118, 77, 89, 41, -106, 93, -31, -91, -109, -118, 100, -41, 6, 116, 124, -52, 21, 36, 59, 75, 51, 97, -32, -120, -20, 67, -121, 75, 95, 75, 83, -21, 78, 107, -102, 126, 44, -91, 68, 60, -1, -89, -57, -55, -80, -62, 47, 121, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 88, 63, -104, 99, 51, -70, -80, -12, 121, -69, -69, -45, -16, 120, 106, 23, 123, 69, -91, -102, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 104, -124, 96, 82, 38, -72, 3, -86, -60, 59, -112, -7, -34, 105, -7, 17, 7, 106, -10, -53, -75, 84, 114, 114, 29, -45, -32, -64, -4, 0, 26, 57, 82, -24, 46, 15, 117, -34, 29, -94, -77, -33, 19, 118, -43, -89, 42, 45, -93, 24, -111, -123, -70, -104, 48, -53, -116, 52, -41, 23, 45, -1, 66, 84, 127, 103, 118, -75, 69, -32, -55, 53, -6, -89, -101, 127, -51, 81, 47, 30, -90, -23, 34, -121, 75, -121, 45, -1, 94, -68, -126, -104, 124, -70, 104, -13, -104, 57, -104, 25, -2, 83, -93, 101, 16, -26, -64, 52, -21, 106, 38, 29, 124, 126, 106, -127, 3, 117, -82, 83, 35, -99, 58, 29, -44, 113, -49, -55, 47, -108, 58, 42, 83, 102, 96, -46, -123, -124, 60, -98, 5, 84, 114, 96, 102, 120, 39, 71, -20, 81, -32, 31, 91, 28, 56, 110, -86, 9, 84, 95, 106, 6, -61, 43, -128, -80, 57, -1, 51, 50, -36, 17, -112, -65, -66, -53, 2, -107, 103, 28, -9, 44, -17, 96, 15, 51, -13, 111, -24, 77, 127, 11, 122, -43, -105, -28, 34, -58, -36, -115, -30, -112, 55, -13, -95, 27, 57, -28, -19, 20, 121, -2, 86, 124, -125, -5, 119, -10, -115, 84, 7, 89, -124, -28, 32, 109, 115, 57, 61, -124, 72, 31, -17, 15, 51, 56, 47, -120, -73, 102, -52, -76, 121, 41, -23, -21, 3, 74, 54, 34, 32, -5, -90, 59, 53, -25};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 3, 103, 48, -126, 2, 79, -96, 3, 2, 1, 2, 2, 4, 34, -107, -78, 8, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 99, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 16, 48, 14, 6, 3, 85, 4, 10, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 16, 48, 14, 6, 3, 85, 4, 11, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 12, 48, 10, 6, 3, 85, 4, 3, 19, 3, 120, 108, 106, 48, 32, 23, 13, 49, 52, 48, 53, 48, 54, 48, 54, 50, 52, 53, 51, 90, 24, 15, 51, 48, 49, 51, 48, 57, 48, 54, 48, 54, 50, 52, 53, 51, 90, 48, 99, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 16, 48, 14, 6, 3, 85, 4, 10, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 16, 48, 14, 6, 3, 85, 4, 11, 19, 7, 104, 97, 111, 110, 103, 122, 111, 49, 12, 48, 10, 6, 3, 85, 4, 3, 19, 3, 120, 108, 106, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -98, -41, -21, -33, 30, 112, 57, 115, 82, -33, -31, -64, 24, -111, -112, 112, -101, -39, -2, -126, 60, -122, -61, 0, -75, -88, -40, -105, 65, -43, 85, -126, 50, 112, -23, -77, 11, -111, 22, 90, 67, 62, -105, -66, -110, 119, -89, 73, -34, -20, -7, -113, -17, 40, -74, -120, 20, -26, 64, -115, -59, -40, -127, 112, -61, -3, 83, 118, 18, -49, -37, -81, 33, 90, -57, 84, 85, 67, -46, 76, -39, -78, 75, 127, -61, 103, -51, 56, 9, 32, -113, 19, 68, -58, -110, -69, 87, -15, 21, 45, 116, 21, 112, 40, -52, 125, -1, 34, 33, -8, -20, -41, 43, 21, 24, -92, 26, -55, 91, 88, 30, 59, -124, 124, 120, -108, -92, 46, -61, -14, 123, -79, -117, 15, -13, 92, -124, -45, 88, 17, 107, -127, -39, 16, 27, 45, 49, 60, -63, 30, 39, 79, -104, 101, 25, -53, 65, 93, 80, -39, -72, -52, 120, 48, 63, -112, 12, 77, -54, -114, 108, -48, -111, -78, -55, 109, -60, -42, -45, -24, -88, 5, -41, 85, -36, -70, 59, 111, 67, -120, 12, 8, 89, 52, -50, -3, -128, -3, -44, -16, -12, -30, -81, 24, 92, 107, 71, -1, 118, 77, 89, 41, -106, 93, -31, -91, -109, -118, 100, -41, 6, 116, 124, -52, 21, 36, 59, 75, 51, 97, -32, -120, -20, 67, -121, 75, 95, 75, 83, -21, 78, 107, -102, 126, 44, -91, 68, 60, -1, -89, -57, -55, -80, -62, 47, 121, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 88, 63, -104, 99, 51, -70, -80, -12, 121, -69, -69, -45, -16, 120, 106, 23, 123, 69, -91, -102, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 104, -124, 96, 82, 38, -72, 3, -86, -60, 59, -112, -7, -34, 105, -7, 17, 7, 106, -10, -53, -75, 84, 114, 114, 29, -45, -32, -64, -4, 0, 26, 57, 82, -24, 46, 15, 117, -34, 29, -94, -77, -33, 19, 118, -43, -89, 42, 45, -93, 24, -111, -123, -70, -104, 48, -53, -116, 52, -41, 23, 45, -1, 66, 84, 127, 103, 118, -75, 69, -32, -55, 53, -6, -89, -101, 127, -51, 81, 47, 30, -90, -23, 34, -121, 75, -121, 45, -1, 94, -68, -126, -104, 124, -70, 104, -13, -104, 57, -104, 25, -2, 83, -93, 101, 16, -26, -64, 52, -21, 106, 38, 29, 124, 126, 106, -127, 3, 117, -82, 83, 35, -99, 58, 29, -44, 113, -49, -55, 47, -108, 58, 42, 83, 102, 96, -46, -123, -124, 60, -98, 5, 84, 114, 96, 102, 120, 39, 71, -20, 81, -32, 31, 91, 28, 56, 110, -86, 9, 84, 95, 106, 6, -61, 43, -128, -80, 57, -1, 51, 50, -36, 17, -112, -65, -66, -53, 2, -107, 103, 28, -9, 44, -17, 96, 15, 51, -13, 111, -24, 77, 127, 11, 122, -43, -105, -28, 34, -58, -36, -115, -30, -112, 55, -13, -95, 27, 57, -28, -19, 20, 121, -2, 86, 124, -125, -5, 119, -10, -115, 84, 7, 89, -124, -28, 32, 109, 115, 57, 61, -124, 72, 31, -17, 15, 51, 56, 47, -120, -73, 102, -52, -76, 121, 41, -23, -21, 3, 74, 54, 34, 32, -5, -90, 59, 53, -25};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }
                });
    }

    /**
     * ola
     *
     * @param lpparam XC_LoadPackage.LoadPackageParam
     */
    private void handleOla(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",
                lpparam.classLoader, "getPackageInfo", String.class, int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 2, -45, 48, -126, 1, -69, -96, 3, 2, 1, 2, 2, 4, 37, -53, 121, 57, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 25, 49, 23, 48, 21, 6, 3, 85, 4, 3, 19, 14, 65, 106, 105, 110, 107, 121, 97, 32, 80, 111, 116, 100, 97, 114, 48, 32, 23, 13, 49, 50, 48, 54, 48, 50, 48, 51, 50, 56, 52, 57, 90, 24, 15, 51, 48, 49, 49, 49, 48, 48, 52, 48, 51, 50, 56, 52, 57, 90, 48, 25, 49, 23, 48, 21, 6, 3, 85, 4, 3, 19, 14, 65, 106, 105, 110, 107, 121, 97, 32, 80, 111, 116, 100, 97, 114, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -111, -121, -17, -105, 16, 96, 61, -76, 69, -128, -64, 44, 14, -57, 23, -108, -46, -116, 25, -124, -82, -101, -122, 16, 94, 96, 99, -124, 57, 23, 9, -117, 119, -63, -96, -46, -32, -25, -72, 81, 43, 71, 23, 32, -114, -16, 82, 48, 8, -74, -48, -52, -27, -12, 23, -102, -127, 19, -111, 116, -2, -93, 5, 16, 124, -13, 4, 58, -3, -116, 112, -35, 21, 75, 61, -33, 17, 29, 14, -60, 126, 35, 108, 69, 98, -45, -19, 101, 52, -96, 97, -69, 78, 115, -73, 103, 81, -105, 85, 21, 1, 0, 59, -52, -4, -86, -76, 6, 117, 114, -74, 99, -106, -119, 73, -15, 68, -22, 8, 21, 79, 33, 113, -88, -35, 96, 22, -40, 93, -8, -96, 105, -94, 66, -18, 102, 53, -10, 6, -103, 21, 119, 100, -61, -55, -61, -85, 37, 77, 86, 110, 105, 45, -104, -99, -15, -113, -65, 95, -84, -69, -51, -16, 49, 1, -120, -37, 124, 83, 117, 115, -93, -89, 93, 106, 7, 110, -64, 49, 94, -38, 68, 100, 78, -57, -106, -97, -42, -90, -10, 18, -45, -91, 21, 53, 97, -65, 3, 13, 92, 74, 16, 22, -52, 104, 67, 93, 30, -109, -20, 73, -59, -44, -102, -46, 124, 6, -22, -76, -73, 37, 7, 38, 19, 99, -33, 12, 104, 37, -117, -13, 54, 74, 57, -56, 47, 5, -31, -3, 117, -94, 87, -4, -97, -28, -107, -100, -81, 87, -38, 107, -59, 78, 119, 102, 97, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 38, -91, 70, -15, 75, -61, -111, -51, 44, 71, 110, 58, -120, -31, 51, -50, 10, -56, -78, 11, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, -128, 78, -109, 48, -9, 35, 39, 29, -25, 99, -24, 51, 29, -96, 54, -17, -89, -75, 66, 43, 46, -121, -120, -81, -96, -78, 50, -9, 107, 76, 94, -104, -100, -121, -32, -88, 34, -8, -22, -77, -126, -74, 124, -76, 64, 3, 90, -84, -48, -74, -23, 100, -16, 123, -111, -55, 76, 77, -46, -100, -92, -112, -53, -104, 58, -125, 94, -16, -99, -37, 45, -107, 59, 113, 83, 126, 110, -36, 107, -92, -125, 16, -127, -46, -50, -17, -65, 82, 61, 81, 52, -32, 64, -124, -127, -58, 86, -84, -15, 32, 16, 105, 46, -116, 74, 118, -55, 21, -32, -51, 59, -36, 83, 40, -99, -6, 13, 16, 85, 6, 64, -94, 127, 47, -69, -56, 119, -103, 29, -65, 66, 32, -87, -91, -118, -62, 105, -97, 29, -37, -128, 63, 126, -46, -100, 102, 95, 70, 11, 124, -116, -107, 95, 115, -43, 43, 40, -90, -101, 6, 98, -77, 60, -65, -52, 58, -90, 97, 56, -57, 98, -64, 115, -16, -35, -58, -20, -64, -37, -99, -19, 27, -113, -104, -74, -19, 86, -81, -91, -107, 41, 69, 127, -83, 22, 34, -12, 112, 46, -71, -70, 48, 14, -37, -14, 65, -77, 65, 72, -53, -74, 46, 52, -73, -74, -18, 65, 3, 35, 30, -67, 32, -124, 89, -51, -13, -78, -53, 126, 102, -108, 89, 7, -113, -66, 75, 2, -96, 10, 122, -105, 105, 63, 84, -43, 76, 2, -69, -90, -34, -102, -42, -18, 71, -29, 77};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 2, -45, 48, -126, 1, -69, -96, 3, 2, 1, 2, 2, 4, 37, -53, 121, 57, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 25, 49, 23, 48, 21, 6, 3, 85, 4, 3, 19, 14, 65, 106, 105, 110, 107, 121, 97, 32, 80, 111, 116, 100, 97, 114, 48, 32, 23, 13, 49, 50, 48, 54, 48, 50, 48, 51, 50, 56, 52, 57, 90, 24, 15, 51, 48, 49, 49, 49, 48, 48, 52, 48, 51, 50, 56, 52, 57, 90, 48, 25, 49, 23, 48, 21, 6, 3, 85, 4, 3, 19, 14, 65, 106, 105, 110, 107, 121, 97, 32, 80, 111, 116, 100, 97, 114, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -111, -121, -17, -105, 16, 96, 61, -76, 69, -128, -64, 44, 14, -57, 23, -108, -46, -116, 25, -124, -82, -101, -122, 16, 94, 96, 99, -124, 57, 23, 9, -117, 119, -63, -96, -46, -32, -25, -72, 81, 43, 71, 23, 32, -114, -16, 82, 48, 8, -74, -48, -52, -27, -12, 23, -102, -127, 19, -111, 116, -2, -93, 5, 16, 124, -13, 4, 58, -3, -116, 112, -35, 21, 75, 61, -33, 17, 29, 14, -60, 126, 35, 108, 69, 98, -45, -19, 101, 52, -96, 97, -69, 78, 115, -73, 103, 81, -105, 85, 21, 1, 0, 59, -52, -4, -86, -76, 6, 117, 114, -74, 99, -106, -119, 73, -15, 68, -22, 8, 21, 79, 33, 113, -88, -35, 96, 22, -40, 93, -8, -96, 105, -94, 66, -18, 102, 53, -10, 6, -103, 21, 119, 100, -61, -55, -61, -85, 37, 77, 86, 110, 105, 45, -104, -99, -15, -113, -65, 95, -84, -69, -51, -16, 49, 1, -120, -37, 124, 83, 117, 115, -93, -89, 93, 106, 7, 110, -64, 49, 94, -38, 68, 100, 78, -57, -106, -97, -42, -90, -10, 18, -45, -91, 21, 53, 97, -65, 3, 13, 92, 74, 16, 22, -52, 104, 67, 93, 30, -109, -20, 73, -59, -44, -102, -46, 124, 6, -22, -76, -73, 37, 7, 38, 19, 99, -33, 12, 104, 37, -117, -13, 54, 74, 57, -56, 47, 5, -31, -3, 117, -94, 87, -4, -97, -28, -107, -100, -81, 87, -38, 107, -59, 78, 119, 102, 97, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 38, -91, 70, -15, 75, -61, -111, -51, 44, 71, 110, 58, -120, -31, 51, -50, 10, -56, -78, 11, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, -128, 78, -109, 48, -9, 35, 39, 29, -25, 99, -24, 51, 29, -96, 54, -17, -89, -75, 66, 43, 46, -121, -120, -81, -96, -78, 50, -9, 107, 76, 94, -104, -100, -121, -32, -88, 34, -8, -22, -77, -126, -74, 124, -76, 64, 3, 90, -84, -48, -74, -23, 100, -16, 123, -111, -55, 76, 77, -46, -100, -92, -112, -53, -104, 58, -125, 94, -16, -99, -37, 45, -107, 59, 113, 83, 126, 110, -36, 107, -92, -125, 16, -127, -46, -50, -17, -65, 82, 61, 81, 52, -32, 64, -124, -127, -58, 86, -84, -15, 32, 16, 105, 46, -116, 74, 118, -55, 21, -32, -51, 59, -36, 83, 40, -99, -6, 13, 16, 85, 6, 64, -94, 127, 47, -69, -56, 119, -103, 29, -65, 66, 32, -87, -91, -118, -62, 105, -97, 29, -37, -128, 63, 126, -46, -100, 102, 95, 70, 11, 124, -116, -107, 95, 115, -43, 43, 40, -90, -101, 6, 98, -77, 60, -65, -52, 58, -90, 97, 56, -57, 98, -64, 115, -16, -35, -58, -20, -64, -37, -99, -19, 27, -113, -104, -74, -19, 86, -81, -91, -107, 41, 69, 127, -83, 22, 34, -12, 112, 46, -71, -70, 48, 14, -37, -14, 65, -77, 65, 72, -53, -74, 46, 52, -73, -74, -18, 65, 3, 35, 30, -67, 32, -124, 89, -51, -13, -78, -53, 126, 102, -108, 89, 7, -113, -66, 75, 2, -96, 10, 122, -105, 105, 63, 84, -43, 76, 2, -69, -90, -34, -102, -42, -18, 71, -29, 77};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }
                });
    }

    /**
     * hk Taxi
     *
     * @param lpparam XC_LoadPackage.LoadPackageParam
     */
    private void handleHKTaxi(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",
                lpparam.classLoader, "getPackageInfo", String.class, int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 3, -99, 48, -126, 2, -123, -96, 3, 2, 1, 2, 2, 4, 88, 3, -68, -45, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 126, 49, 40, 48, 38, 6, 3, 85, 4, 10, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 11, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 3, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 48, 32, 23, 13, 49, 51, 48, 53, 48, 56, 48, 56, 50, 52, 50, 49, 90, 24, 15, 51, 48, 49, 50, 48, 57, 48, 56, 48, 56, 50, 52, 50, 49, 90, 48, 126, 49, 40, 48, 38, 6, 3, 85, 4, 10, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 11, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 3, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -98, 12, -58, 101, -96, -8, 58, -118, 59, 107, 107, 37, 33, -6, -21, 20, 34, -88, -27, 71, -112, 79, -51, 103, -94, -6, -107, -117, -57, 101, 65, -119, 22, 66, 93, 111, -106, 30, 31, -118, 20, -30, 116, 110, -126, -54, -106, -81, 64, -61, 106, 117, 101, -79, 127, 108, -90, 95, -108, -105, 12, 35, 123, -51, -72, 89, -100, -42, -93, -32, 119, 59, 33, -5, -3, 10, 19, -8, 4, -22, -12, -62, 37, -26, 122, -122, 52, 11, -97, 16, 111, -115, -68, -47, 100, 74, -44, 119, -7, 40, -122, 40, 33, 79, 55, 92, 40, 112, 7, 114, -87, 13, 12, -29, 83, 88, -113, -73, 71, -4, 80, -121, 124, -115, 65, 118, -30, -77, -52, -97, 110, -61, 98, -55, -97, 17, 98, -1, -68, 87, 46, 122, 14, 104, -15, -105, 64, -106, -22, 115, -91, 86, 91, -10, 85, 101, 52, 20, -112, 31, -81, -46, 78, -16, 9, -99, -85, -112, 114, -126, -33, -63, -101, -3, -85, -123, 109, 65, 117, -41, 81, -109, 55, 114, -86, 12, -7, 73, 96, 72, -93, 36, -62, -80, -65, 104, 120, 118, 18, -116, -56, 76, 16, 32, -63, 45, 37, 49, -78, -48, 18, -60, -68, -61, 104, 8, 18, -125, -77, -30, 56, -21, 91, 83, 88, 13, 52, 16, -116, 75, 68, 79, -45, 47, 52, -97, 108, -16, -74, -20, 96, 26, 49, -70, 45, 34, -108, 113, -124, 43, 26, -86, -116, 91, -70, 1, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 89, -57, 94, -56, -46, -52, -55, -63, 85, -49, 90, 3, -110, -67, -7, -20, -35, -18, -65, 71, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 69, -102, -118, -29, 31, 83, -43, 107, 19, 115, 109, 68, 54, 115, 59, 99, 11, 2, 61, 40, 117, 71, 98, 8, 110, 58, 78, 39, -41, -92, -82, 37, 89, -79, 6, -43, 17, 50, 3, -88, -3, -76, 104, -97, 69, -16, -89, 99, -22, 125, 77, -125, 120, 68, -110, 126, 44, 28, -94, 42, 61, 86, -46, 54, -55, -127, -98, 104, 20, -81, -126, 1, 113, 2, -44, 103, -60, -53, 85, -47, -79, -103, -95, 90, -108, -42, 52, -125, 76, 21, 44, 56, -98, 110, 85, 90, 40, 67, -116, 114, -3, -63, 111, -76, 117, -48, 69, 33, 63, -69, 56, -125, -37, -12, 71, 45, -28, 80, -104, -42, -106, 110, 16, 66, 71, 116, -81, 115, 19, -22, 115, -87, -4, 39, -55, -56, -85, -127, -22, 33, 84, 40, -95, -26, 27, 87, -97, 43, -109, 71, -81, 21, 39, -98, -62, 89, -78, 88, 34, -36, 43, -85, -116, -71, 113, 32, 88, 6, -4, 100, -21, -87, -2, 91, -73, -67, -5, 122, -31, -96, -73, -108, 20, 34, -79, 111, -127, -112, 57, 9, 80, 70, -53, 125, -86, -53, 72, 109, 124, -45, -3, 33, 56, 44, -57, 58, -118, 103, -41, 36, 85, 119, 52, 5, 60, 85, -109, -58, 109, 52, 49, -23, 123, -101, -53, -72, -43, -50, 2, 31, -108, 116, -48, 99, -95, 86, -124, -49, -21, -3, 107, -59, 124, -55, 37, 67, -16, -109, -9, 107, -100, 60, 27, 117, -19, 64};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 3, -99, 48, -126, 2, -123, -96, 3, 2, 1, 2, 2, 4, 88, 3, -68, -45, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 48, 126, 49, 40, 48, 38, 6, 3, 85, 4, 10, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 11, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 3, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 48, 32, 23, 13, 49, 51, 48, 53, 48, 56, 48, 56, 50, 52, 50, 49, 90, 24, 15, 51, 48, 49, 50, 48, 57, 48, 56, 48, 56, 50, 52, 50, 49, 90, 48, 126, 49, 40, 48, 38, 6, 3, 85, 4, 10, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 11, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 49, 40, 48, 38, 6, 3, 85, 4, 3, 19, 31, 67, 111, 114, 110, 101, 114, 109, 97, 116, 105, 111, 110, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 76, 105, 109, 105, 116, 101, 100, 48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -98, 12, -58, 101, -96, -8, 58, -118, 59, 107, 107, 37, 33, -6, -21, 20, 34, -88, -27, 71, -112, 79, -51, 103, -94, -6, -107, -117, -57, 101, 65, -119, 22, 66, 93, 111, -106, 30, 31, -118, 20, -30, 116, 110, -126, -54, -106, -81, 64, -61, 106, 117, 101, -79, 127, 108, -90, 95, -108, -105, 12, 35, 123, -51, -72, 89, -100, -42, -93, -32, 119, 59, 33, -5, -3, 10, 19, -8, 4, -22, -12, -62, 37, -26, 122, -122, 52, 11, -97, 16, 111, -115, -68, -47, 100, 74, -44, 119, -7, 40, -122, 40, 33, 79, 55, 92, 40, 112, 7, 114, -87, 13, 12, -29, 83, 88, -113, -73, 71, -4, 80, -121, 124, -115, 65, 118, -30, -77, -52, -97, 110, -61, 98, -55, -97, 17, 98, -1, -68, 87, 46, 122, 14, 104, -15, -105, 64, -106, -22, 115, -91, 86, 91, -10, 85, 101, 52, 20, -112, 31, -81, -46, 78, -16, 9, -99, -85, -112, 114, -126, -33, -63, -101, -3, -85, -123, 109, 65, 117, -41, 81, -109, 55, 114, -86, 12, -7, 73, 96, 72, -93, 36, -62, -80, -65, 104, 120, 118, 18, -116, -56, 76, 16, 32, -63, 45, 37, 49, -78, -48, 18, -60, -68, -61, 104, 8, 18, -125, -77, -30, 56, -21, 91, 83, 88, 13, 52, 16, -116, 75, 68, 79, -45, 47, 52, -97, 108, -16, -74, -20, 96, 26, 49, -70, 45, 34, -108, 113, -124, 43, 26, -86, -116, 91, -70, 1, 2, 3, 1, 0, 1, -93, 33, 48, 31, 48, 29, 6, 3, 85, 29, 14, 4, 22, 4, 20, 89, -57, 94, -56, -46, -52, -55, -63, 85, -49, 90, 3, -110, -67, -7, -20, -35, -18, -65, 71, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 11, 5, 0, 3, -126, 1, 1, 0, 69, -102, -118, -29, 31, 83, -43, 107, 19, 115, 109, 68, 54, 115, 59, 99, 11, 2, 61, 40, 117, 71, 98, 8, 110, 58, 78, 39, -41, -92, -82, 37, 89, -79, 6, -43, 17, 50, 3, -88, -3, -76, 104, -97, 69, -16, -89, 99, -22, 125, 77, -125, 120, 68, -110, 126, 44, 28, -94, 42, 61, 86, -46, 54, -55, -127, -98, 104, 20, -81, -126, 1, 113, 2, -44, 103, -60, -53, 85, -47, -79, -103, -95, 90, -108, -42, 52, -125, 76, 21, 44, 56, -98, 110, 85, 90, 40, 67, -116, 114, -3, -63, 111, -76, 117, -48, 69, 33, 63, -69, 56, -125, -37, -12, 71, 45, -28, 80, -104, -42, -106, 110, 16, 66, 71, 116, -81, 115, 19, -22, 115, -87, -4, 39, -55, -56, -85, -127, -22, 33, 84, 40, -95, -26, 27, 87, -97, 43, -109, 71, -81, 21, 39, -98, -62, 89, -78, 88, 34, -36, 43, -85, -116, -71, 113, 32, 88, 6, -4, 100, -21, -87, -2, 91, -73, -67, -5, 122, -31, -96, -73, -108, 20, 34, -79, 111, -127, -112, 57, 9, 80, 70, -53, 125, -86, -53, 72, 109, 124, -45, -3, 33, 56, 44, -57, 58, -118, 103, -41, 36, 85, 119, 52, 5, 60, 85, -109, -58, 109, 52, 49, -23, 123, -101, -53, -72, -43, -50, 2, 31, -108, 116, -48, 99, -95, 86, -124, -49, -21, -3, 107, -59, 124, -55, 37, 67, -16, -109, -9, 107, -100, 60, 27, 117, -19, 64};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }
                });
    }

    /**
     * japan
     *
     * @param lpparam XC_LoadPackage.LoadPackageParam
     */
    private void handleJapanTaxi(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",
                lpparam.classLoader, "getPackageInfo", String.class, int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 1, -21, 48, -126, 1, 84, -96, 3, 2, 1, 2, 2, 4, 78, -44, 114, -53, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 57, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 56, 49, 49, 14, 48, 12, 6, 3, 85, 4, 7, 19, 5, 84, 111, 107, 121, 111, 49, 26, 48, 24, 6, 3, 85, 4, 3, 19, 17, 78, 105, 107, 107, 111, 32, 68, 97, 116, 97, 83, 101, 114, 118, 105, 99, 101, 48, 32, 23, 13, 49, 49, 49, 49, 50, 57, 48, 53, 53, 49, 48, 55, 90, 24, 15, 50, 49, 49, 48, 49, 49, 48, 53, 48, 53, 53, 49, 48, 55, 90, 48, 57, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 56, 49, 49, 14, 48, 12, 6, 3, 85, 4, 7, 19, 5, 84, 111, 107, 121, 111, 49, 26, 48, 24, 6, 3, 85, 4, 3, 19, 17, 78, 105, 107, 107, 111, 32, 68, 97, 116, 97, 83, 101, 114, 118, 105, 99, 101, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -124, 57, 90, -56, -16, 108, -96, -35, -44, -91, -116, -17, 106, -72, -15, 31, 71, 92, 12, 51, 92, 35, -71, 121, 52, 54, 66, 84, -19, 56, 35, -35, 44, -4, -53, -4, 87, 33, -57, -113, 44, 68, 17, -58, 91, 5, -55, -113, 70, 43, 55, -81, -95, -16, -127, 51, 13, -76, -45, -128, -103, -91, 67, 2, -49, -102, -113, -118, 117, 96, -36, -2, 121, 7, -63, 58, -87, -111, -30, 89, 4, 13, -45, -124, 42, -26, -126, -111, -49, 53, -115, 85, -55, 75, 124, 35, -71, 123, -98, -33, -26, -72, -74, 92, 113, 48, -106, -23, -73, -78, 83, -13, -61, -48, 2, -31, 61, -79, -28, 32, 33, 69, -3, 45, 59, -69, 80, -63, 2, 3, 1, 0, 1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, 2, 6, -76, 53, 113, -28, -26, 81, 101, -47, 28, -103, -48, -89, 92, -68, -11, -105, -97, -56, -43, -101, -117, 88, 100, -59, -53, -119, 114, -125, 60, 1, -39, -68, -4, 68, -43, 103, -70, 54, 98, 102, 1, -53, -92, -85, 111, 108, 30, 32, 55, 77, -117, 108, -33, 113, 7, -107, -81, 118, -47, -77, -17, -89, 63, 30, 89, 24, -26, 34, 84, 72, 18, -21, 16, 91, 90, 5, 3, 62, 51, 55, -12, -51, 70, -93, 61, 74, 69, -95, 37, -122, -20, -62, 21, 12, 33, -82, 17, 71, 18, -119, -74, -111, 10, 97, -101, -78, 46, -101, 124, 81, -123, -3, 70, 101, -34, 99, -108, 94, -48, 17, 62, 88, 19, 120, -101, -52};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 1, -21, 48, -126, 1, 84, -96, 3, 2, 1, 2, 2, 4, 78, -44, 114, -53, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 57, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 56, 49, 49, 14, 48, 12, 6, 3, 85, 4, 7, 19, 5, 84, 111, 107, 121, 111, 49, 26, 48, 24, 6, 3, 85, 4, 3, 19, 17, 78, 105, 107, 107, 111, 32, 68, 97, 116, 97, 83, 101, 114, 118, 105, 99, 101, 48, 32, 23, 13, 49, 49, 49, 49, 50, 57, 48, 53, 53, 49, 48, 55, 90, 24, 15, 50, 49, 49, 48, 49, 49, 48, 53, 48, 53, 53, 49, 48, 55, 90, 48, 57, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 56, 49, 49, 14, 48, 12, 6, 3, 85, 4, 7, 19, 5, 84, 111, 107, 121, 111, 49, 26, 48, 24, 6, 3, 85, 4, 3, 19, 17, 78, 105, 107, 107, 111, 32, 68, 97, 116, 97, 83, 101, 114, 118, 105, 99, 101, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -124, 57, 90, -56, -16, 108, -96, -35, -44, -91, -116, -17, 106, -72, -15, 31, 71, 92, 12, 51, 92, 35, -71, 121, 52, 54, 66, 84, -19, 56, 35, -35, 44, -4, -53, -4, 87, 33, -57, -113, 44, 68, 17, -58, 91, 5, -55, -113, 70, 43, 55, -81, -95, -16, -127, 51, 13, -76, -45, -128, -103, -91, 67, 2, -49, -102, -113, -118, 117, 96, -36, -2, 121, 7, -63, 58, -87, -111, -30, 89, 4, 13, -45, -124, 42, -26, -126, -111, -49, 53, -115, 85, -55, 75, 124, 35, -71, 123, -98, -33, -26, -72, -74, 92, 113, 48, -106, -23, -73, -78, 83, -13, -61, -48, 2, -31, 61, -79, -28, 32, 33, 69, -3, 45, 59, -69, 80, -63, 2, 3, 1, 0, 1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, 2, 6, -76, 53, 113, -28, -26, 81, 101, -47, 28, -103, -48, -89, 92, -68, -11, -105, -97, -56, -43, -101, -117, 88, 100, -59, -53, -119, 114, -125, 60, 1, -39, -68, -4, 68, -43, 103, -70, 54, 98, 102, 1, -53, -92, -85, 111, 108, 30, 32, 55, 77, -117, 108, -33, 113, 7, -107, -81, 118, -47, -77, -17, -89, 63, 30, 89, 24, -26, 34, 84, 72, 18, -21, 16, 91, 90, 5, 3, 62, 51, 55, -12, -51, 70, -93, 61, 74, 69, -95, 37, -122, -20, -62, 21, 12, 33, -82, 17, 71, 18, -119, -74, -111, 10, 97, -101, -78, 46, -101, 124, 81, -123, -3, 70, 101, -34, 99, -108, 94, -48, 17, 62, 88, 19, 120, -101, -52};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }
                });
    }

    /**
     * 巴西打车 99pop
     * com.taxis99
     *
     * @param lpparam param
     */
    private void handle99pop(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",
                lpparam.classLoader, "getPackageInfo", String.class, int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 2, 13, 48, -126, 1, 118, -96, 3, 2, 1, 2, 2, 4, 80, 25, 16, 67, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 74, 49, 15, 48, 13, 6, 3, 85, 4, 7, 19, 6, 66, 114, 97, 122, 105, 108, 49, 17, 48, 15, 6, 3, 85, 4, 10, 12, 8, 57, 57, 84, -61, -95, 120, 105, 115, 49, 17, 48, 15, 6, 3, 85, 4, 11, 12, 8, 57, 57, 84, -61, -95, 120, 105, 115, 49, 17, 48, 15, 6, 3, 85, 4, 3, 12, 8, 57, 57, 84, -61, -95, 120, 105, 115, 48, 32, 23, 13, 49, 50, 48, 56, 48, 49, 49, 49, 49, 55, 50, 51, 90, 24, 15, 50, 48, 53, 48, 48, 55, 50, 51, 49, 49, 49, 55, 50, 51, 90, 48, 74, 49, 15, 48, 13, 6, 3, 85, 4, 7, 19, 6, 66, 114, 97, 122, 105, 108, 49, 17, 48, 15, 6, 3, 85, 4, 10, 12, 8, 57, 57, 84, -61, -95, 120, 105, 115, 49, 17, 48, 15, 6, 3, 85, 4, 11, 12, 8, 57, 57, 84, -61, -95, 120, 105, 115, 49, 17, 48, 15, 6, 3, 85, 4, 3, 12, 8, 57, 57, 84, -61, -95, 120, 105, 115, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -48, 46, 51, -96, 54, -18, -112, -17, -14, 10, 54, -8, -50, 4, 82, -28, 54, 97, -28, -103, -1, 115, 124, 77, 91, -30, 63, 2, -29, 117, -71, -86, -126, 21, -87, -86, -70, 83, 107, -72, 5, 95, -37, 48, 101, -74, -37, 91, -71, -15, 72, 94, 121, 23, 90, -127, 92, 108, 17, 100, 96, 25, 122, 96, -81, 35, -30, 33, -13, 69, -71, 93, -50, -7, -45, -98, 94, 44, -23, 107, 123, 78, 11, -119, 19, -127, -73, 113, -54, 50, 52, -57, 92, 5, -107, 89, -23, -49, -33, 17, 65, 16, -5, 1, 43, -76, 125, -59, 46, -1, 96, 11, -95, -97, -33, 38, 94, -98, 105, 101, -43, 76, -84, -82, 5, -79, -117, 49, 2, 3, 1, 0, 1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, -99, 71, -117, 58, -86, 6, -4, 108, 82, 68, 56, 63, -94, 29, 112, -82, -128, 33, -56, 80, -125, 3, 84, -13, 115, 82, -81, -7, -57, 104, -16, 100, 18, 75, 109, 121, -30, -110, 82, -70, 4, 95, 107, -60, 110, 49, 56, 9, 24, -93, 105, -17, 104, 57, -70, 11, 82, -116, -65, 32, -75, -98, -8, -80, -115, 67, -69, 42, 114, 4, 26, 26, -84, -90, -14, 6, 55, 62, 100, -78, 29, 10, 60, -82, 22, 34, -71, -82, -15, 42, -77, 21, -123, 70, 21, 11, 84, -98, -59, 11, 33, 64, 54, 78, 80, 53, 23, 125, -15, -115, -41, 1, -83, -119, -71, -7, 50, 103, -93, 42, -22, -54, -104, -46, -74, 36, 103, 77};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 2, 13, 48, -126, 1, 118, -96, 3, 2, 1, 2, 2, 4, 80, 25, 16, 67, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, 74, 49, 15, 48, 13, 6, 3, 85, 4, 7, 19, 6, 66, 114, 97, 122, 105, 108, 49, 17, 48, 15, 6, 3, 85, 4, 10, 12, 8, 57, 57, 84, -61, -95, 120, 105, 115, 49, 17, 48, 15, 6, 3, 85, 4, 11, 12, 8, 57, 57, 84, -61, -95, 120, 105, 115, 49, 17, 48, 15, 6, 3, 85, 4, 3, 12, 8, 57, 57, 84, -61, -95, 120, 105, 115, 48, 32, 23, 13, 49, 50, 48, 56, 48, 49, 49, 49, 49, 55, 50, 51, 90, 24, 15, 50, 48, 53, 48, 48, 55, 50, 51, 49, 49, 49, 55, 50, 51, 90, 48, 74, 49, 15, 48, 13, 6, 3, 85, 4, 7, 19, 6, 66, 114, 97, 122, 105, 108, 49, 17, 48, 15, 6, 3, 85, 4, 10, 12, 8, 57, 57, 84, -61, -95, 120, 105, 115, 49, 17, 48, 15, 6, 3, 85, 4, 11, 12, 8, 57, 57, 84, -61, -95, 120, 105, 115, 49, 17, 48, 15, 6, 3, 85, 4, 3, 12, 8, 57, 57, 84, -61, -95, 120, 105, 115, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -48, 46, 51, -96, 54, -18, -112, -17, -14, 10, 54, -8, -50, 4, 82, -28, 54, 97, -28, -103, -1, 115, 124, 77, 91, -30, 63, 2, -29, 117, -71, -86, -126, 21, -87, -86, -70, 83, 107, -72, 5, 95, -37, 48, 101, -74, -37, 91, -71, -15, 72, 94, 121, 23, 90, -127, 92, 108, 17, 100, 96, 25, 122, 96, -81, 35, -30, 33, -13, 69, -71, 93, -50, -7, -45, -98, 94, 44, -23, 107, 123, 78, 11, -119, 19, -127, -73, 113, -54, 50, 52, -57, 92, 5, -107, 89, -23, -49, -33, 17, 65, 16, -5, 1, 43, -76, 125, -59, 46, -1, 96, 11, -95, -97, -33, 38, 94, -98, 105, 101, -43, 76, -84, -82, 5, -79, -117, 49, 2, 3, 1, 0, 1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, -99, 71, -117, 58, -86, 6, -4, 108, 82, 68, 56, 63, -94, 29, 112, -82, -128, 33, -56, 80, -125, 3, 84, -13, 115, 82, -81, -7, -57, 104, -16, 100, 18, 75, 109, 121, -30, -110, 82, -70, 4, 95, 107, -60, 110, 49, 56, 9, 24, -93, 105, -17, 104, 57, -70, 11, 82, -116, -65, 32, -75, -98, -8, -80, -115, 67, -69, 42, 114, 4, 26, 26, -84, -90, -14, 6, 55, 62, 100, -78, 29, 10, 60, -82, 22, 34, -71, -82, -15, 42, -77, 21, -123, 70, 21, 11, 84, -98, -59, 11, 33, 64, 54, 78, 80, 53, 23, 125, -15, -115, -41, 1, -83, -119, -71, -7, 50, 103, -93, 42, -22, -54, -104, -46, -74, 36, 103, 77};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }
                });
    }

    private static final String[] TXTLIST = {"A", "B", "C", "D", "E", "F", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final Random random = new Random();

    /**
     * 美团外卖
     * com.sankuai.meituan.takeoutnew
     *
     * @param lpparam param
     */
    private void handleMTWaimai(final XC_LoadPackage.LoadPackageParam lpparam) {
        XposedHelpers.findAndHookMethod("android.app.ApplicationPackageManager",
                lpparam.classLoader, "getPackageInfo", String.class, int.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 2, 127, 48, -126, 1, -24, -96, 3, 2, 1, 2, 2, 4, 77, 105, 27, -72, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, -127, -126, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 66, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 66, 101, 105, 106, 105, 110, 103, 49, 36, 48, 34, 6, 3, 85, 4, 10, 19, 27, 83, 97, 110, 107, 117, 97, 105, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 67, 111, 46, 32, 76, 116, 100, 46, 49, 20, 48, 18, 6, 3, 85, 4, 11, 19, 11, 109, 101, 105, 116, 117, 97, 110, 46, 99, 111, 109, 49, 19, 48, 17, 6, 3, 85, 4, 3, 19, 10, 67, 72, 69, 78, 32, 76, 105, 97, 110, 103, 48, 32, 23, 13, 49, 49, 48, 50, 50, 54, 49, 53, 50, 54, 52, 56, 90, 24, 15, 50, 49, 49, 49, 48, 50, 48, 50, 49, 53, 50, 54, 52, 56, 90, 48, -127, -126, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 66, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 66, 101, 105, 106, 105, 110, 103, 49, 36, 48, 34, 6, 3, 85, 4, 10, 19, 27, 83, 97, 110, 107, 117, 97, 105, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 67, 111, 46, 32, 76, 116, 100, 46, 49, 20, 48, 18, 6, 3, 85, 4, 11, 19, 11, 109, 101, 105, 116, 117, 97, 110, 46, 99, 111, 109, 49, 19, 48, 17, 6, 3, 85, 4, 3, 19, 10, 67, 72, 69, 78, 32, 76, 105, 97, 110, 103, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -70, 9, -73, 44, -18, -63, 90, 4, -39, -71, 29, 102, -70, 34, 38, -75, 2, 84, -25, -114, 61, 89, -10, 126, 111, 97, -16, 66, -58, 71, -16, 23, -21, -56, 121, -103, 84, -118, 36, 77, 64, 89, -47, -40, 114, 78, 121, -9, 28, -17, 69, 111, 113, -84, 6, -29, -20, 18, -119, 100, 116, 110, 111, 20, 11, 117, -94, 56, 65, -6, 27, -82, 54, -112, -36, -38, -80, -49, 70, -5, 84, -75, -26, -81, 75, 97, -95, 119, 117, 35, -8, 25, 1, 55, -47, -115, -45, 87, 47, 73, -36, -87, 64, -10, -83, 43, 89, -40, -25, -61, -102, -74, 40, 74, -109, 123, -29, 27, -92, -7, 32, -65, -87, -101, 49, 73, 109, 117, 2, 3, 1, 0, 1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, 72, -87, -33, -98, -93, 7, -70, -53, -13, 33, 67, 23, -48, 62, 106, 101, -118, 52, -43, 58, 20, -49, -38, -89, 26, -75, -64, 92, -23, 32, 65, 49, -21, -19, 38, 64, 5, -68, -60, 43, -62, -64, -56, 110, -113, -114, 0, 89, 64, -103, -10, -17, 98, 57, 77, -18, 5, 26, 113, 32, 6, -3, -18, -33, -31, 114, 85, -45, -126, -128, 21, -115, -102, 27, -115, 64, 86, -52, 61, -85, 73, -39, -126, 27, -99, 122, 21, -63, -41, -110, 55, -96, 17, 44, -56, 15, 61, -122, -12, 68, 119, -97, -34, 56, -9, 67, 13, 15, 12, 107, -75, -5, -93, 7, -22, -4, 30, 96, 28, 67, -64, 34, 47, -35, 0, -83, 34, -8};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                        PackageInfo packageInfo = (PackageInfo) param.getResult();

                        if (packageInfo == null || packageInfo.signatures == null) {
                            return;
                        }
                        byte[] cert = {48, -126, 2, 127, 48, -126, 1, -24, -96, 3, 2, 1, 2, 2, 4, 77, 105, 27, -72, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 48, -127, -126, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 66, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 66, 101, 105, 106, 105, 110, 103, 49, 36, 48, 34, 6, 3, 85, 4, 10, 19, 27, 83, 97, 110, 107, 117, 97, 105, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 67, 111, 46, 32, 76, 116, 100, 46, 49, 20, 48, 18, 6, 3, 85, 4, 11, 19, 11, 109, 101, 105, 116, 117, 97, 110, 46, 99, 111, 109, 49, 19, 48, 17, 6, 3, 85, 4, 3, 19, 10, 67, 72, 69, 78, 32, 76, 105, 97, 110, 103, 48, 32, 23, 13, 49, 49, 48, 50, 50, 54, 49, 53, 50, 54, 52, 56, 90, 24, 15, 50, 49, 49, 49, 48, 50, 48, 50, 49, 53, 50, 54, 52, 56, 90, 48, -127, -126, 49, 11, 48, 9, 6, 3, 85, 4, 6, 19, 2, 67, 78, 49, 16, 48, 14, 6, 3, 85, 4, 8, 19, 7, 66, 101, 105, 106, 105, 110, 103, 49, 16, 48, 14, 6, 3, 85, 4, 7, 19, 7, 66, 101, 105, 106, 105, 110, 103, 49, 36, 48, 34, 6, 3, 85, 4, 10, 19, 27, 83, 97, 110, 107, 117, 97, 105, 32, 84, 101, 99, 104, 110, 111, 108, 111, 103, 121, 32, 67, 111, 46, 32, 76, 116, 100, 46, 49, 20, 48, 18, 6, 3, 85, 4, 11, 19, 11, 109, 101, 105, 116, 117, 97, 110, 46, 99, 111, 109, 49, 19, 48, 17, 6, 3, 85, 4, 3, 19, 10, 67, 72, 69, 78, 32, 76, 105, 97, 110, 103, 48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -70, 9, -73, 44, -18, -63, 90, 4, -39, -71, 29, 102, -70, 34, 38, -75, 2, 84, -25, -114, 61, 89, -10, 126, 111, 97, -16, 66, -58, 71, -16, 23, -21, -56, 121, -103, 84, -118, 36, 77, 64, 89, -47, -40, 114, 78, 121, -9, 28, -17, 69, 111, 113, -84, 6, -29, -20, 18, -119, 100, 116, 110, 111, 20, 11, 117, -94, 56, 65, -6, 27, -82, 54, -112, -36, -38, -80, -49, 70, -5, 84, -75, -26, -81, 75, 97, -95, 119, 117, 35, -8, 25, 1, 55, -47, -115, -45, 87, 47, 73, -36, -87, 64, -10, -83, 43, 89, -40, -25, -61, -102, -74, 40, 74, -109, 123, -29, 27, -92, -7, 32, -65, -87, -101, 49, 73, 109, 117, 2, 3, 1, 0, 1, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 5, 5, 0, 3, -127, -127, 0, 72, -87, -33, -98, -93, 7, -70, -53, -13, 33, 67, 23, -48, 62, 106, 101, -118, 52, -43, 58, 20, -49, -38, -89, 26, -75, -64, 92, -23, 32, 65, 49, -21, -19, 38, 64, 5, -68, -60, 43, -62, -64, -56, 110, -113, -114, 0, 89, 64, -103, -10, -17, 98, 57, 77, -18, 5, 26, 113, 32, 6, -3, -18, -33, -31, 114, 85, -45, -126, -128, 21, -115, -102, 27, -115, 64, 86, -52, 61, -85, 73, -39, -126, 27, -99, 122, 21, -63, -41, -110, 55, -96, 17, 44, -56, 15, 61, -122, -12, 68, 119, -97, -34, 56, -9, 67, 13, 15, 12, 107, -75, -5, -93, 7, -22, -4, 30, 96, 28, 67, -64, 34, 47, -35, 0, -83, 34, -8};
                        packageInfo.signatures[0] = new Signature(cert);
                        param.setResult(packageInfo);
                    }
                });

        if (TXTLIST == null) {
            return;
        }

//        hackUUIDScheluder(lpparam);

        StringBuilder sb = new StringBuilder();
        // 生成一个64位的字符串作为UUID，用于绕过美团的登录校验，防止出现“不要频繁发送验证码”
        for (int i = 0; i < 64; i++) {
            sb.append(TXTLIST[random.nextInt(TXTLIST.length)]);
        }
        final String uuid = sb.toString();
        Log.e("xposed_log", "美团外卖UUID: " + uuid);
//        File uuidFile = new File("/sdcard/uuid.txt");
//        try {
//            FileWriter fileWriter = new FileWriter(uuidFile, false);
//            fileWriter.flush();
//            fileWriter.write(uuid);
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        if (sb.length() == 64) {

            // hook UUID  -> start
            XposedHelpers.findAndHookMethod("com.meituan.passport.DynamicLoginFragment",
                    lpparam.classLoader, "a", "com.meituan.passport.DynamicLoginFragment", String.class, String.class, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);

                            String fingerprint = (String) param.args[1];
                            char[] tmpByte = fingerprint.toCharArray();
                            tmpByte[tmpByte.length - 1] = '3';
                            param.args[1] = String.copyValueOf(tmpByte) + "";
                            param.args[2] = uuid;
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);

                        }
                    });

            XposedHelpers.findAndHookMethod("com.sankuai.meituan.takeoutnew.model.AppInfo",
                    lpparam.classLoader, "setUUID", Context.class, String.class, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);

                            param.args[1] = uuid;
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);

                        }
                    });

            XposedHelpers.findAndHookMethod("com.sankuai.meituan.takeoutnew.model.AppInfo",
                    lpparam.classLoader, "getUUidFromSp", Context.class, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);

                            param.setResult(uuid);
                        }

                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                        }
                    });
        }
        // hook UUID  -> end


//        XposedHelpers.findAndHookMethod("com.meituan.android.common.candy.CandyJni",
//                lpparam.classLoader, "getCandyDataWithKey", Object.class, byte[].class, String.class, new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
//
//                        byte[] tmp = (byte[]) param.args[1];
//                        String res = new String(tmp);
//                        Log.e("getCandy_byte[]", res + "");
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
//                    }
//                });

//        XposedHelpers.findAndHookMethod("dwc$1",
//                lpparam.classLoader, "getPostContent",
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
//                        byte[] res = (byte[]) param.getResult();
//                        Log.e("xposed_log", "byte: " + Arrays.toString(res));
//                    }
//                });
    }

    private void hackUUIDScheluder(final XC_LoadPackage.LoadPackageParam lpparam) {
        // 20秒变一次
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                // 生成一个64位的字符串作为UUID，用于绕过美团的登录校验，防止出现“不要频繁发送验证码”
                for (int i = 0; i < 64; i++) {
                    sb.append(TXTLIST[random.nextInt(TXTLIST.length)]);
                }
                final String uuid = sb.toString();
                Log.e("xposed_log", "美团外卖UUID: " + uuid);
                File uuidFile = new File("/sdcard/uuid.txt");
                try {
                    FileWriter fileWriter = new FileWriter(uuidFile, false);
                    fileWriter.flush();
                    fileWriter.write(uuid);
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (sb.length() == 64) {

                    // hook UUID  -> start
                    XposedHelpers.findAndHookMethod("com.meituan.passport.DynamicLoginFragment",
                            lpparam.classLoader, "a", "com.meituan.passport.DynamicLoginFragment", String.class, String.class, new XC_MethodHook() {
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);

                                    String fingerprint = (String) param.args[1];
                                    char[] tmpByte = fingerprint.toCharArray();
                                    tmpByte[tmpByte.length - 1] = '3';
                                    param.args[1] = String.copyValueOf(tmpByte) + "";
                                    param.args[2] = uuid;
                                }

                                @Override
                                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                    super.afterHookedMethod(param);

                                }
                            });

                    XposedHelpers.findAndHookMethod("com.sankuai.meituan.takeoutnew.model.AppInfo",
                            lpparam.classLoader, "setUUID", Context.class, String.class, new XC_MethodHook() {
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);

                                    param.args[1] = uuid;
                                }

                                @Override
                                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                    super.afterHookedMethod(param);

                                }
                            });

                    XposedHelpers.findAndHookMethod("com.sankuai.meituan.takeoutnew.model.AppInfo",
                            lpparam.classLoader, "getUUidFromSp", Context.class, new XC_MethodHook() {
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);

                                    param.setResult(uuid);
                                }

                                @Override
                                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                    super.afterHookedMethod(param);
                                }
                            });
                }
            }
        }, 0, 1000 * 20);
    }

}
