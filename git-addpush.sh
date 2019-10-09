echo "############### param_ready ###############"
echo `date`
location="Home"
commit="更新"
today_commit_content="`date "+%Y%m%d_%H%M%S_%A"`_${location}_Update_${commit}"
echo ${today_commit_content}
echo
echo "############### shell start! ###############"
basepath=$(cd `dirname $0`; pwd)
cd ${basepath}
echo ${basepath}
echo
git add .
git commit -m ${today_commit_content}
echo
git push origin
echo
echo "############################################"
