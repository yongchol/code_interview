def isUniqChars(str):
    if len(str) > 256:
        return False

    flag = {}

    for ch in str:
        if ch in flag:
            return False
        else:
            flag[ch] = True
    return True

input_unique = "abcde"
input_not_unique = "abcdea"

if isUniqChars(input_not_unique):
    print("unique")
else:
    print("not_unique")
