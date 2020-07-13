#!/usr/bin/env bash
#说明：该脚本是SDK上传到jcenter的脚本，如需修改；请找杨高升同步情况。


filename=local.properties
bak=$IFS                     #定义一个变量bak保存IFS的值
IF_FileName=duobeijcenterkey=
keystr=""
#if [ $# -ne 1 ];then             #判断位置参数是否为1
#  echo "Usage $0 filename"
#  exit
#fi
if [ ! -f $filename ];then               #判断位置参数是否为文件
  echo "the $filename is not a file"
  exit
fi
IFS=$'\n'                    #将环境变量IFS的值修改为换行符
for i in `cat $filename`                #逐行读取文件内容并打印到屏幕
do
 if [[ $i == $IF_FileName* ]];
 then
 echo $i

    IFS='='

    array=($i)
    keystr=(${array[1]})
    echo $keystr
 fi
done
IFS=$bak
if [[ $i == "" ]]; then

    echo "key not found"
    exit
fi

./gradlew clean assembleRelease bintrayUpload -PbintrayUser=yangge -PbintrayKey=$keystr -PdryRun=false -Pandroid.debug.obsoleteApi=true

