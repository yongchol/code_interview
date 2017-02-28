# to decide if two strings are anagrams or not.

# function 1. sort strings and compare them.
def func1_anagram(str1, str2):
    s1 = ''.join(sorted(str1.lower())).strip()  # in case of, lower/upper cases and empty space
    s2 = ''.join(sorted(str2.lower())).strip()

    if(s1 == s2):
        return True
    else:
        return False


# function 2. check if two strings have identical counts for each unique char.
def func2_anagram(str1, str2):
    if(len(str1) != len(str2)) : # check two strings length
        return False

    array = [0]*26

    # check count for each first string's char
    for i in range(len(str1)):
        pos = ord(str1[i]) - ord('a') # use ascii code
        array[pos] += 1

    # check second string
    for i in range(len(str2)):
        pos = ord(str2[i]) - ord('a')
        array[pos] -= 1 # decrease index of second string's each char
        if(array[pos] < 0):   # check if counted array is not match
            return False

    return True


result1 = func1_anagram("python", "typhon")
print ("check anagram by function 1 : ")
print (result1)

result2 = func2_anagram("python", "typhon")
print ("check anagram by function 2 : ")
print (result2)
