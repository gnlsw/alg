def sift_down(result):
    heap_length = len(result)
    index = 1
    while index * 2 < heap_length:
        child_index = index * 2
        if child_index + 1 < heap_length:
            if result[child_index].compare_count(result[child_index + 1]) > 0:
                child_index += 1

        if result[index].compare_count(result[child_index]) > 0:
            tmp = result[index]
            result[index] = result[child_index]
            result[child_index] = tmp
            index = child_index
        else:
            break


def sift_up(result):
    index = len(result) - 1
    while(index > 1):
        if(result[index].compare_count(result[index/2]) < 0):
            tmp = result[index]
            result[index] = result[index/2]
            result[index / 2] = tmp
            index = index / 2
        else:
            break
    return

def add_record(result, record):
    if len(result) < 8:
        result.append(record)
        sift_up(result);
    else:
        # compare the reocrd's count with the item[1]'s count
        # if bigger, the replace
        result[1] = record
        sift_down(result)

class Record:
    def __init__(self, time):
        self.time = time
        self.count = 1

    def same_time(self, time):
        if self.time == time:
            return True
        else:
            return False

    def count_plus_one(self):
        self.count += 1

    def compare_count(self, record):
        return self.count - record.count

    def __str__(self):
        return 'time is {0}, count is {1}'.format(self.time, self.count)


if __name__ == "__main__":
    result = []
    result.append('None')

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
            add_record(result, current_record)
            current_record = Record(next_time)

    add_record(result, current_record)
