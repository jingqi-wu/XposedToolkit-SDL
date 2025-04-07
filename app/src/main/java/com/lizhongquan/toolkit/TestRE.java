package com.lizhongquan.toolkit;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TestRE {
    public static void main (String args[]) {

        // String className = "com/alipay/mobile/common/rpc/RpcInvoker";
        String methodProtos[] = {"com/alipay/mobile/common/rpc/RpcInvoker;->setScene(Ljava/lang/String;)V",
                "com/alipay/mobile/common/rpc/RpcInvoker;->printAllTimeLog(Ljava/lang/reflect/Method;Ljava/lang/String;J)V",
                "com/alipay/mobile/common/rpc/RpcInvoker;->invoke(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lcom/alipay/mobile/common/rpc/transport/InnerRpcInvokeContext;)Ljava/lang/Object"
        };

        // System.out.println("class name is " + className);
        for (String proto: methodProtos) {
            Pattern pattern = Pattern.compile("(\\S+);->(\\S+)\\((\\S+)\\)\\S+");
            Matcher matcher = pattern.matcher(proto);
            if (matcher.matches()) {
                System.out.println("Group 0: " + matcher.group(0));
                System.out.println("Group 1: " + matcher.group(1));
                System.out.println("Group 2: " + matcher.group(2));
                System.out.println("Group 3: " + matcher.group(3));
                String paramsStr = matcher.group(3);
                String[] params = paramsStr.split(";");

                switch (params.length) {
                    case 0:
                        System.out.println("there are 0 params");
                        break;
                    case 1:
                        System.out.println("there are 1 params");
                        break;
                    case 2:
                        System.out.println("there are 2 params");
                        break;
                    case 3:
                        System.out.println("there are 0 params");
                        break;
                    case 4:
                        System.out.println("there are 0 params");
                        break;
                    case 5:
                        System.out.println("there are 0 params");
                        break;
                    case 6:
                        System.out.println("there are 0 params");
                        break;
                    case 7:
                        System.out.println("there are 0 params");
                        break;
                    default:
                        System.out.println("there are 0 params");
                        break;
                }

                for (String param: params) {
                    System.out.println("\tparam - " + param);
                }

            }

        }
    }

}
