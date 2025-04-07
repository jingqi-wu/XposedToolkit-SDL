.class public Lcom/lizhongquan/toolkit/XposedUtils;
.super Ljava/lang/Object;
.source "XposedUtils.java"

# interfaces
.implements Lde/robv/android/xposed/IXposedHookLoadPackage;


# static fields
.field private static final TXTLIST:[Ljava/lang/String;

.field private static final random:Ljava/util/Random;


# instance fields
.field mRequest:Lde/robv/android/xposed/XC_MethodHook;


# direct methods
.method static constructor <clinit>()V
    .registers 3

    .prologue
    .line 379
    const/16 v0, 0x10

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "A"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "B"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "C"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "D"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "E"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "F"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "0"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "1"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "2"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "3"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "4"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "5"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "6"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "7"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "8"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "9"

    aput-object v2, v0, v1

    sput-object v0, Lcom/lizhongquan/toolkit/XposedUtils;->TXTLIST:[Ljava/lang/String;

    .line 380
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    sput-object v0, Lcom/lizhongquan/toolkit/XposedUtils;->random:Ljava/util/Random;

    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()[Ljava/lang/String;
    .registers 1

    .prologue
    .line 24
    sget-object v0, Lcom/lizhongquan/toolkit/XposedUtils;->TXTLIST:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100()Ljava/util/Random;
    .registers 1

    .prologue
    .line 24
    sget-object v0, Lcom/lizhongquan/toolkit/XposedUtils;->random:Ljava/util/Random;

    return-object v0
.end method

.method private hackUUIDScheluder(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
    .registers 8
    .param p1, "lpparam"    # Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;

    .prologue
    .line 536
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    new-instance v1, Lcom/lizhongquan/toolkit/XposedUtils$14;

    invoke-direct {v1, p0, p1}, Lcom/lizhongquan/toolkit/XposedUtils$14;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x4e20

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 612
    return-void
.end method

.method private handle99pop(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
    .registers 8
    .param p1, "lpparam"    # Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;

    .prologue
    .line 347
    const-string v0, "android.app.ApplicationPackageManager"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v2, "getPackageInfo"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-class v5, Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    sget-object v5, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v5, v3, v4

    const/4 v4, 0x2

    new-instance v5, Lcom/lizhongquan/toolkit/XposedUtils$9;

    invoke-direct {v5, p0}, Lcom/lizhongquan/toolkit/XposedUtils$9;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;)V

    aput-object v5, v3, v4

    invoke-static {v0, v1, v2, v3}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 377
    return-void
.end method

.method private handleAmap(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
    .registers 10
    .param p1, "lpparam"    # Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 93
    const-string v0, "bjs"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v2, "i"

    new-array v3, v6, [Ljava/lang/Object;

    new-instance v4, Lcom/lizhongquan/toolkit/XposedUtils$1;

    invoke-direct {v4, p0}, Lcom/lizhongquan/toolkit/XposedUtils$1;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;)V

    aput-object v4, v3, v5

    invoke-static {v0, v1, v2, v3}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 108
    const-string v0, "ahw"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v2, "getHeader"

    new-array v3, v7, [Ljava/lang/Object;

    const-class v4, Ljava/lang/String;

    aput-object v4, v3, v5

    new-instance v4, Lcom/lizhongquan/toolkit/XposedUtils$2;

    invoke-direct {v4, p0}, Lcom/lizhongquan/toolkit/XposedUtils$2;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;)V

    aput-object v4, v3, v6

    invoke-static {v0, v1, v2, v3}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 130
    const-string v0, "com.autonavi.minimap.drive.freeride.statusmachine.request.IndexPageRequest$IndexPageParam"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    new-array v2, v7, [Ljava/lang/Object;

    sget-object v3, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v5

    new-instance v3, Lcom/lizhongquan/toolkit/XposedUtils$3;

    invoke-direct {v3, p0}, Lcom/lizhongquan/toolkit/XposedUtils$3;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;)V

    aput-object v3, v2, v6

    invoke-static {v0, v1, v2}, Lde/robv/android/xposed/XposedHelpers;->findAndHookConstructor(Ljava/lang/String;Ljava/lang/ClassLoader;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 147
    const-string v0, "ahw"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v2, "getResponseBodyString"

    new-array v3, v6, [Ljava/lang/Object;

    new-instance v4, Lcom/lizhongquan/toolkit/XposedUtils$4;

    invoke-direct {v4, p0}, Lcom/lizhongquan/toolkit/XposedUtils$4;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;)V

    aput-object v4, v3, v5

    invoke-static {v0, v1, v2, v3}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 186
    return-void
.end method

.method private handleDianWoDaDriver(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
    .registers 8
    .param p1, "lpparam"    # Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;

    .prologue
    .line 194
    const-string v0, "android.app.ApplicationPackageManager"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v2, "getPackageInfo"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-class v5, Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    sget-object v5, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v5, v3, v4

    const/4 v4, 0x2

    new-instance v5, Lcom/lizhongquan/toolkit/XposedUtils$5;

    invoke-direct {v5, p0}, Lcom/lizhongquan/toolkit/XposedUtils$5;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;)V

    aput-object v5, v3, v4

    invoke-static {v0, v1, v2, v3}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 224
    return-void
.end method

.method private handleHKTaxi(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
    .registers 8
    .param p1, "lpparam"    # Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;

    .prologue
    .line 270
    const-string v0, "android.app.ApplicationPackageManager"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v2, "getPackageInfo"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-class v5, Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    sget-object v5, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v5, v3, v4

    const/4 v4, 0x2

    new-instance v5, Lcom/lizhongquan/toolkit/XposedUtils$7;

    invoke-direct {v5, p0}, Lcom/lizhongquan/toolkit/XposedUtils$7;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;)V

    aput-object v5, v3, v4

    invoke-static {v0, v1, v2, v3}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 300
    return-void
.end method

.method private handleJapanTaxi(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
    .registers 8
    .param p1, "lpparam"    # Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;

    .prologue
    .line 308
    const-string v0, "android.app.ApplicationPackageManager"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v2, "getPackageInfo"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-class v5, Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    sget-object v5, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v5, v3, v4

    const/4 v4, 0x2

    new-instance v5, Lcom/lizhongquan/toolkit/XposedUtils$8;

    invoke-direct {v5, p0}, Lcom/lizhongquan/toolkit/XposedUtils$8;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;)V

    aput-object v5, v3, v4

    invoke-static {v0, v1, v2, v3}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 338
    return-void
.end method

.method private handleMTWaimai(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
    .registers 15
    .param p1, "lpparam"    # Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;

    .prologue
    const/16 v12, 0x40

    const/4 v11, 0x3

    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 389
    const-string v3, "android.app.ApplicationPackageManager"

    iget-object v4, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v5, "getPackageInfo"

    new-array v6, v11, [Ljava/lang/Object;

    const-class v7, Ljava/lang/String;

    aput-object v7, v6, v8

    sget-object v7, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v7, v6, v9

    new-instance v7, Lcom/lizhongquan/toolkit/XposedUtils$10;

    invoke-direct {v7, p0}, Lcom/lizhongquan/toolkit/XposedUtils$10;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;)V

    aput-object v7, v6, v10

    invoke-static {v3, v4, v5, v6}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 420
    sget-object v3, Lcom/lizhongquan/toolkit/XposedUtils;->TXTLIST:[Ljava/lang/String;

    if-nez v3, :cond_25

    .line 532
    :cond_24
    :goto_24
    return-void

    .line 426
    :cond_25
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 428
    .local v1, "sb":Ljava/lang/StringBuilder;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_2b
    if-ge v0, v12, :cond_40

    .line 429
    sget-object v3, Lcom/lizhongquan/toolkit/XposedUtils;->TXTLIST:[Ljava/lang/String;

    sget-object v4, Lcom/lizhongquan/toolkit/XposedUtils;->random:Ljava/util/Random;

    sget-object v5, Lcom/lizhongquan/toolkit/XposedUtils;->TXTLIST:[Ljava/lang/String;

    array-length v5, v5

    invoke-virtual {v4, v5}, Ljava/util/Random;->nextInt(I)I

    move-result v4

    aget-object v3, v3, v4

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 428
    add-int/lit8 v0, v0, 0x1

    goto :goto_2b

    .line 431
    :cond_40
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 432
    .local v2, "uuid":Ljava/lang/String;
    const-string v3, "xposed_log"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "\u7f8e\u56e2\u5916\u5356UUID: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 443
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-ne v3, v12, :cond_24

    .line 446
    const-string v3, "com.meituan.passport.DynamicLoginFragment"

    iget-object v4, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v5, "a"

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const-string v7, "com.meituan.passport.DynamicLoginFragment"

    aput-object v7, v6, v8

    const-class v7, Ljava/lang/String;

    aput-object v7, v6, v9

    const-class v7, Ljava/lang/String;

    aput-object v7, v6, v10

    new-instance v7, Lcom/lizhongquan/toolkit/XposedUtils$11;

    invoke-direct {v7, p0, v2}, Lcom/lizhongquan/toolkit/XposedUtils$11;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;Ljava/lang/String;)V

    aput-object v7, v6, v11

    invoke-static {v3, v4, v5, v6}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 466
    const-string v3, "com.sankuai.meituan.takeoutnew.model.AppInfo"

    iget-object v4, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v5, "setUUID"

    new-array v6, v11, [Ljava/lang/Object;

    const-class v7, Landroid/content/Context;

    aput-object v7, v6, v8

    const-class v7, Ljava/lang/String;

    aput-object v7, v6, v9

    new-instance v7, Lcom/lizhongquan/toolkit/XposedUtils$12;

    invoke-direct {v7, p0, v2}, Lcom/lizhongquan/toolkit/XposedUtils$12;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;Ljava/lang/String;)V

    aput-object v7, v6, v10

    invoke-static {v3, v4, v5, v6}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 482
    const-string v3, "com.sankuai.meituan.takeoutnew.model.AppInfo"

    iget-object v4, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v5, "getUUidFromSp"

    new-array v6, v10, [Ljava/lang/Object;

    const-class v7, Landroid/content/Context;

    aput-object v7, v6, v8

    new-instance v7, Lcom/lizhongquan/toolkit/XposedUtils$13;

    invoke-direct {v7, p0, v2}, Lcom/lizhongquan/toolkit/XposedUtils$13;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;Ljava/lang/String;)V

    aput-object v7, v6, v9

    invoke-static {v3, v4, v5, v6}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    goto/16 :goto_24
.end method

.method private handleOla(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
    .registers 8
    .param p1, "lpparam"    # Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;

    .prologue
    .line 232
    const-string v0, "android.app.ApplicationPackageManager"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->classLoader:Ljava/lang/ClassLoader;

    const-string v2, "getPackageInfo"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-class v5, Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    sget-object v5, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v5, v3, v4

    const/4 v4, 0x2

    new-instance v5, Lcom/lizhongquan/toolkit/XposedUtils$6;

    invoke-direct {v5, p0}, Lcom/lizhongquan/toolkit/XposedUtils$6;-><init>(Lcom/lizhongquan/toolkit/XposedUtils;)V

    aput-object v5, v3, v4

    invoke-static {v0, v1, v2, v3}, Lde/robv/android/xposed/XposedHelpers;->findAndHookMethod(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/String;[Ljava/lang/Object;)Lde/robv/android/xposed/XC_MethodHook$Unhook;

    .line 262
    return-void
.end method


# virtual methods
.method public handleLoadPackage(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
    .registers 4
    .param p1, "lpparam"    # Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 31
    const-string v0, "xposed-amap"

    iget-object v1, p0, Lcom/lizhongquan/toolkit/XposedUtils;->mRequest:Lde/robv/android/xposed/XC_MethodHook;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 54
    const-string v0, "com.sankuai.meituan.takeoutnew"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->packageName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 55
    invoke-direct {p0, p1}, Lcom/lizhongquan/toolkit/XposedUtils;->handleMTWaimai(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V

    .line 70
    :cond_18
    :goto_18
    return-void

    .line 56
    :cond_19
    const-string v0, "com.taxis99"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->packageName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_27

    .line 57
    invoke-direct {p0, p1}, Lcom/lizhongquan/toolkit/XposedUtils;->handle99pop(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V

    goto :goto_18

    .line 58
    :cond_27
    const-string v0, "com.olacabs.customer"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->packageName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_35

    .line 59
    invoke-direct {p0, p1}, Lcom/lizhongquan/toolkit/XposedUtils;->handleOla(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V

    goto :goto_18

    .line 60
    :cond_35
    const-string v0, "com.cornermation.calltaxi"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->packageName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_43

    .line 61
    invoke-direct {p0, p1}, Lcom/lizhongquan/toolkit/XposedUtils;->handleHKTaxi(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V

    goto :goto_18

    .line 62
    :cond_43
    const-string v0, "jp.co.nikko_data.japantaxi"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->packageName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_51

    .line 63
    invoke-direct {p0, p1}, Lcom/lizhongquan/toolkit/XposedUtils;->handleJapanTaxi(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V

    goto :goto_18

    .line 64
    :cond_51
    const-string v0, "com.dwd.rider"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->packageName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5f

    .line 65
    invoke-direct {p0, p1}, Lcom/lizhongquan/toolkit/XposedUtils;->handleDianWoDaDriver(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V

    goto :goto_18

    .line 66
    :cond_5f
    const-string v0, "com.autonavi.minimap"

    iget-object v1, p1, Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;->packageName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_18

    .line 68
    invoke-direct {p0, p1}, Lcom/lizhongquan/toolkit/XposedUtils;->handleAmap(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V

    goto :goto_18
.end method
