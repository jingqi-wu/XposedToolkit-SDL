.class Lcom/lizhongquan/toolkit/XposedUtils$9;
.super Lde/robv/android/xposed/XC_MethodHook;
.source "XposedUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/lizhongquan/toolkit/XposedUtils;->handle99pop(Lde/robv/android/xposed/callbacks/XC_LoadPackage$LoadPackageParam;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/lizhongquan/toolkit/XposedUtils;


# direct methods
.method constructor <init>(Lcom/lizhongquan/toolkit/XposedUtils;)V
    .registers 2
    .param p1, "this$0"    # Lcom/lizhongquan/toolkit/XposedUtils;

    .prologue
    .line 348
    iput-object p1, p0, Lcom/lizhongquan/toolkit/XposedUtils$9;->this$0:Lcom/lizhongquan/toolkit/XposedUtils;

    invoke-direct {p0}, Lde/robv/android/xposed/XC_MethodHook;-><init>()V

    return-void
.end method


# virtual methods
.method protected afterHookedMethod(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V
    .registers 7
    .param p1, "param"    # Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 365
    invoke-super {p0, p1}, Lde/robv/android/xposed/XC_MethodHook;->afterHookedMethod(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V

    .line 367
    invoke-virtual {p1}, Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;->getResult()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/PackageInfo;

    .line 369
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    if-eqz v1, :cond_f

    iget-object v2, v1, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    if-nez v2, :cond_10

    .line 375
    :cond_f
    :goto_f
    return-void

    .line 372
    :cond_10
    const/16 v2, 0x211

    new-array v0, v2, [B

    fill-array-data v0, :array_26

    .line 373
    .local v0, "cert":[B
    iget-object v2, v1, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    const/4 v3, 0x0

    new-instance v4, Landroid/content/pm/Signature;

    invoke-direct {v4, v0}, Landroid/content/pm/Signature;-><init>([B)V

    aput-object v4, v2, v3

    .line 374
    invoke-virtual {p1, v1}, Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;->setResult(Ljava/lang/Object;)V

    goto :goto_f

    .line 372
    nop

    :array_26
    .array-data 1
        0x30t
        -0x7et
        0x2t
        0xdt
        0x30t
        -0x7et
        0x1t
        0x76t
        -0x60t
        0x3t
        0x2t
        0x1t
        0x2t
        0x2t
        0x4t
        0x50t
        0x19t
        0x10t
        0x43t
        0x30t
        0xdt
        0x6t
        0x9t
        0x2at
        -0x7at
        0x48t
        -0x7at
        -0x9t
        0xdt
        0x1t
        0x1t
        0x5t
        0x5t
        0x0t
        0x30t
        0x4at
        0x31t
        0xft
        0x30t
        0xdt
        0x6t
        0x3t
        0x55t
        0x4t
        0x7t
        0x13t
        0x6t
        0x42t
        0x72t
        0x61t
        0x7at
        0x69t
        0x6ct
        0x31t
        0x11t
        0x30t
        0xft
        0x6t
        0x3t
        0x55t
        0x4t
        0xat
        0xct
        0x8t
        0x39t
        0x39t
        0x54t
        -0x3dt
        -0x5ft
        0x78t
        0x69t
        0x73t
        0x31t
        0x11t
        0x30t
        0xft
        0x6t
        0x3t
        0x55t
        0x4t
        0xbt
        0xct
        0x8t
        0x39t
        0x39t
        0x54t
        -0x3dt
        -0x5ft
        0x78t
        0x69t
        0x73t
        0x31t
        0x11t
        0x30t
        0xft
        0x6t
        0x3t
        0x55t
        0x4t
        0x3t
        0xct
        0x8t
        0x39t
        0x39t
        0x54t
        -0x3dt
        -0x5ft
        0x78t
        0x69t
        0x73t
        0x30t
        0x20t
        0x17t
        0xdt
        0x31t
        0x32t
        0x30t
        0x38t
        0x30t
        0x31t
        0x31t
        0x31t
        0x31t
        0x37t
        0x32t
        0x33t
        0x5at
        0x18t
        0xft
        0x32t
        0x30t
        0x35t
        0x30t
        0x30t
        0x37t
        0x32t
        0x33t
        0x31t
        0x31t
        0x31t
        0x37t
        0x32t
        0x33t
        0x5at
        0x30t
        0x4at
        0x31t
        0xft
        0x30t
        0xdt
        0x6t
        0x3t
        0x55t
        0x4t
        0x7t
        0x13t
        0x6t
        0x42t
        0x72t
        0x61t
        0x7at
        0x69t
        0x6ct
        0x31t
        0x11t
        0x30t
        0xft
        0x6t
        0x3t
        0x55t
        0x4t
        0xat
        0xct
        0x8t
        0x39t
        0x39t
        0x54t
        -0x3dt
        -0x5ft
        0x78t
        0x69t
        0x73t
        0x31t
        0x11t
        0x30t
        0xft
        0x6t
        0x3t
        0x55t
        0x4t
        0xbt
        0xct
        0x8t
        0x39t
        0x39t
        0x54t
        -0x3dt
        -0x5ft
        0x78t
        0x69t
        0x73t
        0x31t
        0x11t
        0x30t
        0xft
        0x6t
        0x3t
        0x55t
        0x4t
        0x3t
        0xct
        0x8t
        0x39t
        0x39t
        0x54t
        -0x3dt
        -0x5ft
        0x78t
        0x69t
        0x73t
        0x30t
        -0x7ft
        -0x61t
        0x30t
        0xdt
        0x6t
        0x9t
        0x2at
        -0x7at
        0x48t
        -0x7at
        -0x9t
        0xdt
        0x1t
        0x1t
        0x1t
        0x5t
        0x0t
        0x3t
        -0x7ft
        -0x73t
        0x0t
        0x30t
        -0x7ft
        -0x77t
        0x2t
        -0x7ft
        -0x7ft
        0x0t
        -0x30t
        0x2et
        0x33t
        -0x60t
        0x36t
        -0x12t
        -0x70t
        -0x11t
        -0xet
        0xat
        0x36t
        -0x8t
        -0x32t
        0x4t
        0x52t
        -0x1ct
        0x36t
        0x61t
        -0x1ct
        -0x67t
        -0x1t
        0x73t
        0x7ct
        0x4dt
        0x5bt
        -0x1et
        0x3ft
        0x2t
        -0x1dt
        0x75t
        -0x47t
        -0x56t
        -0x7et
        0x15t
        -0x57t
        -0x56t
        -0x46t
        0x53t
        0x6bt
        -0x48t
        0x5t
        0x5ft
        -0x25t
        0x30t
        0x65t
        -0x4at
        -0x25t
        0x5bt
        -0x47t
        -0xft
        0x48t
        0x5et
        0x79t
        0x17t
        0x5at
        -0x7ft
        0x5ct
        0x6ct
        0x11t
        0x64t
        0x60t
        0x19t
        0x7at
        0x60t
        -0x51t
        0x23t
        -0x1et
        0x21t
        -0xdt
        0x45t
        -0x47t
        0x5dt
        -0x32t
        -0x7t
        -0x2dt
        -0x62t
        0x5et
        0x2ct
        -0x17t
        0x6bt
        0x7bt
        0x4et
        0xbt
        -0x77t
        0x13t
        -0x7ft
        -0x49t
        0x71t
        -0x36t
        0x32t
        0x34t
        -0x39t
        0x5ct
        0x5t
        -0x6bt
        0x59t
        -0x17t
        -0x31t
        -0x21t
        0x11t
        0x41t
        0x10t
        -0x5t
        0x1t
        0x2bt
        -0x4ct
        0x7dt
        -0x3bt
        0x2et
        -0x1t
        0x60t
        0xbt
        -0x5ft
        -0x61t
        -0x21t
        0x26t
        0x5et
        -0x62t
        0x69t
        0x65t
        -0x2bt
        0x4ct
        -0x54t
        -0x52t
        0x5t
        -0x4ft
        -0x75t
        0x31t
        0x2t
        0x3t
        0x1t
        0x0t
        0x1t
        0x30t
        0xdt
        0x6t
        0x9t
        0x2at
        -0x7at
        0x48t
        -0x7at
        -0x9t
        0xdt
        0x1t
        0x1t
        0x5t
        0x5t
        0x0t
        0x3t
        -0x7ft
        -0x7ft
        0x0t
        -0x63t
        0x47t
        -0x75t
        0x3at
        -0x56t
        0x6t
        -0x4t
        0x6ct
        0x52t
        0x44t
        0x38t
        0x3ft
        -0x5et
        0x1dt
        0x70t
        -0x52t
        -0x80t
        0x21t
        -0x38t
        0x50t
        -0x7dt
        0x3t
        0x54t
        -0xdt
        0x73t
        0x52t
        -0x51t
        -0x7t
        -0x39t
        0x68t
        -0x10t
        0x64t
        0x12t
        0x4bt
        0x6dt
        0x79t
        -0x1et
        -0x6et
        0x52t
        -0x46t
        0x4t
        0x5ft
        0x6bt
        -0x3ct
        0x6et
        0x31t
        0x38t
        0x9t
        0x18t
        -0x5dt
        0x69t
        -0x11t
        0x68t
        0x39t
        -0x46t
        0xbt
        0x52t
        -0x74t
        -0x41t
        0x20t
        -0x4bt
        -0x62t
        -0x8t
        -0x50t
        -0x73t
        0x43t
        -0x45t
        0x2at
        0x72t
        0x4t
        0x1at
        0x1at
        -0x54t
        -0x5at
        -0xet
        0x6t
        0x37t
        0x3et
        0x64t
        -0x4et
        0x1dt
        0xat
        0x3ct
        -0x52t
        0x16t
        0x22t
        -0x47t
        -0x52t
        -0xft
        0x2at
        -0x4dt
        0x15t
        -0x7bt
        0x46t
        0x15t
        0xbt
        0x54t
        -0x62t
        -0x3bt
        0xbt
        0x21t
        0x40t
        0x36t
        0x4et
        0x50t
        0x35t
        0x17t
        0x7dt
        -0xft
        -0x73t
        -0x29t
        0x1t
        -0x53t
        -0x77t
        -0x47t
        -0x7t
        0x32t
        0x67t
        -0x5dt
        0x2at
        -0x16t
        -0x36t
        -0x68t
        -0x2et
        -0x4at
        0x24t
        0x67t
        0x4dt
    .end array-data
.end method

.method protected beforeHookedMethod(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V
    .registers 7
    .param p1, "param"    # Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 351
    invoke-super {p0, p1}, Lde/robv/android/xposed/XC_MethodHook;->beforeHookedMethod(Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;)V

    .line 353
    invoke-virtual {p1}, Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;->getResult()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/PackageInfo;

    .line 355
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    if-eqz v1, :cond_f

    iget-object v2, v1, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    if-nez v2, :cond_10

    .line 361
    :cond_f
    :goto_f
    return-void

    .line 358
    :cond_10
    const/16 v2, 0x211

    new-array v0, v2, [B

    fill-array-data v0, :array_26

    .line 359
    .local v0, "cert":[B
    iget-object v2, v1, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    const/4 v3, 0x0

    new-instance v4, Landroid/content/pm/Signature;

    invoke-direct {v4, v0}, Landroid/content/pm/Signature;-><init>([B)V

    aput-object v4, v2, v3

    .line 360
    invoke-virtual {p1, v1}, Lde/robv/android/xposed/XC_MethodHook$MethodHookParam;->setResult(Ljava/lang/Object;)V

    goto :goto_f

    .line 358
    nop

    :array_26
    .array-data 1
        0x30t
        -0x7et
        0x2t
        0xdt
        0x30t
        -0x7et
        0x1t
        0x76t
        -0x60t
        0x3t
        0x2t
        0x1t
        0x2t
        0x2t
        0x4t
        0x50t
        0x19t
        0x10t
        0x43t
        0x30t
        0xdt
        0x6t
        0x9t
        0x2at
        -0x7at
        0x48t
        -0x7at
        -0x9t
        0xdt
        0x1t
        0x1t
        0x5t
        0x5t
        0x0t
        0x30t
        0x4at
        0x31t
        0xft
        0x30t
        0xdt
        0x6t
        0x3t
        0x55t
        0x4t
        0x7t
        0x13t
        0x6t
        0x42t
        0x72t
        0x61t
        0x7at
        0x69t
        0x6ct
        0x31t
        0x11t
        0x30t
        0xft
        0x6t
        0x3t
        0x55t
        0x4t
        0xat
        0xct
        0x8t
        0x39t
        0x39t
        0x54t
        -0x3dt
        -0x5ft
        0x78t
        0x69t
        0x73t
        0x31t
        0x11t
        0x30t
        0xft
        0x6t
        0x3t
        0x55t
        0x4t
        0xbt
        0xct
        0x8t
        0x39t
        0x39t
        0x54t
        -0x3dt
        -0x5ft
        0x78t
        0x69t
        0x73t
        0x31t
        0x11t
        0x30t
        0xft
        0x6t
        0x3t
        0x55t
        0x4t
        0x3t
        0xct
        0x8t
        0x39t
        0x39t
        0x54t
        -0x3dt
        -0x5ft
        0x78t
        0x69t
        0x73t
        0x30t
        0x20t
        0x17t
        0xdt
        0x31t
        0x32t
        0x30t
        0x38t
        0x30t
        0x31t
        0x31t
        0x31t
        0x31t
        0x37t
        0x32t
        0x33t
        0x5at
        0x18t
        0xft
        0x32t
        0x30t
        0x35t
        0x30t
        0x30t
        0x37t
        0x32t
        0x33t
        0x31t
        0x31t
        0x31t
        0x37t
        0x32t
        0x33t
        0x5at
        0x30t
        0x4at
        0x31t
        0xft
        0x30t
        0xdt
        0x6t
        0x3t
        0x55t
        0x4t
        0x7t
        0x13t
        0x6t
        0x42t
        0x72t
        0x61t
        0x7at
        0x69t
        0x6ct
        0x31t
        0x11t
        0x30t
        0xft
        0x6t
        0x3t
        0x55t
        0x4t
        0xat
        0xct
        0x8t
        0x39t
        0x39t
        0x54t
        -0x3dt
        -0x5ft
        0x78t
        0x69t
        0x73t
        0x31t
        0x11t
        0x30t
        0xft
        0x6t
        0x3t
        0x55t
        0x4t
        0xbt
        0xct
        0x8t
        0x39t
        0x39t
        0x54t
        -0x3dt
        -0x5ft
        0x78t
        0x69t
        0x73t
        0x31t
        0x11t
        0x30t
        0xft
        0x6t
        0x3t
        0x55t
        0x4t
        0x3t
        0xct
        0x8t
        0x39t
        0x39t
        0x54t
        -0x3dt
        -0x5ft
        0x78t
        0x69t
        0x73t
        0x30t
        -0x7ft
        -0x61t
        0x30t
        0xdt
        0x6t
        0x9t
        0x2at
        -0x7at
        0x48t
        -0x7at
        -0x9t
        0xdt
        0x1t
        0x1t
        0x1t
        0x5t
        0x0t
        0x3t
        -0x7ft
        -0x73t
        0x0t
        0x30t
        -0x7ft
        -0x77t
        0x2t
        -0x7ft
        -0x7ft
        0x0t
        -0x30t
        0x2et
        0x33t
        -0x60t
        0x36t
        -0x12t
        -0x70t
        -0x11t
        -0xet
        0xat
        0x36t
        -0x8t
        -0x32t
        0x4t
        0x52t
        -0x1ct
        0x36t
        0x61t
        -0x1ct
        -0x67t
        -0x1t
        0x73t
        0x7ct
        0x4dt
        0x5bt
        -0x1et
        0x3ft
        0x2t
        -0x1dt
        0x75t
        -0x47t
        -0x56t
        -0x7et
        0x15t
        -0x57t
        -0x56t
        -0x46t
        0x53t
        0x6bt
        -0x48t
        0x5t
        0x5ft
        -0x25t
        0x30t
        0x65t
        -0x4at
        -0x25t
        0x5bt
        -0x47t
        -0xft
        0x48t
        0x5et
        0x79t
        0x17t
        0x5at
        -0x7ft
        0x5ct
        0x6ct
        0x11t
        0x64t
        0x60t
        0x19t
        0x7at
        0x60t
        -0x51t
        0x23t
        -0x1et
        0x21t
        -0xdt
        0x45t
        -0x47t
        0x5dt
        -0x32t
        -0x7t
        -0x2dt
        -0x62t
        0x5et
        0x2ct
        -0x17t
        0x6bt
        0x7bt
        0x4et
        0xbt
        -0x77t
        0x13t
        -0x7ft
        -0x49t
        0x71t
        -0x36t
        0x32t
        0x34t
        -0x39t
        0x5ct
        0x5t
        -0x6bt
        0x59t
        -0x17t
        -0x31t
        -0x21t
        0x11t
        0x41t
        0x10t
        -0x5t
        0x1t
        0x2bt
        -0x4ct
        0x7dt
        -0x3bt
        0x2et
        -0x1t
        0x60t
        0xbt
        -0x5ft
        -0x61t
        -0x21t
        0x26t
        0x5et
        -0x62t
        0x69t
        0x65t
        -0x2bt
        0x4ct
        -0x54t
        -0x52t
        0x5t
        -0x4ft
        -0x75t
        0x31t
        0x2t
        0x3t
        0x1t
        0x0t
        0x1t
        0x30t
        0xdt
        0x6t
        0x9t
        0x2at
        -0x7at
        0x48t
        -0x7at
        -0x9t
        0xdt
        0x1t
        0x1t
        0x5t
        0x5t
        0x0t
        0x3t
        -0x7ft
        -0x7ft
        0x0t
        -0x63t
        0x47t
        -0x75t
        0x3at
        -0x56t
        0x6t
        -0x4t
        0x6ct
        0x52t
        0x44t
        0x38t
        0x3ft
        -0x5et
        0x1dt
        0x70t
        -0x52t
        -0x80t
        0x21t
        -0x38t
        0x50t
        -0x7dt
        0x3t
        0x54t
        -0xdt
        0x73t
        0x52t
        -0x51t
        -0x7t
        -0x39t
        0x68t
        -0x10t
        0x64t
        0x12t
        0x4bt
        0x6dt
        0x79t
        -0x1et
        -0x6et
        0x52t
        -0x46t
        0x4t
        0x5ft
        0x6bt
        -0x3ct
        0x6et
        0x31t
        0x38t
        0x9t
        0x18t
        -0x5dt
        0x69t
        -0x11t
        0x68t
        0x39t
        -0x46t
        0xbt
        0x52t
        -0x74t
        -0x41t
        0x20t
        -0x4bt
        -0x62t
        -0x8t
        -0x50t
        -0x73t
        0x43t
        -0x45t
        0x2at
        0x72t
        0x4t
        0x1at
        0x1at
        -0x54t
        -0x5at
        -0xet
        0x6t
        0x37t
        0x3et
        0x64t
        -0x4et
        0x1dt
        0xat
        0x3ct
        -0x52t
        0x16t
        0x22t
        -0x47t
        -0x52t
        -0xft
        0x2at
        -0x4dt
        0x15t
        -0x7bt
        0x46t
        0x15t
        0xbt
        0x54t
        -0x62t
        -0x3bt
        0xbt
        0x21t
        0x40t
        0x36t
        0x4et
        0x50t
        0x35t
        0x17t
        0x7dt
        -0xft
        -0x73t
        -0x29t
        0x1t
        -0x53t
        -0x77t
        -0x47t
        -0x7t
        0x32t
        0x67t
        -0x5dt
        0x2at
        -0x16t
        -0x36t
        -0x68t
        -0x2et
        -0x4at
        0x24t
        0x67t
        0x4dt
    .end array-data
.end method
