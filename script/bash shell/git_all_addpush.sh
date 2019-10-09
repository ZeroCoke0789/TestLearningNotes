#!/bin/zsh

function gitPush() {
    echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
    echo "##### ${1} git-push start! #####"
    # echo ""
    cd ./${1}
    echo "cd `pwd`"
    echo "-----"
    git add .
    git commit -m ${2}
    echo ""
    git push origin
    echo "-----"
    cd ..
    echo "cd `pwd`"
    # echo ""
    echo "##### ${1} git-push over! #####"
    echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
    echo
}

##--------------------------------------------------------
##-- Here above are Function section
##--------------------------------------------------------


echo "############### param_ready ###############"
echo `date`
today=`date "+%Y%m%d_%H%M%S_%A"`
today_commit_content="${today}_Home_Update_By_Shell"
# today_commit_content=${today_commit_content}"_更新周末使用"
echo ${today_commit_content}
echo
echo "############### shell start! ##############"
# cd ~/Workspace/git-workspace/
cd $1
echo "cd `pwd`"
echo

# :<<!
# For循环 提交并推送
for dir in `ls -F | grep "/$"`
do
    dir=${dir%/*}    # 注意：变量赋值不加$，只有使用时才加$
    if [ ${dir} = "git-java" ]
    then
        continue
    fi
    gitPush ${dir} ${today_commit_content}
done
# !

# 对指定项目目录 提交并推送
# gitPush "git-python" ${today_commit_content}
# gitPush "git-soapui" ${today_commit_content}

echo "############################################"



