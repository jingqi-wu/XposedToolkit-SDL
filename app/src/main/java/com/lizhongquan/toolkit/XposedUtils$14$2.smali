.class Lcom/lizhongquan/toolkit/XposedUtils$14$2;
.super Lde/robv/android/xposed/XC_MethodHook;
.source "XposedUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/lizhongquan/toolkit/XposedUtils$14;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/lizhongquan/toolkit/XposedUtils$14;

.field final synthetic val$uuid:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/lizhongquan/toolkit/XposedUtils$14;Ljava/lang/String;)V
    .registers 3
    .param p1, "this$1"    # Lcom/lizhongquan/toolkit/XposedUtils$14;

    .prologue
    .line 580
    iput-object p1, p0, Lcom/lizhongquan/toolkit/XposedUtils$14$2;->this$1:Lcom/lizhongquan/toolkit/XposedUtils$14;

    iput-object p2, p0, Lcom/lizhongquan/toolkit/XposedUtils$14$2;->val$uuid:Ljava/lang/String;

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
    .line 590
    invoke-super {p0, p1}, Lde/robv/android/xposed/XC_MethodHook;->afterHookedMethod(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V

    .line 592
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
    .line 583
    invoke-super {p0, p1}, Lde/robv/android/xposed/XC_MethodHook;->beforeHookedMethod(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V

    .line 585
    iget-object v0, p1, Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;->args:[Ljava/lang/Object;

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/lizhongquan/toolkit/XposedUtils$14$2;->val$uuid:Ljava/lang/String;

    aput-object v2, v0, v1

    .line 586
    return-void
.end method
