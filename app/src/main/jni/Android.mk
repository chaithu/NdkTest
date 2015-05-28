LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := ndkTest
LOCAL_SRC_FILES := sample.c

include $(BUILD_SHARED_LIBRARY)