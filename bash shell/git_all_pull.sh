#!/bin/zsh

function gitPull() {
    echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
    echo "##### ${1} git-pull start! #####"
    # echo ""
    cd ./${1}
    echo "cd `pwd`"
    # echo ""
    git pull
    # echo ""
    cd ..
    echo "cd `pwd`"
    # echo ""
    echo "##### ${1} git-pull over! #####"
    echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
}

##--------------------------------------------------------
##-- Here above are Function section
##--------------------------------------------------------


echo "############### shell start! ###############"
# cd ~/Workspace/git-workspace/
cd $1
echo "cd `pwd`"

#:<<!
# For循环 拉取
for dir in `ls -F | grep "/$"`  # 注意：`ls -d *`不过滤符文链接文件，所以不能用
do
    dir=${dir%/*}    # 注意：变量赋值不加$，只有使用时才加$
#    if [ ${dir} = "git-java" ]
#    then
#        continue
#    fi
    gitPull ${dir}
done
#!

:<<!
# 对指定项目目录 拉取
gitPull "git-groovy"
gitPull "git-python"
gitPull "git-soapui"
gitPull "git-robotframework"
!

echo "############################################"

