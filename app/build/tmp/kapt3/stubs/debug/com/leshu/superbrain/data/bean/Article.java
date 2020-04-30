package com.leshu.superbrain.data.bean;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\bK\b\u0086\b\u0018\u00002\u00020\u0001B\u00f7\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u000e\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020\u0003\u00a2\u0006\u0002\u0010%J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\u000eH\u00c6\u0003J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\t\u0010N\u001a\u00020\u0006H\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\t\u0010P\u001a\u00020\u0006H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0006H\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0016H\u00c6\u0003J\t\u0010T\u001a\u00020\u0006H\u00c6\u0003J\t\u0010U\u001a\u00020\u0006H\u00c6\u0003J\t\u0010V\u001a\u00020\u0003H\u00c6\u0003J\t\u0010W\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0016H\u00c6\u0003J\t\u0010[\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\\\u001a\u00020\u0006H\u00c6\u0003J\t\u0010]\u001a\u00020\u0003H\u00c6\u0003J\t\u0010^\u001a\u00020\u000eH\u00c6\u0003J\t\u0010_\u001a\u00020\u0006H\u00c6\u0003J\t\u0010`\u001a\u00020#H\u00c6\u0003J\t\u0010a\u001a\u00020\u0006H\u00c6\u0003J\t\u0010b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010d\u001a\u00020\u0006H\u00c6\u0003J\t\u0010e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010g\u001a\u00020\u0006H\u00c6\u0003J\t\u0010h\u001a\u00020\u0006H\u00c6\u0003J\u00b7\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010j\u001a\u00020\u00162\b\u0010k\u001a\u0004\u0018\u00010#H\u00d6\u0003J\t\u0010l\u001a\u00020\u0003H\u00d6\u0001J\t\u0010m\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\'R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\'R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010)R\u0011\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\'R\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\'R\u0011\u0010\u001c\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\'R\u0011\u0010\u0012\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\'R\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\'R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\'R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010)R\u0011\u0010\u001e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\'R\u0011\u0010\u0018\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\'R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u001f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010)R\u0011\u0010 \u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010>R\u0011\u0010!\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010\'R\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010)R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010\'R\u0011\u0010\"\u001a\u00020#\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010\'R\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010)R\u0011\u0010$\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010)R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010)R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010)\u00a8\u0006n"}, d2 = {"Lcom/leshu/superbrain/data/bean/Article;", "Ljava/io/Serializable;", "id", "", "originId", "title", "", "chapterId", "chapterName", "envelopePic", "link", "author", "origin", "publishTime", "", "zan", "desc", "visible", "niceDate", "niceShareDate", "courseId", "collect", "", "apkLink", "projectLink", "superChapterId", "superChapterName", "type", "fresh", "audit", "prefix", "selfVisible", "shareDate", "shareUser", "tags", "", "userId", "(IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;ILjava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;IZILjava/lang/String;IJLjava/lang/String;Ljava/lang/Object;I)V", "getApkLink", "()Ljava/lang/String;", "getAudit", "()I", "getAuthor", "getChapterId", "getChapterName", "getCollect", "()Z", "setCollect", "(Z)V", "getCourseId", "getDesc", "getEnvelopePic", "getFresh", "getId", "getLink", "getNiceDate", "getNiceShareDate", "getOrigin", "getOriginId", "getPrefix", "getProjectLink", "getPublishTime", "()J", "getSelfVisible", "getShareDate", "getShareUser", "getSuperChapterId", "getSuperChapterName", "getTags", "()Ljava/lang/Object;", "getTitle", "getType", "getUserId", "getVisible", "getZan", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Article implements java.io.Serializable {
    private final int id = 0;
    private final int originId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    private final int chapterId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String chapterName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String envelopePic = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String link = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String author = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String origin = null;
    private final long publishTime = 0L;
    private final int zan = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String desc = null;
    private final int visible = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String niceDate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String niceShareDate = null;
    private final int courseId = 0;
    private boolean collect;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apkLink = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String projectLink = null;
    private final int superChapterId = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String superChapterName = null;
    private final int type = 0;
    private final boolean fresh = false;
    private final int audit = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String prefix = null;
    private final int selfVisible = 0;
    private final long shareDate = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String shareUser = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object tags = null;
    private final int userId = 0;
    
    public final int getId() {
        return 0;
    }
    
    public final int getOriginId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final int getChapterId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChapterName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEnvelopePic() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLink() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrigin() {
        return null;
    }
    
    public final long getPublishTime() {
        return 0L;
    }
    
    public final int getZan() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDesc() {
        return null;
    }
    
    public final int getVisible() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNiceDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNiceShareDate() {
        return null;
    }
    
    public final int getCourseId() {
        return 0;
    }
    
    public final boolean getCollect() {
        return false;
    }
    
    public final void setCollect(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApkLink() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProjectLink() {
        return null;
    }
    
    public final int getSuperChapterId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSuperChapterName() {
        return null;
    }
    
    public final int getType() {
        return 0;
    }
    
    public final boolean getFresh() {
        return false;
    }
    
    public final int getAudit() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrefix() {
        return null;
    }
    
    public final int getSelfVisible() {
        return 0;
    }
    
    public final long getShareDate() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getShareUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getTags() {
        return null;
    }
    
    public final int getUserId() {
        return 0;
    }
    
    public Article(int id, int originId, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int chapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String chapterName, @org.jetbrains.annotations.NotNull()
    java.lang.String envelopePic, @org.jetbrains.annotations.NotNull()
    java.lang.String link, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String origin, long publishTime, int zan, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, int visible, @org.jetbrains.annotations.NotNull()
    java.lang.String niceDate, @org.jetbrains.annotations.NotNull()
    java.lang.String niceShareDate, int courseId, boolean collect, @org.jetbrains.annotations.NotNull()
    java.lang.String apkLink, @org.jetbrains.annotations.NotNull()
    java.lang.String projectLink, int superChapterId, @org.jetbrains.annotations.Nullable()
    java.lang.String superChapterName, int type, boolean fresh, int audit, @org.jetbrains.annotations.NotNull()
    java.lang.String prefix, int selfVisible, long shareDate, @org.jetbrains.annotations.NotNull()
    java.lang.String shareUser, @org.jetbrains.annotations.NotNull()
    java.lang.Object tags, int userId) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    public final long component10() {
        return 0L;
    }
    
    public final int component11() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    public final int component13() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    public final int component16() {
        return 0;
    }
    
    public final boolean component17() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    public final int component20() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component21() {
        return null;
    }
    
    public final int component22() {
        return 0;
    }
    
    public final boolean component23() {
        return false;
    }
    
    public final int component24() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component25() {
        return null;
    }
    
    public final int component26() {
        return 0;
    }
    
    public final long component27() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component29() {
        return null;
    }
    
    public final int component30() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.leshu.superbrain.data.bean.Article copy(int id, int originId, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int chapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String chapterName, @org.jetbrains.annotations.NotNull()
    java.lang.String envelopePic, @org.jetbrains.annotations.NotNull()
    java.lang.String link, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String origin, long publishTime, int zan, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, int visible, @org.jetbrains.annotations.NotNull()
    java.lang.String niceDate, @org.jetbrains.annotations.NotNull()
    java.lang.String niceShareDate, int courseId, boolean collect, @org.jetbrains.annotations.NotNull()
    java.lang.String apkLink, @org.jetbrains.annotations.NotNull()
    java.lang.String projectLink, int superChapterId, @org.jetbrains.annotations.Nullable()
    java.lang.String superChapterName, int type, boolean fresh, int audit, @org.jetbrains.annotations.NotNull()
    java.lang.String prefix, int selfVisible, long shareDate, @org.jetbrains.annotations.NotNull()
    java.lang.String shareUser, @org.jetbrains.annotations.NotNull()
    java.lang.Object tags, int userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}