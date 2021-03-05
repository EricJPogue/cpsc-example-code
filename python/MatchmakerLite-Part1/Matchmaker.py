# Eric Pogue
# Matchmaker Lite

print("")
print("Matchmaker 2021")
print("")
print("[[Your instructions here.")
print("")

UserResponse1 = int(input("Iowa Hawkeye football rocks!"))
desiredResponse1 = 5 
compatability1 = 5 - abs(UserResponse1 - desiredResponse1)
print("Question 1 compatability: " + str(compatability1))
print("")

UserResponse2 = int(input("European soccer is the greatest sport in the world!"))
desiredResponse2 = 2
compatability2 = 5 - abs(UserResponse2 - desiredResponse2)
print("Question 2 compatability: " + str(compatability2))
print("")

totalCompatibility = (compatability1 + compatability2) * 10
print("Total Compatability: " + str(totalCompatibility))
print("")
