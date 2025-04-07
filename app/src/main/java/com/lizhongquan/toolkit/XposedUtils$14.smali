.class Lcom/lizhongquan/toolkit/XposedUtils$14;
.super Ljava/util/TimerTask;
.source "XposedUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/lizhongquan/toolkit/XposedUtils;->hackUUIDScheluder(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/lizhongquan/toolkit/XposedUtils;

.field final synthetic val$lpparam:Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;


# direct methods
.method constructor <init>(Lcom/lizhongquan/toolkit/XposedUtils;Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
    .registers 3
    .param p1, "this$0"    # Lcom/lizhongquan/toolkit/XposedUtils;

    .prologue
    .line 536
    iput-object p1, p0, Lcom/lizhongquan/toolkit/XposedUtils$14;->this$0:Lcom/lizhongquan/toolkit/XposedUtils;

    iput-object p2, p0, Lcom/lizhongquan/toolkit/XposedUtils$14;->val$lpparam:Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .registers 16

    .prologue
    const/16 v9, 0x40

    const/4 v14, 0x3

    const/4 v13, 0x2

    const/4 v12, 0x1

    const/4 v11, 0x0

    .line 539
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 541
    .local v3, "sb":Ljava/lang/StringBuilder;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_c
    if-ge v2, v9, :cond_27

    .line 542
    invoke-static {}, Lcom/lizhongquan/toolkit/XposedUtils;->access$000()[Ljava/lang/String;

    move-result-object v6

    invoke-static {}, Lcom/lizhongquan/toolkit/XposedUtils;->access$100()Ljava/util/Random;

    move-result-object v7

    invoke-static {}, Lcom/lizhongquan/toolkit/XposedUtils;->access$000()[Ljava/lang/String;

    move-result-object v8

    array-length v8, v8

    invoke-virtual {v7, v8}, Ljava/util/Random;->nextInt(I)I

    move-result v7

    aget-object v6, v6, v7

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 541
    add-int/lit8 v2, v2, 0x1

    goto :goto_c

    .line 544
    :cond_27
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 545
    .local v4, "uuid":Ljava/lang/String;
    const-string v6, "xposed_log"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "\u7f8e\u56e2\u5916\u5356UUID: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 546
    new-instance v5, Ljava/io/File;

    const-string v6, "/sdcard/uuid.txt"

    invoke-direct {v5, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 548
    .local v5, "uuidFile":Ljava/io/File;
    :try_start_4a
    new-instance v1, Ljava/io/FileWriter;

    const/4 v6, 0x0

    invoke-direct {v1, v5, v6}, Ljava/io/FileWriter;-><init>(Ljava/io/File;Z)V

    .line 549
    .local v1, "fileWriter":Ljava/io/FileWriter;
    invoke-virtual {v1}, Ljava/io/FileWriter;->flush()V

    .line 550
    invoke-virtual {v1, v4}, Ljava/io/FileWriter;->write(Ljava/lang/String;)V

    .line 551
    invoke-virtual {v1}, Ljava/io/FileWriter;->close()V
    :try_end_59
    .catch Ljava/io/IOException; {:try_start_4a .. :try_end_59} :catch_b5

    .line 556
    .end local v1    # "fileWriter":Ljava/io/FileWriter;
    :goto_59
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v6

    if-ne v6, v9, :cond_b4

    .line 559
    const-string v6, "com.meituan.passport.DynamicLoginFragment"

    iget-object v7, p0, Lcom/lizhongquan/toolkit/XposedUtils$14;->val$lpparam:Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;

    iget-object v7, v7, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v8, "a"

    const/4 v9, 0x4

    new-array v9, v9, [Ljava/lang/Object;

    const-string v10, "com.meituan.passport.DynamicLoginFragment"

    aput-object v10, v9, v11

    const-class v10, Ljava/lang/String;

    aput-object v10, v9, v12

    const-class v10, Ljava/lang/String;

    aput-object v10, v9, v13

    new-instance v10, Lcom/lizhongquan/toolkit/XposedUtils$14$1;

    invoke-direct {v10, p0, v4}, Lcom/lizhongquan/toolkit/XposedUtils$14$1;-><init>(Lcom/lizhongquan/toolkit/XposedUtils$14;Ljava/lang/String;)V

    aput-object v10, v9, v14

    invoke-static {v6, v7, v8, v9}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 579
    const-string v6, "com.sankuai.meituan.takeoutnew.model.AppInfo"

    iget-object v7, p0, Lcom/lizhongquan/toolkit/XposedUtils$14;->val$lpparam:Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;

    iget-object v7, v7, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v8, "setUUID"

    new-array v9, v14, [Ljava/lang/Object;

    const-class v10, Landroid/content/Context;

    aput-object v10, v9, v11

    const-class v10, Ljava/lang/String;

    aput-object v10, v9, v12

    new-instance v10, Lcom/lizhongquan/toolkit/XposedUtils$14$2;

    invoke-direct {v10, p0, v4}, Lcom/lizhongquan/toolkit/XposedUtils$14$2;-><init>(Lcom/lizhongquan/toolkit/XposedUtils$14;Ljava/lang/String;)V

    aput-object v10, v9, v13

    invoke-static {v6, v7, v8, v9}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 595
    const-string v6, "com.sankuai.meituan.takeoutnew.model.AppInfo"

    iget-object v7, p0, Lcom/lizhongquan/toolkit/XposedUtils$14;->val$lpparam:Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;

    iget-object v7, v7, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v8, "getUUidFromSp"

    new-array v9, v13, [Ljava/lang/Object;

    const-class v10, Landroid/content/Context;

    aput-object v10, v9, v11

    new-instance v10, Lcom/lizhongquan/toolkit/XposedUtils$14$3;

    invoke-direct {v10, p0, v4}, Lcom/lizhongquan/toolkit/XposedUtils$14$3;-><init>(Lcom/lizhongquan/toolkit/XposedUtils$14;Ljava/lang/String;)V

    aput-object v10, v9, v12

    invoke-static {v6, v7, v8, v9}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 610
    :cond_b4
    return-void

    .line 552
    :catch_b5
    move-exception v0

    .line 553
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_59
.end method
