# to reverse input string like stack using python list data type.
def reverseString(input):
    stack = []

    for i in input:
        stack.append(i)

    reverse = ""

    while stack:
        reverse += stack.pop()

    return reverse

arg = input("input string : ")
result = reverseString(arg)
print ("reversed string is : " + result)    
