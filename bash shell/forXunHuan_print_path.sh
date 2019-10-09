for x in `echo $(echo $PATH | tr ":" "\n")`
do
    echo $x
done
