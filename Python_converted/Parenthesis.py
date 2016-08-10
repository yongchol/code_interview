"""
Date : 2016-08-10
Author : Yongchol Shin
Descrption : to find valid parenthesis string
"""

def isValidLine(str) :
    cnt = 0

    for i in range(0,len(str)) :
        s = str[i]
        # meet char '(', count increased like stack push
        if s == "(" :
            cnt = cnt + 1
        # meets char ')', count decreased like stach pop
        else :
            cnt = cnt - 1
        if(cnt < 0) :
            return "NO"

    # if stack is empty, then return YES means valid string
    if(cnt == 0) :
        return "YES"
    # if stack is not empty, then return NO means not valid string
    else :
        return "NO"


print(isValidLine('(((()()(()))))'))
print(isValidLine('(()'))
