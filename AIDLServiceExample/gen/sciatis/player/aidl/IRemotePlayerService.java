/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\adt-bundle\\workspace\\AIDLServiceExample\\src\\sciatis\\player\\aidl\\IRemotePlayerService.aidl
 */
package sciatis.player.aidl;
public interface IRemotePlayerService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements sciatis.player.aidl.IRemotePlayerService
{
private static final java.lang.String DESCRIPTOR = "sciatis.player.aidl.IRemotePlayerService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an sciatis.player.aidl.IRemotePlayerService interface,
 * generating a proxy if needed.
 */
public static sciatis.player.aidl.IRemotePlayerService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof sciatis.player.aidl.IRemotePlayerService))) {
return ((sciatis.player.aidl.IRemotePlayerService)iin);
}
return new sciatis.player.aidl.IRemotePlayerService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_startPlay:
{
data.enforceInterface(DESCRIPTOR);
this.startPlay();
reply.writeNoException();
return true;
}
case TRANSACTION_stopPlay:
{
data.enforceInterface(DESCRIPTOR);
this.stopPlay();
reply.writeNoException();
return true;
}
case TRANSACTION_sum:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.sum(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements sciatis.player.aidl.IRemotePlayerService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void startPlay() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_startPlay, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void stopPlay() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_stopPlay, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int sum(int a, int b) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(a);
_data.writeInt(b);
mRemote.transact(Stub.TRANSACTION_sum, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_startPlay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_stopPlay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_sum = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
public void startPlay() throws android.os.RemoteException;
public void stopPlay() throws android.os.RemoteException;
public int sum(int a, int b) throws android.os.RemoteException;
}
