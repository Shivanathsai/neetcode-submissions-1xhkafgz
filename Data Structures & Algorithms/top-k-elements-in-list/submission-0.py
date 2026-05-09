from collections import Counter
from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # Count frequency of each number
        count = Counter(nums)

        # Create buckets where index = frequency
        bucket = [[] for _ in range(len(nums) + 1)]

        for num, freq in count.items():
            bucket[freq].append(num)

        # Collect top k frequent elements
        res = []

        for freq in range(len(bucket) - 1, 0, -1):
            for num in bucket[freq]:
                res.append(num)

                if len(res) == k:
                    return res