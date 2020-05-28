package com.leshu.superbrain.ui.base;

import java.lang.System;

/**
 * @创建者wwy
 * @创建时间 2019/9/10 17:51
 * @描述 abstract 抽象类或者方法默认是带着的open
 * open关键字 与java 中的 final相反:它允许别的类继承这个类。默认情形下，kotlin 中所有的类都是 final ,用来表示他可以被继承。
 * 若子类要重写父类中的方法，则需在父类的方法前面加open关键字，然后在子类重写的方法前加override关键字
 * lateinit var延迟初始化 只能用来修饰类属性，不能用来修饰局部变量，并且只能用来修饰对象，不能用来修饰基本类型(因为基本类型的属性在类加载后的准备阶段都会被初始化为默认值)
 * by lazy要求属性声明为val，即不可变变量，在java中相当于被final修饰。这意味着该变量一旦初始化后就不允许再被修改值了(基本类型是值不能被修改，对象类型是引用不能被修改)。{}内的操作就是返回唯一一次初始化的结果。
 * by lazy可以使用于类属性或者局部变量。
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0014J\u0010\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016R\u001c\u0010\u0005\u001a\u00028\u0000X\u0086.\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/leshu/superbrain/ui/base/BaseVMActivity;", "VM", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "Lcom/leshu/superbrain/ui/base/BaseActivity;", "()V", "mViewModel", "getMViewModel", "()Lcom/leshu/superbrain/vm/base/BaseViewModel;", "setMViewModel", "(Lcom/leshu/superbrain/vm/base/BaseViewModel;)V", "Lcom/leshu/superbrain/vm/base/BaseViewModel;", "initVM", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "providerVMClass", "Ljava/lang/Class;", "startObserve", "app_debug"})
public abstract class BaseVMActivity<VM extends com.leshu.superbrain.vm.base.BaseViewModel> extends com.leshu.superbrain.ui.base.BaseActivity {
    @org.jetbrains.annotations.NotNull()
    public VM mViewModel;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final VM getMViewModel() {
        return null;
    }
    
    public final void setMViewModel(@org.jetbrains.annotations.NotNull()
    VM p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * [BaseViewModel]的实现类
     */
    @org.jetbrains.annotations.Nullable()
    public java.lang.Class<VM> providerVMClass() {
        return null;
    }
    
    /**
     * 如果要只对非空值执行某个操作，安全调用操作符可以与 let 一起使用：
     */
    private final void initVM() {
    }
    
    public void startObserve() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public BaseVMActivity() {
        super();
    }
}