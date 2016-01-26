package com.nmbb.oplayer.po;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.File;

/**
 * * ��ƵPO��
 * Created by xuebp on 2016/1/26.
 */
@DatabaseTable(tableName ="media")
public class POMedia {
    @DatabaseField(generatedId = true)
    public long _id;
    /** ��Ƶ���� */
    @DatabaseField
    public String title;
    /** ��Ƶ����ƴ�� */
    @DatabaseField
    public String title_pinyin;
    /** ��Ƶ·�� */
    @DatabaseField
    public String path;
    /** ���һ�η���ʱ�� */
    @DatabaseField
    public long last_access_time;
    /**���һ���޸�ʱ��*/
    @DatabaseField
    public long last_modify_time;
    /** ��Ƶʱ�� */
    @DatabaseField
    public int duration;
    /** ��Ƶ���Ž��� */
    @DatabaseField
    public int position;
    /** ��Ƶ����ͼ·�� */
    @DatabaseField
    public String thumb_path;
    /** �ļ���С */
    @DatabaseField
    public long file_size;
    /** ��Ƶ��� */
    @DatabaseField
    public int width;
    /** ��Ƶ�߶� */
    @DatabaseField
    public int height;
    /** MIME���� */
    public String mime_type;
    /** 0 ������Ƶ 1 ������Ƶ */
    public int type = 0;
    /** �ļ�״̬0 - 10 �ֱ���� ���� 0-100% */
    public int status = -1;
    /** �ļ���ʱ��С �������� */
    public long temp_file_size = -1L;

    public POMedia() {

    }
    public POMedia(File f) {
        title = f.getName();
        path = f.getAbsolutePath();
        last_modify_time = f.lastModified();
        file_size = f.length();
    }

    public POMedia(String path, String mimeType) {
        this(new File(path));
        this.mime_type = mimeType;
    }



}
