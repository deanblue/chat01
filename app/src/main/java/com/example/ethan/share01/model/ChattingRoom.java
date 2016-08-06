package com.example.ethan.share01.model;

/**
 * Created by Lai.OH on 2016-07-27.
 */
public class ChattingRoom {
    private int mChatRoomID;
    private int mRecv_id;
    private String mRecv_name;
    private String mMsg;
    private String mSended;

    public ChattingRoom(int chatRoomID, int recv_id, String mRecv_name, String msg, String sended) {
        this.mChatRoomID = chatRoomID;
        this.mRecv_id = recv_id;
        this.mRecv_name = mRecv_name;
        this.mMsg = msg;
        this.mSended = sended;
    }

    public String getRecv_name() {
        return mRecv_name;
    }

    public void setRecv_name(String recv_name) {
        mRecv_name = recv_name;
    }

    public int getChatRoomID() {
        return mChatRoomID;
    }

    public void setChatRoomID(int chatRoomID) {
        mChatRoomID = chatRoomID;
    }

    public int getRecv_id() {
        return mRecv_id;
    }

    public void setRecv_id(int recv_id) {
        mRecv_id = recv_id;
    }

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }

    public String getSended() {
        return mSended;
    }

    public void setSended(String sended) {
        mSended = sended;
    }
}