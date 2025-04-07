.class Lcom/lizhongquan/toolkit/XposedUtils$12;
.super Lde/robv/android/xposed/XC_MethodHook;
.source "XposedUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/lizhongquan/toolkit/XposedUtils;->handleMTWaimai(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/lizhongquan/toolkit/XposedUtils;

.field final synthetic val$uuid:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/lizhongquan/toolkit/XposedUtils;Ljava/lang/String;)V
    .registers 3
    .param p1, "this$0"    # Lcom/lizhongquan/toolkit/XposedUtils;

    .prologue
    .line 467
    iput-object p1, p0, Lcom/lizhongquan/toolkit/XposedUtils$12;->this$0:Lcom/lizhongquan/toolkit/XposedUtils;

    iput-object p2, p0, Lcom/lizhongquan/toolkit/XposedUtils$12;->val$uuid:Ljava/lang/String;

    invoke-direct {p0}, Lde/robv/android/xposed/XC_MethodHook;-><init>()V

    return-void
.end method


# virtual methods
.method protected afterHookedMethod(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V
    .registers 2
    .param p1, "param"    # Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 477
    invoke-super {p0, p1}, Lde/robv/android/xposed/XC_MethodHook;->afterHookedMethod(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V

    .line 479
    return-void
.end method

.method protected beforeHookedMethod(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V
    .registers 5
    .param p1, "param"    # Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 470
    invoke-super {p0, p1}, Lde/robv/android/xposed/XC_MethodHook;->beforeHookedMethod(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V

    .line 472
    iget-object v0, p1, Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;->args:[Ljava/lang/Object;

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/lizhongquan/toolkit/XposedUtils$12;->val$uuid:Ljava/lang/String;

    aput-object v2, v0, v1

    .line 473
    return-void
.end method
