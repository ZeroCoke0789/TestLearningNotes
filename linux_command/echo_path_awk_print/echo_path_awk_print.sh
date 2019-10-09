# !/bin/zsh

# mac上换行打印PATH变量的内容（awk应用）
echo $PATH | awk 'BEGIN{RS=":"}{print}'

read -n 1 -p "Run over. Press any key to exit."
