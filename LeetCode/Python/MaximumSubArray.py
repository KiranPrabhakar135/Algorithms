def max_sub_array(nums, sum_result):

    if len(nums) == 0:
        return 0

    sum_result = nums[0] + max_sub_array(nums[1:], sum_result)
    return sum_result


a = [-2,1,-3,4,-1,2,1,-5,4]

print(max_sub_array(a,0))