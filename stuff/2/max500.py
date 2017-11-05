# *-* coding:utf-8 *-*

"""
文件中各行已经根据时间排序
使用堆，返回出现次数前7的时间点
"""

class RecordHeap(object):
    """保存Record的list，同时保证list具备堆得性质，index为0的元素不使用"""
    def __init__(self, max_capacity):
        self.__result = ["None"]
        self.__max_capacity = max_capacity

    def add_record(self, record):
        """add a new record to heap"""
        if len(self.__result) < self.__max_capacity + 1:
            self.__result.append(record)
            self.sift_up()
        else:
            # compare the reocrd's count with the item[1]'s count. if bigger, the replace
            self.__result[1] = record
            self.sift_down()

    def sift_down(self):
        """heap sift down"""
        heap_length = len(self.__result)
        index = 1
        while index * 2 < heap_length:
            child_index = index * 2
            if child_index + 1 < heap_length:
                if self.__result[child_index].compare_count(self.__result[child_index + 1]) > 0:
                    child_index += 1

            if self.__result[index].compare_count(self.__result[child_index]) > 0:
                tmp = self.__result[index]
                self.__result[index] = self.__result[child_index]
                self.__result[child_index] = tmp
                index = child_index
            else:
                break


    def sift_up(self):
        """heap sift up"""
        index = len(self.__result) - 1
        while index > 1:
            if self.__result[index].compare_count(self.__result[index/2]) < 0:
                tmp = self.__result[index]
                self.__result[index] = self.__result[index/2]
                self.__result[index / 2] = tmp
                index = index / 2
            else:
                break
        return

    def print_result(self):
        """打印堆中元素"""
        for index in range(1, len(self.__result)):
            print self.__result[index]




class Record(object):
    """Record of time and count"""
    def __init__(self, time):
        self.__time = time
        self.__count = 1

    def same_time(self, time):
        """judeg time is the same"""
        return self.__time == time

    def count_plus_one(self):
        """count increase"""
        self.__count += 1

    def compare_count(self, record):
        """compare two item's count"""
        return self.__count - record.get_count()

    def get_count(self):
        """返回count"""
        return self.__count

    def __str__(self):
        return 'time is {0}, count is {1}'.format(self.__time, self.__count)


if __name__ == "__main__":
    record_heap = RecordHeap(7)

    fp_in = open("trade.log", 'r')

    # read first line
    first_line = fp_in.readline()
    current_time = first_line.split(",")[0]
    current_record = Record(current_time)

    for eachline in fp_in:
        next_time = eachline.split(",")[0]
        if current_record.same_time(next_time):
            current_record.count_plus_one()
        else:
            record_heap.add_record(current_record)
            current_record = Record(next_time)

    record_heap.add_record(current_record)
    record_heap.print_result()
