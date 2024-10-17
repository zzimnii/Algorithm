def solution(s):
    answer = ''
    s = s.split(" ")
    
    for i in range(len(s)):
       # 빈 문자열인 경우 그대로 두기!!
       if s[i]:
           # 문자열은 불변임! 대소문자 변환후 문자열로 저장하도록
           s[i] =  s[i][0].upper() + s[i][1:].lower()

    answer = " ".join(s)
    return answer

solution("3people unFollowed me")
solution("for the last week")