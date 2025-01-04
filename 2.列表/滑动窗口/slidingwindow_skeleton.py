

def slidingWindow(s: str):
    window = []
    
    left = 0
    right = 0
    
    while right < len(s):
        cur = s[right]
        window.append(cur)
        right += 1
        
        # 进行窗口内数据的一系列更新
        
        while left < right and True:
            # d 是将移出窗口的字符
            d = s[left]
            window.remove(d)
            # 缩小窗口
            left += 1