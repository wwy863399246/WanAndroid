package com.leshu.superbrain.data.bean;

import java.lang.System;

/**
 * 文章
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b^\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u00d3\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u0006\u00a2\u0006\u0002\u0010!J\t\u0010^\u001a\u00020\u0003H\u00c6\u0003J\t\u0010_\u001a\u00020\u0006H\u00c6\u0003J\t\u0010`\u001a\u00020\u0003H\u00c6\u0003J\t\u0010a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010e\u001a\u00020\u0015H\u00c6\u0003J\t\u0010f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010g\u001a\u00020\u0003H\u00c6\u0003J\t\u0010h\u001a\u00020\u0003H\u00c6\u0003J\t\u0010i\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u00c6\u0003J\t\u0010k\u001a\u00020\u0003H\u00c6\u0003J\t\u0010l\u001a\u00020\u0006H\u00c6\u0003J\t\u0010m\u001a\u00020\u0006H\u00c6\u0003J\t\u0010n\u001a\u00020\u0006H\u00c6\u0003J\t\u0010o\u001a\u00020\u0006H\u00c6\u0003J\t\u0010p\u001a\u00020\u0006H\u00c6\u0003J\t\u0010q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010r\u001a\u00020\tH\u00c6\u0003J\t\u0010s\u001a\u00020\u0006H\u00c6\u0003J\t\u0010t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010u\u001a\u00020\u0003H\u00c6\u0003J\t\u0010v\u001a\u00020\tH\u00c6\u0003J\u0089\u0002\u0010w\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010x\u001a\u00020\t2\b\u0010y\u001a\u0004\u0018\u00010zH\u00d6\u0003J\t\u0010{\u001a\u00020\u0006H\u00d6\u0001J\t\u0010|\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b\'\u0010%R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010)\"\u0004\b3\u0010+R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%R\u001a\u0010\r\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010/\"\u0004\b9\u00101R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010)\"\u0004\b;\u0010+R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010#\"\u0004\b=\u0010%R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010#\"\u0004\bC\u0010%R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010#\"\u0004\bE\u0010%R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010#\"\u0004\bK\u0010%R\u001a\u0010\u0016\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010)\"\u0004\bM\u0010+R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010#\"\u0004\bO\u0010%R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010#\"\u0004\bU\u0010%R\u001a\u0010\u001d\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010)\"\u0004\bW\u0010+R\u001a\u0010\u001e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010)\"\u0004\bY\u0010+R\u001a\u0010\u001f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010)\"\u0004\b[\u0010+R\u001a\u0010 \u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010)\"\u0004\b]\u0010+\u00a8\u0006}"}, d2 = {"Lcom/leshu/superbrain/data/bean/AriticleResponse;", "Ljava/io/Serializable;", "apkLink", "", "author", "chapterId", "", "chapterName", "collect", "", "courseId", "desc", "envelopePic", "fresh", "id", "link", "niceDate", "origin", "prefix", "projectLink", "publishTime", "", "superChapterId", "superChapterName", "shareUser", "tags", "", "Lcom/leshu/superbrain/data/bean/TagsResponse;", "title", "type", "userId", "visible", "zan", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZILjava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;IIII)V", "getApkLink", "()Ljava/lang/String;", "setApkLink", "(Ljava/lang/String;)V", "getAuthor", "setAuthor", "getChapterId", "()I", "setChapterId", "(I)V", "getChapterName", "setChapterName", "getCollect", "()Z", "setCollect", "(Z)V", "getCourseId", "setCourseId", "getDesc", "setDesc", "getEnvelopePic", "setEnvelopePic", "getFresh", "setFresh", "getId", "setId", "getLink", "setLink", "getNiceDate", "setNiceDate", "getOrigin", "setOrigin", "getPrefix", "setPrefix", "getProjectLink", "setProjectLink", "getPublishTime", "()J", "setPublishTime", "(J)V", "getShareUser", "setShareUser", "getSuperChapterId", "setSuperChapterId", "getSuperChapterName", "setSuperChapterName", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getTitle", "setTitle", "getType", "setType", "getUserId", "setUserId", "getVisible", "setVisible", "getZan", "setZan", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "app_debug"})
public final class AriticleResponse implements java.io.Serializable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String apkLink;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String author;
    private int chapterId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String chapterName;
    private boolean collect;
    private int courseId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String desc;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String envelopePic;
    private boolean fresh;
    private int id;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String link;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String niceDate;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String origin;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String prefix;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String projectLink;
    private long publishTime;
    private int superChapterId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String superChapterName;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String shareUser;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.leshu.superbrain.data.bean.TagsResponse> tags;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String title;
    private int type;
    private int userId;
    private int visible;
    private int zan;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApkLink() {
        return null;
    }
    
    public final void setApkLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthor() {
        return null;
    }
    
    public final void setAuthor(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getChapterId() {
        return 0;
    }
    
    public final void setChapterId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChapterName() {
        return null;
    }
    
    public final void setChapterName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getCollect() {
        return false;
    }
    
    public final void setCollect(boolean p0) {
    }
    
    public final int getCourseId() {
        return 0;
    }
    
    public final void setCourseId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDesc() {
        return null;
    }
    
    public final void setDesc(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEnvelopePic() {
        return null;
    }
    
    public final void setEnvelopePic(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getFresh() {
        return false;
    }
    
    public final void setFresh(boolean p0) {
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLink() {
        return null;
    }
    
    public final void setLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNiceDate() {
        return null;
    }
    
    public final void setNiceDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrigin() {
        return null;
    }
    
    public final void setOrigin(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrefix() {
        return null;
    }
    
    public final void setPrefix(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProjectLink() {
        return null;
    }
    
    public final void setProjectLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final long getPublishTime() {
        return 0L;
    }
    
    public final void setPublishTime(long p0) {
    }
    
    public final int getSuperChapterId() {
        return 0;
    }
    
    public final void setSuperChapterId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSuperChapterName() {
        return null;
    }
    
    public final void setSuperChapterName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getShareUser() {
        return null;
    }
    
    public final void setShareUser(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.leshu.superbrain.data.bean.TagsResponse> getTags() {
        return null;
    }
    
    public final void setTags(@org.jetbrains.annotations.NotNull()
    java.util.List<com.leshu.superbrain.data.bean.TagsResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getType() {
        return 0;
    }
    
    public final void setType(int p0) {
    }
    
    public final int getUserId() {
        return 0;
    }
    
    public final void setUserId(int p0) {
    }
    
    public final int getVisible() {
        return 0;
    }
    
    public final void setVisible(int p0) {
    }
    
    public final int getZan() {
        return 0;
    }
    
    public final void setZan(int p0) {
    }
    
    public AriticleResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String apkLink, @org.jetbrains.annotations.NotNull()
    java.lang.String author, int chapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String chapterName, boolean collect, int courseId, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String envelopePic, boolean fresh, int id, @org.jetbrains.annotations.NotNull()
    java.lang.String link, @org.jetbrains.annotations.NotNull()
    java.lang.String niceDate, @org.jetbrains.annotations.NotNull()
    java.lang.String origin, @org.jetbrains.annotations.NotNull()
    java.lang.String prefix, @org.jetbrains.annotations.NotNull()
    java.lang.String projectLink, long publishTime, int superChapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String superChapterName, @org.jetbrains.annotations.NotNull()
    java.lang.String shareUser, @org.jetbrains.annotations.NotNull()
    java.util.List<com.leshu.superbrain.data.bean.TagsResponse> tags, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int type, int userId, int visible, int zan) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final int component10() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    public final long component16() {
        return 0L;
    }
    
    public final int component17() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.leshu.superbrain.data.bean.TagsResponse> component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    public final int component22() {
        return 0;
    }
    
    public final int component23() {
        return 0;
    }
    
    public final int component24() {
        return 0;
    }
    
    public final int component25() {
        return 0;
    }
    
    /**
     * 文章
     */
    @org.jetbrains.annotations.NotNull()
    public final com.leshu.superbrain.data.bean.AriticleResponse copy(@org.jetbrains.annotations.NotNull()
    java.lang.String apkLink, @org.jetbrains.annotations.NotNull()
    java.lang.String author, int chapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String chapterName, boolean collect, int courseId, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String envelopePic, boolean fresh, int id, @org.jetbrains.annotations.NotNull()
    java.lang.String link, @org.jetbrains.annotations.NotNull()
    java.lang.String niceDate, @org.jetbrains.annotations.NotNull()
    java.lang.String origin, @org.jetbrains.annotations.NotNull()
    java.lang.String prefix, @org.jetbrains.annotations.NotNull()
    java.lang.String projectLink, long publishTime, int superChapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String superChapterName, @org.jetbrains.annotations.NotNull()
    java.lang.String shareUser, @org.jetbrains.annotations.NotNull()
    java.util.List<com.leshu.superbrain.data.bean.TagsResponse> tags, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int type, int userId, int visible, int zan) {
        return null;
    }
    
    /**
     * 文章
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * 文章
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 文章
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}