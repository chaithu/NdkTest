
#include <jni.h>
 jint  Java_com_example_chaitanyav_ndktestapp_MainActivity_sumTwoValues(JNIEnv*  env,jobject  this,jint  x, jint  y)
 {
     return (x + y);
 }